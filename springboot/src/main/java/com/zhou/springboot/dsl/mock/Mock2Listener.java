// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/mock/Mock2.g4 by ANTLR 4.9
package com.zhou.springboot.dsl.mock;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Mock2Parser}.
 */
public interface Mock2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Mock2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(Mock2Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mock2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(Mock2Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mock2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(Mock2Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mock2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(Mock2Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mock2Parser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(Mock2Parser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mock2Parser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(Mock2Parser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code array}
	 * labeled alternative in {@link Mock2Parser#singleVar}.
	 * @param ctx the parse tree
	 */
	void enterArray(Mock2Parser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code array}
	 * labeled alternative in {@link Mock2Parser#singleVar}.
	 * @param ctx the parse tree
	 */
	void exitArray(Mock2Parser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code obj}
	 * labeled alternative in {@link Mock2Parser#singleVar}.
	 * @param ctx the parse tree
	 */
	void enterObj(Mock2Parser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code obj}
	 * labeled alternative in {@link Mock2Parser#singleVar}.
	 * @param ctx the parse tree
	 */
	void exitObj(Mock2Parser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mock2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Mock2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mock2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Mock2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mock2Parser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(Mock2Parser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mock2Parser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(Mock2Parser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link Mock2Parser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(Mock2Parser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Mock2Parser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(Mock2Parser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void enterNum(Mock2Parser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void exitNum(Mock2Parser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void enterStr(Mock2Parser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void exitStr(Mock2Parser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void enterBool(Mock2Parser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void exitBool(Mock2Parser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nil}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void enterNil(Mock2Parser.NilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nil}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 */
	void exitNil(Mock2Parser.NilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link Mock2Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(Mock2Parser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link Mock2Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(Mock2Parser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link Mock2Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(Mock2Parser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link Mock2Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(Mock2Parser.IntegerLiteralContext ctx);
}