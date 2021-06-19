// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/enums/Enums.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.enums;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EnumsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EnumsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EnumsParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(EnumsParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnumsParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(EnumsParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnumsParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(EnumsParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnumsParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(EnumsParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EnumsParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(EnumsParser.IdContext ctx);
}