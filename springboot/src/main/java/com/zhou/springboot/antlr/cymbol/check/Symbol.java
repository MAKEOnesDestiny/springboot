package com.zhou.springboot.antlr.cymbol.check;

public abstract class Symbol {

    public String symbolName;

    public Symbol(String symbolName) {
        this.symbolName = symbolName;
    }

    public abstract String symbolName();

}
