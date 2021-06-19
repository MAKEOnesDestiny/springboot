package com.zhou.springboot.antlr.shift;

import com.zhou.springboot.antlr.shift.ShiftParser.ExprContext;
import java.util.List;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ShiftTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("int n = 0; //定义一个计数器\n"
                                                       + "int i = 9;");
        ShiftLexer lexer = new ShiftLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        ShiftParser parser = new ShiftParser(cts);

        ParseTree pt = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        CommentShifter csl = new CommentShifter(cts);
        walker.walk(csl, pt);

        System.out.print(csl.rewriter.getText());
    }


    public static class CommentShifter extends ShiftBaseListener {

        BufferedTokenStream tokens;
        TokenStreamRewriter rewriter;

        public CommentShifter(BufferedTokenStream tokens) {
            this.tokens = tokens;
            rewriter = new TokenStreamRewriter(tokens);
        }

        @Override
        public void exitExpr(ExprContext ctx) {
            Token semi = ctx.getStop();
            int i = semi.getTokenIndex();
            List<Token> cmtChannel = tokens.getHiddenTokensToRight(i, 2);
            if (cmtChannel != null) {
                Token cmt = cmtChannel.get(0);
                if (cmt != null) {
                    String txt = cmt.getText().substring(2);
                    String newCmt = "/*" + txt.trim() + "*/\n";
                    rewriter.insertBefore(ctx.start, newCmt);
                    rewriter.replace(cmt, "\n");
                }
            }
        }
    }

}
