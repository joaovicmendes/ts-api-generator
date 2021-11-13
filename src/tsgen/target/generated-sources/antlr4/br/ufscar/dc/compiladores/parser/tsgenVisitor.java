// Generated from br/ufscar/dc/compiladores/parser/tsgen.g4 by ANTLR 4.9.2
package br.ufscar.dc.compiladores.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tsgenParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tsgenVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tsgenParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(tsgenParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#models}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModels(tsgenParser.ModelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(tsgenParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(tsgenParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#endpoints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndpoints(tsgenParser.EndpointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#endpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndpoint(tsgenParser.EndpointContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#route}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoute(tsgenParser.RouteContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsgenParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(tsgenParser.MethodContext ctx);
}