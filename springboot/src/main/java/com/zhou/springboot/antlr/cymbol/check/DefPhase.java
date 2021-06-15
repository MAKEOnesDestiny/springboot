package com.zhou.springboot.antlr.cymbol.check;

import com.zhou.springboot.antlr.cymbol.CymbolBaseListener;
import com.zhou.springboot.antlr.cymbol.CymbolParser.FileContext;
import com.zhou.springboot.antlr.cymbol.CymbolParser.FormalParameterContext;
import com.zhou.springboot.antlr.cymbol.CymbolParser.FunctionDeclContext;
import com.zhou.springboot.antlr.cymbol.CymbolParser.VarDeclContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DefPhase extends CymbolBaseListener {

    //将ParseTree和Value进行绑定
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();  //代表当前树能看到的范围
    //全局scope,相当于记录一个root
    GlobalScope globals;
    //当前符号的作用域，当进入某一个function的时候，会设置一个新的currentScope
    Scope currentScope; //可以做一个嵌套结构，enter时候进行封装，exit时候进行解封

    @Override
    public void enterFile(FileContext ctx) {
        this.globals = new GlobalScope(null);
        currentScope = this.globals;
    }

    @Override
    public void enterVarDecl(VarDeclContext ctx) {
        //        currentScope.getVariableSymbols()
    }

    @Override
    public void enterFunctionDecl(FunctionDeclContext ctx) {
        TerminalNode idTN = ctx.ID();
        String idTX = idTN.getSymbol().getText();
        Symbol idSymbol = new FunctionSymbol(idTX);
        currentScope.getFunctionSymbols().add(idSymbol);

        Scope newScope = new LocalScope(currentScope);
        currentScope = newScope; //设置新scope
        scopes.put(ctx, currentScope);
    }

    @Override
    public void exitFunctionDecl(FunctionDeclContext ctx) {
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void exitFormalParameter(FormalParameterContext ctx) {
        Symbol variable = new VariableSymbol(ctx.ID().getText());
        currentScope.getVariableSymbols().add(variable);
    }

    @Override
    public void exitVarDecl(VarDeclContext ctx) {
        Symbol variable = new VariableSymbol(ctx.ID().getText());
        currentScope.getVariableSymbols().add(variable);
    }
}
