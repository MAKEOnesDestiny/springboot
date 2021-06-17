// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/simple/Simple.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.simple;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(SimpleParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(SimpleParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleParser.ExprContext ctx);
}