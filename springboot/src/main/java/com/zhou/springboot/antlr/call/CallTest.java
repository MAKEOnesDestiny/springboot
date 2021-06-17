package com.zhou.springboot.antlr.call;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CallTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("f(34));");
        CallLexer lexer = new CallLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        CallParser parser = new CallParser(cts);
        ParseTree pt = parser.stat();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new CallBaseListener(), pt);
    }

}
