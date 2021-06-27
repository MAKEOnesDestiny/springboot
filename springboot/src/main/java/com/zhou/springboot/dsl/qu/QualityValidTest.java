package com.zhou.springboot.dsl.qu;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class QualityValidTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("(count(shop_id)&10)+count(a.shop_name)>(count(shop_id)>10.11)");
        //        CharStream cs = CharStreams.fromString("!(count(shop_id)+10) > count(a.shop_name) & (count(shop_id)>10.11);");
        Lexer lexer = new QualityLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        QualityParser parser = new QualityParser(cts);
        //        parser.removeErrorListeners();
        parser.addErrorListener(new QualityErrorListener());  //errorListener收集 语法错误

        ParseTree pt = parser.stat();

        ParseTreeWalker walker = new ParseTreeWalker();
        QualityListener ql = new QualityValidListener();  //validListener收集 语义错误
        //        QualityListener ql = new QualityBaseListener();
        walker.walk(ql, pt);
    }

}
