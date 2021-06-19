// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/enums/Enums.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.enums;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EnumsParser}.
 */
public interface EnumsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EnumsParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(EnumsParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnumsParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(EnumsParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnumsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(EnumsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnumsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(EnumsParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnumsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EnumsParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnumsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EnumsParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnumsParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(EnumsParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnumsParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(EnumsParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EnumsParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(EnumsParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EnumsParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(EnumsParser.IdContext ctx);
}