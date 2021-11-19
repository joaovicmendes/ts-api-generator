package br.ufscar.dc.compiladores.tsgen;

import br.ufscar.dc.compiladores.parser.tsgenLexer;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    /* Lista dos erros semânticos encontrados pelo tsgenSemantic */
    public static List<String> semanticErrors = new ArrayList<>();

    /* Conjunto que representa os tokens de erro da linguagem. */
    private static final Map<Integer, String> errorTokens = new HashMap<>() {{
        put(tsgenLexer.UNCLOSED_STRING, "cadeia literal nao fechada");
        put(tsgenLexer.INVALID_CHAR, "simbolo nao identificado");
    }};

    /* Função que recebe um tipo de Token e retorna se esse tipo está
       presente no conjunto de token de erro. */
    public static Boolean isError(int tkType) {
        return errorTokens.containsKey(tkType);
    }

    /* Função que recebe um Token de erro e o formata de forma especial. */
    public static String stringifyError(Token tk) {
        StringBuilder tkString = new StringBuilder();
        tkString.append("Linha ");
        tkString.append(tk.getLine());
        tkString.append(": ");

        if (tk.getType() == tsgenLexer.INVALID_CHAR) {
            tkString.append(tk.getText());
            tkString.append(" - ");
        }

        tkString.append(errorTokens.getOrDefault(tk.getType(), ""));

        return tkString.toString();
    }

    /* Função que recebe um Token e retorna sua forma em String apropriada. */
    public static String stringify(Token tk) {
        if (Utils.isError(tk.getType())) {
            return stringifyError(tk);
        }

        StringBuilder tkString = new StringBuilder();
        tkString.append('<');
        tkString.append("'");
        tkString.append(tk.getText());
        tkString.append("'");
        tkString.append(",");
        tkString.append(tsgenLexer.VOCABULARY.getDisplayName(tk.getType()));
        tkString.append(">");

        return tkString.toString();
    }

    /* Função que recebe uma linha onde o erro aconteceu e o Token que falhou. Retorna
       a forma em String do erro. */
    public static String stringifySyntaxError(int line, Token tk) {
        StringBuilder tkString = new StringBuilder();
        tkString.append("Linha ");
        tkString.append(line);
        tkString.append(": erro sintático próximo a ");

        if (tk.getType() == tsgenLexer.EOF) {
            tkString.append("EOF");
        } else {
            tkString.append(tk.getText());
        }

        return tkString.toString();
    }

    /* Função que recebe o token onde um erro aconteceu e uma mensagem e adiciona a
   lista de erros semânticos. */
    public static void addSemanticError(Token tk, String msg) {
        semanticErrors.add(String.format("Linha %d: %s", tk.getLine(), msg));
    }

    /* Função que recebe uma cadeia e mapeia para o Type adequado */
    public static Type mapStringToType(String type) {
        switch (type) {
            case "string":
                return Type.String;
            case "number":
                return Type.Number;
            case "boolean":
                return Type.Boolean;
            default:
                return Type.Class;
        }
    }

    /* Função que recebe uma cadeia e mapeia para o Route.Method adequado */
    public static Route.Method mapStringToMethod(String type) {
        switch (type) {
            case "GET":
                return Route.Method.GET;
            case "POST":
                return Route.Method.POST;
            case "PUT":
                return Route.Method.PUT;
            case "DELETE":
                return Route.Method.DELETE;
            default:
                return Route.Method.Invalid;
        }
    }

    /* Função que recebe uma cadeia e recorta o elemento contido entre ':' e '/'.
    *  ex:
    *  foo/:bar      -> bar
    *  foo/:bar/test -> bar
    *  foo/bar       -> null */
    public static String extractRouteId(String uri) {
        if (uri.contains(":")) {
            String secondHalf = uri.split(":")[1];
            if (!secondHalf.contains("/")) {
                return secondHalf.substring(0, secondHalf.length()-1);
            }
            return secondHalf.split("/")[0];
        }
        return null;
    }

    /* Função que recebe um tipo e retorna seu mapeamento para o Sequelize */
    public static String mapTypeToSequelize(Type type) {
        switch (type) {
            case String:
                return "DataTypes.STRING";
            case Number:
                return "DataTypes.NUMBER";
            case Boolean:
                return "DataTypes.BOOLEAN";
            default:
                return "DataTypes.STRING";
        }
    }
}
