// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/enums2/Enums2.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.enums2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Enums2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Enums2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Enums2Parser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(Enums2Parser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Enums2Parser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(Enums2Parser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Enums2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Enums2Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Enums2Parser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(Enums2Parser.EnumDeclContext ctx);
}