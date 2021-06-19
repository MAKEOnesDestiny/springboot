// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/shift/Shift.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.shift;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShiftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShiftVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShiftParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ShiftParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShiftParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ShiftParser.ExprContext ctx);
}