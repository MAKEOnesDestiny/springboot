// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/channel/Channel.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.channel;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ChannelParser}.
 */
public interface ChannelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ChannelParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ChannelParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChannelParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ChannelParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChannelParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ChannelParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChannelParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ChannelParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChannelParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ChannelParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChannelParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ChannelParser.ExprContext ctx);
}