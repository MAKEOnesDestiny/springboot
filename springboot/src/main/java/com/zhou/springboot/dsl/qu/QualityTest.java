package com.zhou.springboot.dsl.qu;

import com.zhou.springboot.dsl.qu.QualityParser.AddSubContext;
import com.zhou.springboot.dsl.qu.QualityParser.AndOrContext;
import com.zhou.springboot.dsl.qu.QualityParser.BooleanContext;
import com.zhou.springboot.dsl.qu.QualityParser.ColumnContext;
import com.zhou.springboot.dsl.qu.QualityParser.CompareContext;
import com.zhou.springboot.dsl.qu.QualityParser.DecimalContext;
import com.zhou.springboot.dsl.qu.QualityParser.ExprContext;
import com.zhou.springboot.dsl.qu.QualityParser.FuncContext;
import com.zhou.springboot.dsl.qu.QualityParser.FunctionContext;
import com.zhou.springboot.dsl.qu.QualityParser.MulDivContext;
import com.zhou.springboot.dsl.qu.QualityParser.NotContext;
import com.zhou.springboot.dsl.qu.QualityParser.ParensContext;
import com.zhou.springboot.dsl.qu.QualityParser.StatContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("all")
public class QualityTest {

    public static void main(String[] args) {
//        CharStream cs = CharStreams.fromString("(count(shop_id)+10)>count(a.shop_name)&(count(shop_id)>10.11)");
        CharStream cs = CharStreams.fromString("Count(id)IsNull(from_currency_code)÷true=true");
        //        CharStream cs = CharStreams.fromString("!(count(shop_id)+10) > count(a.shop_name) & (count(shop_id)>10.11);");
        Lexer lexer = new QualityLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        QualityParser parser = new QualityParser(cts);
        parser.removeErrorListeners();
        parser.addErrorListener(new QualityErrorListener());

        ParseTree pt = parser.stat();

        ParseTreeWalker walker = new ParseTreeWalker();
        QualityListener ql = new QualityListener();
        walker.walk(ql, pt);
        System.out.println(ql.result);
    }

    public static final class QualityListener extends QualityBaseListener {

        public ParseTreeProperty<String> values = new ParseTreeProperty<>();

        public String result;

        @Override
        public void exitStat(StatContext ctx) {
            ExprContext ec = ctx.expr();
            String v = values.get(ec);
            if (v == null) {
                check(v);
            }
            v = "select (" + v + ")";
            values.put(ctx, v);
            result = v;
        }

        @Override
        public void exitNot(NotContext ctx) {
            ExprContext ec = ctx.expr();
            String v = values.get(ec);
            check(v);
            v = "!(" + v + ")";
            values.put(ctx, v);
        }

        @Override
        public void exitAddSub(AddSubContext ctx) {
            Token token = ctx.op;
            int type = token.getType();

            ExprContext left = ctx.expr(0);
            ExprContext right = ctx.expr(1);
            String leftStr = values.get(left);
            String rightStr = values.get(right);
            if (type == QualityParser.ADD) {
                // + 操作符
                values.put(ctx, "(" + leftStr + ") + (" + rightStr + ")");
                return;
            } else if (type == QualityParser.SUB) {
                values.put(ctx, "(" + leftStr + ") - (" + rightStr + ")");
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
            String leftStr = values.get(left);
            String rightStr = values.get(right);
            if (type == QualityParser.MUL) {
                // * 操作符
                values.put(ctx, "(" + leftStr + ") * (" + rightStr + ")");
                return;
            } else if (type == QualityParser.DIV) {
                values.put(ctx, "(" + leftStr + ") / (" + rightStr + ")");
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
            String leftStr = values.get(left);
            String rightStr = values.get(right);
            if (type == QualityParser.AND) {
                // & 操作符
                values.put(ctx, "(" + leftStr + ") and (" + rightStr + ")");
                return;
            } else if (type == QualityParser.OR) {
                values.put(ctx, "(" + leftStr + ") or (" + rightStr + ")");
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
            String leftStr = values.get(left);
            String rightStr = values.get(right);
            if (type == QualityParser.GT) {
                values.put(ctx, "(" + leftStr + ") > (" + rightStr + ")");
                return;
            } else if (type == QualityParser.GTE) {
                values.put(ctx, "(" + leftStr + ") >= (" + rightStr + ")");
                return;
            } else if (type == QualityParser.LT) {
                values.put(ctx, "(" + leftStr + ") < (" + rightStr + ")");
                return;
            } else if (type == QualityParser.LTE) {
                values.put(ctx, "(" + leftStr + ") <= (" + rightStr + ")");
                return;
            } else if (type == QualityParser.EQ) {
                values.put(ctx, "(" + leftStr + ") = (" + rightStr + ")");
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
            values.put(ctx, ctx.getText());
        }

        @Override
        public void exitBoolean(BooleanContext ctx) {
            values.put(ctx, ctx.getText());
        }

        @Override
        public void exitFunction(FunctionContext ctx) {
            FuncContext fc = ctx.func();
            TerminalNode tn = fc.ID();
            ColumnContext cc = fc.column();
            String table = cc.table != null ? cc.table.getText() : null;
            String field = cc.field.getText();
            String content = table == null ? field : (table + "." + field);

            String v = tn.getSymbol().getText(); //v为函数名称
            switch (v) {
                case "count":
                    v = "select " + v + "(" + content + ")"
                            + " from test.test_table where update_time between '2020-10-10' and "
                            + "'2020-10-10'";
                    break;
                case "enum":
                    v = "select " + v + " from test.test_table where update_time between '2020-10-10' and '2020-10-10'";
                    break;
                case "isNull":
                    v = "select " + v + " from test.test_table where update_time between '2020-10-10' and '2020-10-10'";
                    break;
                case "round":
                    break;
            }

            values.put(ctx, v);
        }

        private void check(Object v) {
            if (v == null) {
                throw new RuntimeException("v不能为空");
            }
        }
    }

}








