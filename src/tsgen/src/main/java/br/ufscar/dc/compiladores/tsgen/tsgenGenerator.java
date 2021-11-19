package br.ufscar.dc.compiladores.tsgen;

import br.ufscar.dc.compiladores.parser.tsgenBaseVisitor;
import br.ufscar.dc.compiladores.parser.tsgenParser;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

public class tsgenGenerator extends tsgenBaseVisitor<Void> {
    Map<String, ModelClass> models;
    Map<String, Endpoint> endpoints;
    public StringBuilder outputCode;

    @Override
    public Void visitProgram(tsgenParser.ProgramContext ctx) {
        models = new HashMap<>();
        endpoints = new HashMap<>();
        outputCode = new StringBuilder();

        outputCode.append("import express from 'express';\n");
        outputCode.append("import { Sequelize, Model, DataTypes } from 'sequelize';\n\n");
        outputCode.append("const port = process.env.PORT || 3000;\n");
        outputCode.append("const app = express();\n");
        outputCode.append("app.use(express.json());\n");
        outputCode.append("const sequelize = new Sequelize('sqlite::memory:');\n\n");

        super.visitProgram(ctx);

        outputCode.append("app.listen(port, () => {\n");
        outputCode.append("    console.log(`Server running at localhost:${port}`);\n");
        outputCode.append("});\n");
        return null;
    }

    @Override
    public Void visitModels(tsgenParser.ModelsContext ctx) {
        outputCode.append("// model\n");
        super.visitModels(ctx);
        outputCode.append("const initModel = async () => {\n");
        outputCode.append("    await sequelize.sync();\n");
        outputCode.append("}\n");
        outputCode.append("initModel();\n");
        outputCode.append("// model-end\n\n");
        return null;
    }

    @Override
    public Void visitModel(tsgenParser.ModelContext ctx) {
        String id = ctx.IDENT().getText();
        ModelClass modelClass = new ModelClass();

        for (var field : ctx.fields) {
            String fieldName = field.ident.getText();
            Type type = Utils.mapStringToType( field.type.getText() );
            modelClass.add(type, fieldName);
        }
        models.put(id, modelClass);

        outputCode.append("class ");
        outputCode.append(id);
        outputCode.append(" extends Model {};\n");

        outputCode.append(id);
        outputCode.append(".init({\n");

        for (var field : modelClass.fields) {
            outputCode.append("        ");
            outputCode.append(field.id());
            outputCode.append(": ");
            outputCode.append(Utils.mapTypeToSequelize(field.type()));
            outputCode.append(",\n");
        }

        outputCode.append("    }, {sequelize, modelName: '");
        outputCode.append(id);
        outputCode.append("'}\n");
        outputCode.append(");\n\n");

        return super.visitModel(ctx);
    }

    @Override
    public Void visitEndpoints(tsgenParser.EndpointsContext ctx) {
        outputCode.append("// endpoints\n");
        super.visitEndpoints(ctx);
        outputCode.append("// endpoints-end\n\n");
        return null;
    }

    @Override
    public Void visitEndpoint(tsgenParser.EndpointContext ctx) {
        String id = ctx.IDENT().getText();

        Endpoint currEndpoint = new Endpoint();
        for (var route : ctx.routes) {
            String uri = route.STRING().getText();
            Route.Method method = Utils.mapStringToMethod(route.method().getText());

            currEndpoint.add(method, uri);
        }

        endpoints.put(id, currEndpoint);

        for (var route : currEndpoint.routes) {
            generateRouteCode(id, route);
        }

        return super.visitEndpoint(ctx);
    }

    private void generateRouteCode(String id, Route route) {
        switch (route.method) {
            case GET:
                generateGetCode(id, route.uri);
                break;
            case POST:
                generatePostCode(id, route.uri);
                break;
            case PUT:
                generatePutCode(id, route.uri);
                break;
            case DELETE:
                generateDeleteCode(id, route.uri);
                break;
        }
    }

    private void generateGetCode(String id, String uri) {
        outputCode.append("app.get(");
        outputCode.append(uri);
        outputCode.append(", async (req, res) => {\n");

        outputCode.append("    const variable = await ");
        outputCode.append(id);
        String routeId = Utils.extractRouteId(uri);
        if (routeId == null) {
            outputCode.append(".findAll();\n");
        } else {
            outputCode.append(".findOne({\n");
            outputCode.append("        where: {\n");
            outputCode.append("            ");
            outputCode.append(routeId);
            outputCode.append(": req.params.");
            outputCode.append(routeId);
            outputCode.append("\n        }\n");
            outputCode.append("    });\n");
        }

        outputCode.append("    res.status(200).send(JSON.stringify(variable));\n");
        outputCode.append("});\n\n");
    }

    private void generatePostCode(String id, String uri) {
        outputCode.append("app.post(");
        outputCode.append(uri);
        outputCode.append(", async (req, res) => {\n");

        outputCode.append("    const variable = await ");
        outputCode.append(id);
        outputCode.append(".create(req.body);\n");

        outputCode.append("    res.status(200).send(JSON.stringify(variable));\n");
        outputCode.append("});\n\n");
    }

    private void generatePutCode(String id, String uri) {
        outputCode.append("app.put(");
        outputCode.append(uri);
        outputCode.append(", async (req, res) => {\n");

        outputCode.append("    ");
        outputCode.append(id);
        String routeId = Utils.extractRouteId(uri);
        outputCode.append(".update(req.body, {\n");
        outputCode.append("        where: {\n");
        outputCode.append("            ");
        outputCode.append(routeId);
        outputCode.append(": req.params.");
        outputCode.append(routeId);
        outputCode.append("\n        }\n");
        outputCode.append("    });\n");

        outputCode.append("    res.status(200).send();\n");
        outputCode.append("});\n\n");
    }

    private void generateDeleteCode(String id, String uri) {
        outputCode.append("app.delete(");
        outputCode.append(uri);
        outputCode.append(", async (req, res) => {\n");

        outputCode.append("    ");
        outputCode.append(id);
        String routeId = Utils.extractRouteId(uri);
        outputCode.append(".destroy({\n");
        outputCode.append("        where: {\n");
        outputCode.append("            ");
        outputCode.append(routeId);
        outputCode.append(": req.params.");
        outputCode.append(routeId);
        outputCode.append("\n        }\n");
        outputCode.append("    });\n");

        outputCode.append("    res.status(200).send();\n");
        outputCode.append("});\n\n");
    }
}
