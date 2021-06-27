package com.zhou.springboot.dsl.qu;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class QualityErrorListener extends BaseErrorListener {

    //这里收集的信息是 语法错误 无法收集语义错误
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        System.out.println("charPositionInLine => " + charPositionInLine);
        System.out.println("offendingSymbol => " + offendingSymbol);
        System.out.println("message => " + msg);
    }
}
