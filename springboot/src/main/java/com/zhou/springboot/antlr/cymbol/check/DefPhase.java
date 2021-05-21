package com.zhou.springboot.antlr.cymbol.check;

import com.zhou.springboot.antlr.cymbol.CymbolBaseListener;
import com.zhou.springboot.antlr.cymbol.CymbolParser.FileContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class DefPhase extends CymbolBaseListener {

    //将ParseTree和Value进行绑定
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    //全局scope
    GlobalScope globals;
    //当前符号的作用域
    Scope currentScope;

    @Override
    public void enterFile(FileContext ctx) {
        super.enterFile(ctx);
    }
}
