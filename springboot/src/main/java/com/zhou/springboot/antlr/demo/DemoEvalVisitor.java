package com.zhou.springboot.antlr.demo;

import com.zhou.springboot.antlr.demo.DemoParser.AtomContext;
import com.zhou.springboot.antlr.demo.DemoParser.ExprContext;
import com.zhou.springboot.antlr.demo.DemoParser.MultExprContext;
import com.zhou.springboot.antlr.demo.DemoParser.ProgContext;
import com.zhou.springboot.antlr.demo.DemoParser.StatContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DemoEvalVisitor extends DemoBaseVisitor<Integer> {

    @Override
    public Integer visitProg(ProgContext ctx) {
        System.out.println("访问Prog");
        return super.visitProg(ctx);
    }

    @Override
    public Integer visitStat(StatContext ctx) {
        System.out.println("访问Stat");
        return super.visitStat(ctx);
    }

    @Override
    public Integer visitExpr(ExprContext ctx) {
        System.out.println("访问Expr");
        int n = ctx.getChildCount();
        int res = ctx.getChild(0).accept(this);
        for (int i = 1; i < n - 1; ) {
            ParseTree op = ctx.getChild(i);
            String opText = op.getText();

            ParseTree node = ctx.getChild(i + 1);
            int opNum = node.accept(this);
            if (opText.equals("+")) {
                res += opNum;
            }
            if (opText.equals("-")) {
                res -= opNum;
            }
            i += 2;
        }
        return res;
    }

    //乘除和加减分开成不同的规则，用于实现优先级特性
    @Override
    public Integer visitMultExpr(MultExprContext ctx) {
        System.out.println("访问MultExpr");
        int n = ctx.getChildCount();
        int res = ctx.getChild(0).accept(this);
        for (int i = 1; i < n - 1; ) {
            ParseTree op = ctx.getChild(i);
            String opText = op.getText();

            ParseTree node = ctx.getChild(i + 1);
            int opNum = node.accept(this);
            if (opText.equals("*")) {
                res *= opNum;
            }
            if (opText.equals("/")) {
                res /= opNum;
            }
            i += 2;
        }
        return res;
    }

    @Override
    public Integer visitAtom(AtomContext ctx) {
        System.out.println("访问MultAtom");
        ExprContext expr = ctx.expr();
        if (expr != null) {
            return visit(ctx.expr());
        }
        TerminalNode cint = ctx.INT();
        if (cint != null) {
            return Integer.valueOf(cint.getText());
        } else {
            throw new IllegalStateException();
        }

    }


}
