package com.zhou.springboot.dsl.qu;

import com.zhou.springboot.dsl.qu.QualityParser.AddSubContext;
import com.zhou.springboot.dsl.qu.QualityParser.AndOrContext;
import com.zhou.springboot.dsl.qu.QualityParser.BooleanContext;
import com.zhou.springboot.dsl.qu.QualityParser.CompareContext;
import com.zhou.springboot.dsl.qu.QualityParser.DecimalContext;
import com.zhou.springboot.dsl.qu.QualityParser.ExprContext;
import com.zhou.springboot.dsl.qu.QualityParser.FuncContext;
import com.zhou.springboot.dsl.qu.QualityParser.FunctionContext;
import com.zhou.springboot.dsl.qu.QualityParser.MulDivContext;
import com.zhou.springboot.dsl.qu.QualityParser.NotContext;
import com.zhou.springboot.dsl.qu.QualityParser.ParensContext;
import com.zhou.springboot.dsl.qu.QualityParser.StatContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("all")
public class QualityValidListener extends QualityBaseListener {

    public ParseTreeProperty<ReturnType> values = new ParseTreeProperty<>();

    @Override
    public void exitStat(StatContext ctx) {
        ExprContext ec = ctx.expr();
        ReturnType v = values.get(ec);
        if (v != ReturnType.BOOLEAN) {
            //最终的结果必须是true/false
            throw new RuntimeException();
        }
    }

    @Override
    public void exitNot(NotContext ctx) {
        ExprContext ec = ctx.expr();
        ReturnType v = values.get(ec);
        if (v != ReturnType.BOOLEAN) {
            throw new RuntimeException();
        }
        values.put(ctx, ReturnType.BOOLEAN);
    }

    @Override
    public void exitAddSub(AddSubContext ctx) {
        Token token = ctx.op;
        int type = token.getType();

        ExprContext left = ctx.expr(0);
        ExprContext right = ctx.expr(1);
        ReturnType leftRtn = values.get(left);
        ReturnType rightRtn = values.get(right);
        if (type == QualityParser.ADD || type == QualityParser.SUB) {
            if (leftRtn != ReturnType.NUMBER || rightRtn != ReturnType.NUMBER) {
                throw new RuntimeException();
            }
            values.put(ctx, ReturnType.NUMBER);
            return;
        }
        throw new UnsupportedOperationException("unknow add/sub operation");
    }

    @Override
    public void exitMulDiv(MulDivContext ctx) {
        Token token = ctx.op;
        int type = token.getType();

        ExprContext left = ctx.expr(0);
        ExprContext right = ctx.expr(1);
        ReturnType leftRtn = values.get(left);
        ReturnType rightRtn = values.get(right);
        if (type == QualityParser.MUL || type == QualityParser.DIV) {
            if (leftRtn != ReturnType.NUMBER || rightRtn != ReturnType.NUMBER) {
                throw new RuntimeException();
            }
            values.put(ctx, ReturnType.NUMBER);
            return;
        }
        throw new UnsupportedOperationException("unknow mul/div operation");
    }

    @Override
    public void exitAndOr(AndOrContext ctx) {
        Token token = ctx.op;
        int type = token.getType();

        ExprContext left = ctx.expr(0);
        ExprContext right = ctx.expr(1);
        ReturnType leftRtn = values.get(left);
        ReturnType rightRtn = values.get(right);
        if (type == QualityParser.AND || type == QualityParser.OR) {
            if (leftRtn == ReturnType.NUMBER || rightRtn == ReturnType.NUMBER) {
                throw new RuntimeException();
            }
            values.put(ctx, ReturnType.BOOLEAN);
            return;
        }
        throw new UnsupportedOperationException("unknow and/or operation");
    }

    @Override
    public void exitCompare(CompareContext ctx) {
        Token token = ctx.op;
        int type = token.getType();

        ExprContext left = ctx.expr(0);
        ExprContext right = ctx.expr(1);
        ReturnType leftRtn = values.get(left);
        ReturnType rightRtn = values.get(right);
        if (type == QualityParser.GT || type == QualityParser.GTE || type == QualityParser.LT
                || type == QualityParser.LTE) {
            if (leftRtn != ReturnType.NUMBER || leftRtn != ReturnType.NUMBER) {
                throw new RuntimeException();
            }
            values.put(ctx, ReturnType.BOOLEAN);
            return;
        } else if (type == QualityParser.EQ) {
            if (leftRtn != rightRtn) {
                throw new RuntimeException();
            }
            values.put(ctx, ReturnType.BOOLEAN);
            return;
        }
        throw new UnsupportedOperationException("unknow compare operation");
    }

    @Override
    public void exitParens(ParensContext ctx) {
        ExprContext ec = ctx.expr();
        values.put(ctx, values.get(ec));
    }

    @Override
    public void exitDecimal(DecimalContext ctx) {
        values.put(ctx, ReturnType.NUMBER);
    }

    @Override
    public void exitBoolean(BooleanContext ctx) {
        values.put(ctx, ReturnType.BOOLEAN);
    }

    @Override
    public void exitFunction(FunctionContext ctx) {
        FuncContext fc = ctx.func();
        TerminalNode tn = fc.ID();
        String v = tn.getSymbol().getText(); //v为函数名称
        switch (v) {
            case "count":
                values.put(ctx, ReturnType.NUMBER);
                break;
            case "enum":
                values.put(ctx, ReturnType.BOOLEAN);
                break;
            case "isNull":
                values.put(ctx, ReturnType.BOOLEAN);
                break;
            case "round":
                values.put(ctx, ReturnType.NUMBER);
                break;
        }
    }

    private void check(Object v) {
        if (v == null) {
            throw new RuntimeException("v不能为空");
        }
    }

    public enum ReturnType {
        BOOLEAN,
        NUMBER
    }

}
