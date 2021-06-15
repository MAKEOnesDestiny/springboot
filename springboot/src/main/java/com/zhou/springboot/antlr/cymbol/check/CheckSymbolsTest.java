package com.zhou.springboot.antlr.cymbol.check;

import com.zhou.springboot.antlr.cymbol.CymbolLexer;
import com.zhou.springboot.antlr.cymbol.CymbolParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

public class CheckSymbolsTest {

    @Test
    public void testNormal() {
        test("  int x;\n"
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
    }


    @Test
    public void testError() {
        test("  int x;\n"
                     + "  int y;\n"
                     + "  void a()\n"
                     + "  {\n"
                     + "    int z=1;\n"
                     + "    int x;\n"
                     + "    z = 1;   // x是当前作用域的x，并不是全局作用域的x\n"
                     + "    y = 2;   // y在当前作用域不存在，但在全局作用域存在\n"
                     + "    { int y = x; }\n"
                     + "  }\n"
                     + "\n"
                     + "  void b(int z)\n"
                     + "  { }");
    }


    public static void test(String s) {
        CharStream cs = CharStreams.fromString(s);
        CymbolLexer lexer = new CymbolLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(cts);
        ParseTree pt = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase defPhase = new DefPhase();
        walker.walk(defPhase, pt);

        RefPhase refPhase = new RefPhase(defPhase.globals, defPhase.scopes);
        walker.walk(refPhase, pt);

    }

}
