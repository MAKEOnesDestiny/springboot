package com.zhou.springboot.antlr.cymbol.check;

import java.util.List;

public abstract class BaseScope implements Scope {

    @Override
    public List<Symbol> getFunctionSymbols() {
        return null;
    }
}
