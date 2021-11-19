package br.ufscar.dc.compiladores.tsgen;

import java.io.IOException;
import java.io.PrintWriter;

import br.ufscar.dc.compiladores.parser.tsgenParser;
import br.ufscar.dc.compiladores.parser.tsgenLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class Main {
    public static void main(String[] args) {
        // Verificação do número de argumentos
        if (args.length < 2) {
            System.out.println("Erro: Número incorreto de parâmetros. Forma correta:");
            System.out.println("    java -jar ts-api-gen.jar <input_file> <output_file>");
        }

        // Leitura de arquivo contendo código-fonte
        CharStream cs;
        try {
            cs = CharStreams.fromFileName(args[0]);
        } catch (IOException exception) {
            System.out.println("Erro: Não foi possível abrir o arquivo '" + args[0] + "'");
            return;
        }

        // Criação de analisador léxico e sintático
        tsgenLexer scanner = new tsgenLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(scanner);
        tsgenParser parser = new tsgenParser(cts);

        try (PrintWriter writer = new PrintWriter(args[1])) {
            // Adicionado tratamento de erros customizado
            ErrorListener customErrListener = new ErrorListener(writer);
            parser.removeErrorListeners();
            parser.addErrorListener(customErrListener);

            // Analise sintática
            tsgenParser.ProgramContext tree = parser.program();
            // Análise semântica
            tsgenSemantic semantic = new tsgenSemantic();
            semantic.visitProgram(tree);

            if (!Utils.semanticErrors.isEmpty()) {
                // Imprimindo erros
                Utils.semanticErrors.forEach(writer::println);
                writer.println("Compilação interrompida.");
            } else {
                writer.write("Compilado com sucesso.");
            }
        } catch (IOException exception) {
            System.out.println("Erro: Não foi possível abrir o arquivo '" + args[1] + "'");
        } catch (ParseCancellationException ignored) {}
    }
}
