package br.ufscar.dc.compiladores.tsgen;

import br.ufscar.dc.compiladores.parser.tsgenLexer;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

public class Utils {
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
}
