// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/enums2/Enums2.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.enums2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Enums2Parser}.
 */
public interface Enums2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Enums2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(Enums2Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Enums2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(Enums2Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Enums2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(Enums2Parser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Enums2Parser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(Enums2Parser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link Enums2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Enums2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Enums2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Enums2Parser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Enums2Parser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(Enums2Parser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Enums2Parser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(Enums2Parser.EnumDeclContext ctx);
}