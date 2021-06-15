package com.zhou.springboot.antlr.cymbol.check;

//LocalScope代表是某一个作用域
//GlobalScope代表全局作用域
public abstract class BaseScope implements Scope {

    private Scope parent;

    public BaseScope(Scope parent) {
        this.parent = parent;
    }

    @Override
    public Scope getParentScope() {
        return parent;
    }

}
