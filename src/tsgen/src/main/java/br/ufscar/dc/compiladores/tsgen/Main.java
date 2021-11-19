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
        if (args.length < 1) {
            System.out.println("Erro: Número incorreto de parâmetros. Forma correta:");
            System.out.println("    java -jar ts-api-gen.jar <input_file>");
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

        try (PrintWriter writer = new PrintWriter("index.ts")) {
            // Adicionado tratamento de erros customizado
            ErrorListener customErrListener = new ErrorListener();
            parser.removeErrorListeners();
            parser.addErrorListener(customErrListener);

            // Analise sintática
            tsgenParser.ProgramContext tree = parser.program();
            // Análise semântica
            tsgenSemantic semantic = new tsgenSemantic();
            semantic.visitProgram(tree);

            if (!Utils.semanticErrors.isEmpty()) {
                // Imprimindo erros
                Utils.semanticErrors.forEach(System.out::println);
                System.out.println("Compilação interrompida.");
            } else {
                System.out.println("Compilado com sucesso.");
                tsgenGenerator generator = new tsgenGenerator();
                generator.visitProgram(tree);
                writer.println(generator.outputCode.toString());
            }
        } catch (IOException exception) {
            System.out.println("Erro: Não foi possível abrir o arquivo '" + args[1] + "'");
        } catch (ParseCancellationException ignored) {}
    }
}
