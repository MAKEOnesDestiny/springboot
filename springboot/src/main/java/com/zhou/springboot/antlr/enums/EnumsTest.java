package com.zhou.springboot.antlr.enums;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EnumsTest {

    public static void main(String[] args) {
        EnumsParser.java5 = false;
        CharStream cs = CharStreams.fromString("enum Sex { MALE,FEMALE }");
        Lexer lexer = new EnumsLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        EnumsParser parser = new EnumsParser(cts);
        ParseTree tree = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new EnumsBaseListener(), tree);
    }

}
