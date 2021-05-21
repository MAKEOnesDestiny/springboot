package com.zhou.springboot.antlr.cymbol.check;

public abstract class Symbol {

    private String symbolName;

    public Symbol(String symbolName) {
        this.symbolName = symbolName;
    }

    public abstract String symbolName();

}
