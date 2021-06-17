package com.zhou.springboot.antlr.simple;

import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class SimpleTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("class MyClass #{\n"
                                                       + "\n"
                                                       + "  int a (;\n"
                                                       + "\n"
                                                       + "  void b(){\n"
                                                       + "      f(a);\n"
                                                       + "  }\n"
                                                       + "}");
        SimpleLexer lexer = new SimpleLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(cts);
        parser.removeErrorListeners();
        //        parser.addErrorListener(new VerboseListener());
        parser.addErrorListener(new UnderlineListener());
        parser.setErrorHandler(new MyErrorStrategy());  //错误恢复策略

        ParseTree pt = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        SimpleBaseListener listener = new SimpleBaseListener();
        walker.walk(listener, pt);

    }

    public static final class VerboseListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                                String msg, RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);
            System.err.println("rule stack: " + stack);
            System.err.println("line " + line + ":" + charPositionInLine + " at " + offendingSymbol + ": " + msg);
        }
    }

    //定制化错误处理器
    public static final class UnderlineListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                                String msg, RecognitionException e) {
            System.err.println("line: " + line + ":" + charPositionInLine + "  " + msg);
            underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
        }

        protected void underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine) {
            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];
            System.err.println(errorLine);
            for (int i = 0; i < charPositionInLine; i++) {
                System.err.print(" ");
            }

            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            if (start >= 0 && stop >= 0) {
                for (int i = start; i <= stop; i++) {
                    System.err.print("^");
                }
            }
            System.err.println();
        }

    }


    public static final class BailSimpleLexer extends SimpleLexer {

        public BailSimpleLexer(CharStream input) {
            super(input);
        }

        @Override
        public void recover(LexerNoViableAltException e) {
            throw new RuntimeException(e);
        }
    }


    //修改语法分析器的错误报告策略
    public static final class MyErrorStrategy extends DefaultErrorStrategy {

        @Override
        public void recover(Parser recognizer, RecognitionException e) {
            throw new RuntimeException(e);
        }

        //确保不会试图执行行内恢复
        @Override
        public Token recoverInline(Parser recognizer) throws RecognitionException {
            throw new RuntimeException(new InputMismatchException(recognizer));
        }

        //确保不会试图从子规则的问题中恢复
        @Override
        public void sync(Parser recognizer) throws RecognitionException {

        }

        @Override
        protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
            String msg = "can't choose between alternatives"; //自定义的非标准消息
            recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
        }

    }

}






