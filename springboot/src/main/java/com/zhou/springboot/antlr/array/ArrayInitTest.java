package com.zhou.springboot.antlr.array;

import com.zhou.springboot.antlr.array.ArrayInitParser.ValueContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ArrayInitTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("{10 , 20 ,30 ,{11,12, 13}}");
        ArrayInitLexer lexer = new ArrayInitLexer(cs);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        ArrayInitParser parser = new ArrayInitParser(tokenStream);
        ParseTree tree = parser.init();
        System.out.println(tree.toStringTree(parser)); //LISP风格打印的树

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyArrayInitListener(), tree);
    }

    static final class MyArrayInitListener extends ArrayInitBaseListener implements ArrayInitListener {

        @Override
        public void visitTerminal(TerminalNode node) {
            if ("{".equals(node.getText()) || "}".equals(node.getText())) {
                System.out.printf("\"");
            }
        }

        @Override
        public void enterValue(ValueContext ctx) {
            if (ctx.INT() != null) {
                System.out.printf(ctx.getText() + "-");
            }
        }
    }

}
