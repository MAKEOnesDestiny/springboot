package com.zhou.springboot.antlr.vec;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class VecTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("[1,2,3,4,5]");
        VecLexer lexer = new VecLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        VecParser parser = new VecParser(cts);
        ParseTree pt = parser.vec4();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new VecBaseListener(), pt);
    }

}


