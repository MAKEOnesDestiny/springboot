package com.zhou.springboot.antlr.enums2;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Enums2Test {


    public static void main(String[] args) {
        Enums2Lexer.java5 = true;
        CharStream cs = CharStreams.fromString("enum Sex { MALE,FEMALE }");
//        CharStream cs = CharStreams.fromString("enum=1");
        Lexer lexer = new Enums2Lexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        Enums2Parser parser = new Enums2Parser(cts);
        ParseTree tree = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Enums2BaseListener(), tree);
    }


}
