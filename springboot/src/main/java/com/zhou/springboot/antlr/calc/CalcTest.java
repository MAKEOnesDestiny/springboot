package com.zhou.springboot.antlr.calc;

import com.zhou.springboot.antlr.calc.CalcParser.AddSubContext;
import com.zhou.springboot.antlr.calc.CalcParser.AssignContext;
import com.zhou.springboot.antlr.calc.CalcParser.IdContext;
import com.zhou.springboot.antlr.calc.CalcParser.IntContext;
import com.zhou.springboot.antlr.calc.CalcParser.MulDivContext;
import com.zhou.springboot.antlr.calc.CalcParser.ParensContext;
import com.zhou.springboot.antlr.calc.CalcParser.PrintExprContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CalcTest {

    //思考 优先级问题？结合性问题？
    /**
     * antlr4解决歧义性问题的方法:
     *   1.备选路径最近优先
     *   2.贪婪匹配，一次尽可能匹配多个字符
     */
    public static void main(String[] args) throws IOException {
        //        CharStream cs = CharStreams.fromStream(System.in);
        CharStream cs = CharStreams.fromString(new StringBuilder().append("a=1").append("\n")
                                                       .append("b=10").append("\n")
                                                       .append("a+5-b*2").append("\n")
                                                       .toString());
        CalcLexer lexer = new CalcLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(cts);
        ParseTree pt = parser.prog();

        MyCalcVisitor visitor = new MyCalcVisitor();
        visitor.visit(pt);
    }

    public static final class MyCalcVisitor extends CalcBaseVisitor<Integer> {

        Map<String, Integer> memory = new HashMap<>();

        @Override
        public Integer visitPrintExpr(PrintExprContext ctx) {
            Integer res = visit(ctx.expr());
            System.out.println("result ==> " + res);
            return 0;
        }

        @Override
        public Integer visitAssign(AssignContext ctx) {
            String id = ctx.ID().getSymbol().getText();
            Integer value = visit(ctx.expr());
            memory.put(id, value);
            return value; //useless??
        }

        @Override
        public Integer visitMulDiv(MulDivContext ctx) {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.op.getType() == CalcParser.MUL) {
                return left * right;
            }
            return left / right;
        }

        @Override
        public Integer visitAddSub(AddSubContext ctx) {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            if (ctx.op.getType() == CalcParser.ADD) {
                return left + right;
            }
            return left - right;
        }

        @Override
        public Integer visitParens(ParensContext ctx) {
            return visit(ctx.expr());
        }

        @Override
        public Integer visitId(IdContext ctx) {
            String id = ctx.ID().getSymbol().getText();
            Integer value = memory.get(id);
            if (value == null) {
                value = 0;
            }
            return value;
        }

        @Override
        public Integer visitInt(IntContext ctx) {
            return Integer.valueOf(ctx.INT().getSymbol().getText());
        }
    }

}
