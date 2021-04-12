package com.zhou.springboot.antlr.data;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class DataTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("2 9 10 3 1 2 3");
        DataLexer lexer = new DataLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        DataParser parser = new DataParser(cts);

        ParseTree pt = parser.file();
        System.out.println(pt.toStringTree());
    }

}
