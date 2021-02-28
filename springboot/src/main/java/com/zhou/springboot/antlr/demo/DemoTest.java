package com.zhou.springboot.antlr.demo;

import com.zhou.springboot.antlr.demo.DemoParser.ProgContext;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
//Demo.g4可以理解为原始文件
//Demo.g4，选择Generate ANTLR Recognizer。可以看到生成结果结果

//Demo.tokens为文法中用到的各种符号做了数字化编号

//DemoLexer是Antlr生成的词法分析器
//DemoParser是Antlr 生成的语法分析器
//DemoListener
//DemoVisitor

/**
 * 遍历模式
 * <p>
 * 1、Listener (观察者模式，通过结点监听，触发处理方法) 程序员不需要显示定义遍历语法树的顺序，实现简单 缺点，不能显示控制遍历语法树的顺序 动作代码与文法产生式解耦，利于文法产生式的重用
 * 没有返回值，需要使用map、栈等结构在节点间传值
 *
 * @see org.antlr.v4.runtime.tree.ParseTreeWalker
 * <p>
 * 2、Visitor (访问者模式，主动遍历) 程序员可以显示定义遍历语法树的顺序 不需要与antlr遍历类ParseTreeWalker一起使用，直接对tree操作 动作代码与文法产生式解耦，利于文法产生式的重用
 * visitor方法可以直接返回值，返回值的类型必须一致，不需要使用map这种节点间传值方式，效率高
 */
public class DemoTest {

    public static void main(String[] args) {
        //        run("1+(2*3)");
        //        run("4/2*3)");
        run("20-12/(2*3 )+10");
    }

    public static void run(String expr) {
        ANTLRInputStream in = new ANTLRInputStream(expr);
        //分词器
        DemoLexer lexer = new DemoLexer(in);
        //用词法分析器构建一个记号流tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //tokens构造语法分析器parser,至此已经完成词法分析和语法分析
        DemoParser parser = new DemoParser(tokens);
        //语法分析器，完成对表达式的验证
        ProgContext context = parser.prog();

        DemoEvalVisitor visitor = new DemoEvalVisitor();
        Integer res = visitor.visit(context);
        System.out.println(res);
    }

    public static <T> List<T> visit(List<? extends ParserRuleContext> contexts, Class<T> clazz) {
        return contexts.stream()
                .map(new Function<ParserRuleContext, ArrayList<ParserRuleContext>>() {
                    @Override
                    public ArrayList<ParserRuleContext> apply(ParserRuleContext parserRuleContext) {
                        return new ArrayList<ParserRuleContext>() {{
                            add(parserRuleContext);
                        }};
                    }
                })
                .flatMap(t -> t.stream().map(clazz::cast))
                //                .map(clazz::cast)
                .collect(Collectors.toList());
    }

}
