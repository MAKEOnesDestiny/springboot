package com.zhou.springboot.antlr.keywords;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class KeywordTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("if=34;");
        KeywordsLexer lexer = new KeywordsLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        KeywordsParser parser = new KeywordsParser(cts);

        ParseTree pt = parser.stat();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new KeywordsBaseListener(), pt);
    }

}
