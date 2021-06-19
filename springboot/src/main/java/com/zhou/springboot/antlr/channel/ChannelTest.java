package com.zhou.springboot.antlr.channel;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ChannelTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("//测试\n"
                                                       + "f()");
        Lexer lexer = new ChannelLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        ChannelParser parser = new ChannelParser(cts);

        ParseTree pt = parser.stat();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ChannelBaseListener(), pt);
        System.out.println();
    }

}
