package com.zhou.springboot.antlr.cymbol;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CymbolTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("int main() { fact();  a(); }\n"
                                                       + "\n"
                                                       + "float fact(int n){\n"
                                                       + "   print(n);\n"
                                                       + "\n"
                                                       + "   if(n==0) then return 1;\n"
                                                       + "   return n * fact(n-1);\n"
                                                       + "}\n"
                                                       + "\n"
                                                       + "void a() { int x = b(); if false then { c(); d(); } }\n"
                                                       + "void b() { c(); }\n"
                                                       + "void c() { b(); }\n"
                                                       + "void d() { }\n"
                                                       + "void e() { }\n");
        CymbolLexer lexer = new CymbolLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(cts);
        ParseTree pt = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        FunctionListener collector = new FunctionListener();
        walker.walk(collector, pt);

        System.out.println(collector.graph.toString());
        System.out.println(collector.graph.toDOT());
    }

}
