// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/expression/Expression.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.expression;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExpressionParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExpressionParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ExpressionParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ExpressionParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExpressionParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExpressionParser.ExprContext ctx);
}