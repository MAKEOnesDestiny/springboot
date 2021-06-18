// Generated from /Users/hfzhou/IdeaProjects/springboot/springboot/src/main/java/com/zhou/springboot/antlr/csvn/CSVN.g4 by ANTLR 4.9
package com.zhou.springboot.antlr.csvn;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSVNParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CSVNVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CSVNParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CSVNParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVNParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(CSVNParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVNParser#hdr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHdr(CSVNParser.HdrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVNParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(CSVNParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSVNParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(CSVNParser.FieldContext ctx);
}