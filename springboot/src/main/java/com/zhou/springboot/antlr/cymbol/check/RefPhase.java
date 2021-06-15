package com.zhou.springboot.antlr.cymbol.check;

import com.zhou.springboot.antlr.cymbol.CymbolBaseListener;
import com.zhou.springboot.antlr.cymbol.CymbolParser.BlockContext;
import com.zhou.springboot.antlr.cymbol.CymbolParser.FunctionDeclContext;
import com.zhou.springboot.antlr.cymbol.CymbolParser.VarContext;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class RefPhase extends CymbolBaseListener {

    GlobalScope globals;
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    Scope currentScope;

    public RefPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
        this.globals = globals;
        this.scopes = scopes;
        this.currentScope = globals;
    }


    @Override
    public void enterFunctionDecl(FunctionDeclContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitFunctionDecl(FunctionDeclContext ctx) {
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void enterBlock(BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitBlock(BlockContext ctx) {
        currentScope = currentScope.getParentScope();
    }


    @Override
    public void exitVar(VarContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol var = null;
        Scope s = currentScope;
        while (var == null && s != null) {
            List<Symbol> ss = s.getVariableSymbols();
            for (int i = 0; i < ss.size(); i++) {
                if (name.equals(ss.get(i).symbolName)) {
                    var = ss.get(i);
                    break;
                }
            }
            s = s.getParentScope();
        }

        if (var == null) {
            throw new RuntimeException("无法找到符号:" + name);
        }

        if (var instanceof FunctionSymbol) {
            throw new RuntimeException(name + "是一个函数");
        }

    }


  /*  ParseTree t = ctx;
        while (var == null && t != null) {
        Scope s = scopes.get(t);
        if (s != null) {
            List<Symbol> ss = s.getVariableSymbols();
            for (int i = 0; i < ss.size(); i++) {
                if (name.equals(ss.get(i).symbolName)) {
                    var = ss.get(i);
                    break;
                }
            }
        }
        t = t.getParent();
    }

        if (var == null) {
        throw new RuntimeException("无法找到符号:" + name);
    }*/
}
