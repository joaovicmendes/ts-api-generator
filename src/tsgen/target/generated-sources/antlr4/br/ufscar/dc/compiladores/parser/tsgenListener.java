// Generated from br/ufscar/dc/compiladores/parser/tsgen.g4 by ANTLR 4.9.2
package br.ufscar.dc.compiladores.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tsgenParser}.
 */
public interface tsgenListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tsgenParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(tsgenParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(tsgenParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#models}.
	 * @param ctx the parse tree
	 */
	void enterModels(tsgenParser.ModelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#models}.
	 * @param ctx the parse tree
	 */
	void exitModels(tsgenParser.ModelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(tsgenParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(tsgenParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(tsgenParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(tsgenParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#endpoints}.
	 * @param ctx the parse tree
	 */
	void enterEndpoints(tsgenParser.EndpointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#endpoints}.
	 * @param ctx the parse tree
	 */
	void exitEndpoints(tsgenParser.EndpointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#endpoint}.
	 * @param ctx the parse tree
	 */
	void enterEndpoint(tsgenParser.EndpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#endpoint}.
	 * @param ctx the parse tree
	 */
	void exitEndpoint(tsgenParser.EndpointContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#route}.
	 * @param ctx the parse tree
	 */
	void enterRoute(tsgenParser.RouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#route}.
	 * @param ctx the parse tree
	 */
	void exitRoute(tsgenParser.RouteContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsgenParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(tsgenParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsgenParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(tsgenParser.MethodContext ctx);
}