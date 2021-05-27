package com.zhou.springboot.antlr.cymbol.check;

import java.util.ArrayList;
import java.util.List;

public class GlobalScope extends BaseScope {

    List<String> symbols = new ArrayList<>();


    @Override
    public Scope getParentScope() {
        return null;
    }

    @Override
    public List<Symbol> getVariableSymbols() {
        return null;
    }
}
