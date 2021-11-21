package br.ufscar.dc.compiladores.tsgen;

import br.ufscar.dc.compiladores.parser.tsgenBaseVisitor;
import br.ufscar.dc.compiladores.parser.tsgenParser;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

public class tsgenSemantic extends tsgenBaseVisitor<Void> {
    Map<String, ModelClass> models;
    Map<String, Endpoint> endpoints;

    @Override
    public Void visitProgram(tsgenParser.ProgramContext ctx) {
        models = new HashMap<>();
        endpoints = new HashMap<>();

        return super.visitProgram(ctx);
    }

    @Override
    /* Deve verificar:
    *  1. se a Classe foi declarada anteriormente
    *  2. para cada campo da classe, se o campo já foi declarado
    *  3. para cada campo da classe, se o tipo existe
    */
    public Void visitModel(tsgenParser.ModelContext ctx) {
        String id = ctx.IDENT().getText();
        if (models.containsKey(id)) {
            errorIdentifierDeclared(id, ctx.IDENT().getSymbol());
            return null; // @TODO: should be here?
        }

        ModelClass modelClass = new ModelClass();

        for (var field : ctx.fields) {
            String fieldName = field.ident.getText();
            if (modelClass.contains(fieldName)) {
                errorIdentifierDeclared(fieldName, field.ident);
            }

            if (fieldName.equals("id") || fieldName.equals("createdAt") || fieldName.equals("updatedAt")) {
                errorNameNotAllowed(fieldName, field.ident);
            }

            Type type = Utils.mapStringToType( field.type.getText() );
            if (type == Type.Class) {
                errorIdentifierNotAllowedInScope(field.type.getText(), field.type);
            }
            // if (type == Type.Class && !models.containsKey(field.type.getText())) {
            //     errorIdentifierNotDeclared(field.type.getText(), field.type);
            // }

            modelClass.add(type, fieldName);
        }

        models.put(id, modelClass);
        return super.visitModel(ctx);
    }

    @Override
    /* Deve verificar:
     *  1. se a Classe foi declarada anteriormente
     *  2. se o Endpoint foi declarado anteriormente
     *  3. para cada rota do endpoint, se a rota já foi declarada
     *  4. para cada rota do endpoint, se existe identificador :id
     *  5. para cada rota do endpoint, se o identificador :id existe na classe
     *  6. para cada rota do endpoint, se o identificador :id é uma classe
     */
    public Void visitEndpoint(tsgenParser.EndpointContext ctx) {
        String id = ctx.IDENT().getText();

        if (!models.containsKey(id)) {
            errorIdentifierNotDeclared(id, ctx.IDENT().getSymbol());
            return null; // @TODO: should be here?
        }

        if (endpoints.containsKey(id)) {
            errorIdentifierDeclared(id, ctx.IDENT().getSymbol());
            return null; // @TODO: should be here?
        }

        Endpoint currEndpoint = new Endpoint();
        for (var route : ctx.routes) {
            String uri = route.STRING().getText();
            Route.Method method = Utils.mapStringToMethod(route.method().getText());

            if (currEndpoint.contains(method, uri)) {
                errorRouteDeclared(route.method().getText(), uri, route.getStart());
            }

            String routeId = Utils.extractRouteId(uri);
            if (routeId != null) {
                if (method == Route.Method.POST) {
                    errorShouldNotContainRouteId(route.method().getText(), route.getStart());
                }

                ModelClass modelClass = models.get(id);
                if (!modelClass.contains(routeId)) {
                    errorIdentifierNotDeclared(routeId, route.getStart());
                } else {
                    Type routeIdType = modelClass.getField(routeId).type();
                    if (routeIdType == Type.Class) {
                        errorTypeNotAllowed(route.getStart());
                    }
                }
            } else if (method == Route.Method.PUT || method == Route.Method.DELETE) {
                errorShouldContainRouteId(route.method().getText(), route.getStart());
            }

            currEndpoint.add(method, uri);
        }

        endpoints.put(id, currEndpoint);
        return super.visitEndpoint(ctx);
    }

    public void errorIdentifierDeclared(String id, Token tk) {
        Utils.addSemanticError(tk, String.format("identificador %s já declarado anteriormente", id));
    }

    public void errorIdentifierNotDeclared(String id, Token tk) {
        Utils.addSemanticError(tk, String.format("identificador %s não declarado anteriormente", id));
    }

    public void errorIdentifierNotAllowedInScope(String id, Token tk) {
        Utils.addSemanticError(tk, String.format("%s - aninhamento de classes do modelo não permitido", id));
    }

    public void errorRouteDeclared(String method, String uri, Token tk) {
        Utils.addSemanticError(tk, String.format("rota %s %s declarado anteriormente", method, uri));
    }

    public void errorTypeNotAllowed(Token tk) {
        Utils.addSemanticError(tk, "tipos declarados no modelo não são permitidos como identificador de rotas");
    }

    public void errorShouldContainRouteId(String method, Token tk) {
        Utils.addSemanticError(tk, String.format("método %s deveria conter um identificador", method));
    }

    public void errorShouldNotContainRouteId(String method, Token tk) {
        Utils.addSemanticError(tk, String.format("método %s não deveria conter um identificador", method));
    }

    public void errorNameNotAllowed(String id, Token tk) {
        Utils.addSemanticError(tk, String.format("nome de identificador %s não permitido", id));
    }
}
