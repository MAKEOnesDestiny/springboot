package com.zhou.springboot.antlr.cymbol.check;

import java.util.ArrayList;
import java.util.List;

public class LocalScope extends BaseScope {

    List<Symbol> variableSymbols = new ArrayList<>();

    public LocalScope(Scope parent) {
        super(parent);
    }

    @Override
    public List<Symbol> getFunctionSymbols() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Symbol> getVariableSymbols() {
        return variableSymbols;
    }

}
