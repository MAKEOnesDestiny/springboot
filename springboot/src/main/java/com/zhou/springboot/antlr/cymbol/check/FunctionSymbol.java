package com.zhou.springboot.antlr.cymbol.check;

import java.util.ArrayList;
import java.util.List;

//作用1：作为函数符号
//作用2：作为一个包含参数的作用域
public class FunctionSymbol extends Symbol {

    List<String> symbols = new ArrayList<>();

    public FunctionSymbol(String symbolName) {
        super(symbolName);
    }

    @Override
    public String symbolName() {
        return null;
    }
}
