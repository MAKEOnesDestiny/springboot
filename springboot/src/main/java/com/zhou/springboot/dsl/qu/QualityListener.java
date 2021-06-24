// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/Quality.g4 by ANTLR 4.9
package com.zhou.springboot.dsl.qu;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QualityParser}.
 */
public interface QualityListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QualityParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(QualityParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link QualityParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(QualityParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link QualityParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(QualityParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QualityParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(QualityParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Function}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction(QualityParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Function}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction(QualityParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(QualityParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(QualityParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(QualityParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decimal}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(QualityParser.DecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(QualityParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(QualityParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(QualityParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(QualityParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(QualityParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(QualityParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare(QualityParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compare}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare(QualityParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(QualityParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(QualityParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AndOr}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndOr(QualityParser.AndOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AndOr}
	 * labeled alternative in {@link QualityParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndOr(QualityParser.AndOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link QualityParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(QualityParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link QualityParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(QualityParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link QualityParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(QualityParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link QualityParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(QualityParser.ColumnContext ctx);
}