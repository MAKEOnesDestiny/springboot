package com.zhou.springboot.antlr.cymbol;

import com.zhou.springboot.antlr.cymbol.CallGraph.Graph;
import com.zhou.springboot.antlr.cymbol.CymbolParser.CallContext;
import com.zhou.springboot.antlr.cymbol.CymbolParser.FunctionDeclContext;

public class FunctionListener extends CymbolBaseListener {

    Graph graph = new Graph(); //这个图类也可以用类似执行计划的数据结构来替代
    String currentFunctionName = null; //当前函数名

    @Override
    public void enterFunctionDecl(FunctionDeclContext ctx) {
        currentFunctionName = ctx.ID().getText();  //获取当前函数名称
        graph.nodes.add(currentFunctionName);
    }

    @Override
    public void exitCall(CallContext ctx) {
        String funcName = ctx.ID().getText();
        graph.edge(currentFunctionName, funcName);
    }
}
