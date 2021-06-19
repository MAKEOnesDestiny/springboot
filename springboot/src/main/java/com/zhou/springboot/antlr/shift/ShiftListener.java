// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/shift/Shift.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.shift;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShiftParser}.
 */
public interface ShiftListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShiftParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ShiftParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShiftParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ShiftParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShiftParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ShiftParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShiftParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ShiftParser.ExprContext ctx);
}