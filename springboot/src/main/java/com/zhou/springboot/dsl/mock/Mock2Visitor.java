// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/dsl/mock/Mock2.g4 by ANTLR 4.9
package com.zhou.springboot.dsl.mock;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Mock2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Mock2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Mock2Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(Mock2Parser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mock2Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Mock2Parser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mock2Parser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(Mock2Parser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link Mock2Parser#singleVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(Mock2Parser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code obj}
	 * labeled alternative in {@link Mock2Parser#singleVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(Mock2Parser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mock2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Mock2Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mock2Parser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(Mock2Parser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link Mock2Parser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(Mock2Parser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(Mock2Parser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code str}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(Mock2Parser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(Mock2Parser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nil}
	 * labeled alternative in {@link Mock2Parser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNil(Mock2Parser.NilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link Mock2Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(Mock2Parser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link Mock2Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(Mock2Parser.IntegerLiteralContext ctx);
}