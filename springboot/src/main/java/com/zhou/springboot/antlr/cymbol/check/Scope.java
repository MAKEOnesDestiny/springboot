package com.zhou.springboot.antlr.cymbol.check;

import java.util.List;

public interface Scope {

    Scope getParentScope();

    List<Symbol> getFunctionSymbols();

    List<Symbol> getVariableSymbols();

}
