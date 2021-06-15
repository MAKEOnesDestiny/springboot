package com.zhou.springboot.antlr.cymbol.check;

import java.util.ArrayList;
import java.util.List;

public class GlobalScope extends BaseScope {

    List<Symbol> functionSymbols = new ArrayList<>();

    List<Symbol> variableSymbols = new ArrayList<>();

    public GlobalScope(Scope parent) {
        super(parent);
    }

    @Override
    public List<Symbol> getFunctionSymbols() {
        return functionSymbols;
    }

    @Override
    public List<Symbol> getVariableSymbols() {
        return variableSymbols;
    }
}
