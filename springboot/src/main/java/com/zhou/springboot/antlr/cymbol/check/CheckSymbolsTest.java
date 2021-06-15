package com.zhou.springboot.antlr.cymbol.check;

import com.zhou.springboot.antlr.cymbol.CymbolLexer;
import com.zhou.springboot.antlr.cymbol.CymbolParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CheckSymbolsTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("  int x;\n"
                                                       + "  int y;\n"
                                                       + "  void a()\n"
                                                       + "  {\n"
                                                       + "    int x;\n"
                                                       + "    x = 1;\n"
                                                       + "    y = 2;\n"
                                                       + "    { int y = x; }\n"
                                                       + "  }\n"
                                                       + "\n"
                                                       + "  void b(int z)\n"
                                                       + "  { }");
        CymbolLexer lexer = new CymbolLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(cts);
        ParseTree pt = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase defPhase = new DefPhase();
        walker.walk(defPhase, pt);

        System.out.println();
    }

}
