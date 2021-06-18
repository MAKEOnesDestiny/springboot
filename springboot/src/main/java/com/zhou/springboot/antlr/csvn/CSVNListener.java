// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/csvn/CSVN.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.csvn;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSVNParser}.
 */
public interface CSVNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CSVNParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CSVNParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSVNParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CSVNParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSVNParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(CSVNParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSVNParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(CSVNParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSVNParser#hdr}.
	 * @param ctx the parse tree
	 */
	void enterHdr(CSVNParser.HdrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSVNParser#hdr}.
	 * @param ctx the parse tree
	 */
	void exitHdr(CSVNParser.HdrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSVNParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(CSVNParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSVNParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(CSVNParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSVNParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CSVNParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSVNParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CSVNParser.FieldContext ctx);
}