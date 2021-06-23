// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/Quality.g4 by ANTLR 4.9
package com.zhou.springboot.dsl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QualityParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QualityVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QualityParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(QualityParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link QualityParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(QualityParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(QualityParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(QualityParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(QualityParser.DecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(QualityParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(QualityParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(QualityParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(QualityParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(QualityParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndOr}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOr(QualityParser.AndOrContext ctx);
	/**
	 * Visit a parse tree produced by {@link QualityParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(QualityParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link QualityParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(QualityParser.ColumnContext ctx);
}