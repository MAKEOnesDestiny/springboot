package com.zhou.springboot.antlr.cymbol.check;

import java.util.ArrayList;
import java.util.List;

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
