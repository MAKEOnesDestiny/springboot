package com.zhou.springboot.antlr.expr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class ExprTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        int line = 1;

        ExprParser parser = new ExprParser(null); //共享同一个语法分析器的实例
        parser.setBuildParseTree(false); //不需要建立语法分析树

        while (expr != null) { //当多余一个表达式时
            ANTLRInputStream inputStream = new ANTLRInputStream(expr + '\n');
            ExprLexer lexer = new ExprLexer(inputStream);
            lexer.setLine(line);
            lexer.setCharPositionInLine(0);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser.setInputStream(tokens);
            parser.stat();
            expr = br.readLine();
            line++;
        }
    }

}
