package com.zhou.springboot.antlr.cymbol.check;

//变量符号
public class VariableSymbol extends Symbol {

    private String expression; //表达式

    public VariableSymbol(String symbolName) {
        super(symbolName);
    }

    @Override
    public String symbolName() {
        return null;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
