package com.zhou.springboot.antlr.json;

import com.zhou.springboot.antlr.json.JSONParser.AnObjectContext;
import com.zhou.springboot.antlr.json.JSONParser.ArrayObjectContext;
import com.zhou.springboot.antlr.json.JSONParser.ArrayOfValuesContext;
import com.zhou.springboot.antlr.json.JSONParser.AtomContext;
import com.zhou.springboot.antlr.json.JSONParser.EmptyArrayContext;
import com.zhou.springboot.antlr.json.JSONParser.EmptyObjectContext;
import com.zhou.springboot.antlr.json.JSONParser.JsonContext;
import com.zhou.springboot.antlr.json.JSONParser.ObjectValueContext;
import com.zhou.springboot.antlr.json.JSONParser.PairContext;
import com.zhou.springboot.antlr.json.JSONParser.StringContext;
import com.zhou.springboot.antlr.json.JSONParser.ValueContext;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class XMLEmitter extends JSONBaseListener {

    private ParseTreeProperty<String> xml = new ParseTreeProperty();

    public String getXML(ParseTree ctx) {
        return xml.get(ctx);
    }

    public void setXML(ParseTree ctx, String s) {
        xml.put(ctx, s);
    }

    private String stripQuotes(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (s.charAt(0) == '"') {
            s = s.substring(1);
        }
        if (s.length() > 0 && s.charAt(s.length() - 1) == '"') {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    @Override
    public void exitAtom(AtomContext ctx) {
        setXML(ctx, ctx.getText());
    }

    @Override
    public void exitString(StringContext ctx) {
        setXML(ctx, stripQuotes(ctx.getText()));
    }

    @Override
    public void exitObjectValue(ObjectValueContext ctx) {
        setXML(ctx, getXML(ctx.object()));
    }

    @Override
    public void exitArrayObject(ArrayObjectContext ctx) {
        setXML(ctx, getXML(ctx.array()));
    }

    @Override
    public void exitPair(PairContext ctx) {
        String tag = stripQuotes(ctx.getText());
        ValueContext vctx = ctx.value();
        String x = String.format("<%s>%s<%s>", tag, getXML(vctx), tag);
        setXML(ctx, x);
    }

    @Override
    public void exitAnObject(AnObjectContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n"); //换行
        List<PairContext> pairContexts = ctx.pair();
        for (PairContext pctx : pairContexts) {
            sb.append(getXML(pctx));
        }
        setXML(ctx, sb.toString());
    }

    @Override
    public void exitEmptyObject(EmptyObjectContext ctx) {
        setXML(ctx, "");
    }

    @Override
    public void exitArrayOfValues(ArrayOfValuesContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (ValueContext vctx : ctx.value()) {
            sb.append("<element>").append(getXML(vctx)).append("</element>").append("\n");
        }
        setXML(ctx, sb.toString());
    }

    @Override
    public void exitEmptyArray(EmptyArrayContext ctx) {
        setXML(ctx, "");
    }

    //注意：这里json的两条分支都没有打上标签，所以只有exitJson方法
    @Override
    public void exitJson(JsonContext ctx) {
        setXML(ctx, getXML(ctx.getChild(0)));
    }


}
