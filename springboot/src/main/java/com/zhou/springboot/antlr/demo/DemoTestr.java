package com.zhou.springboot.antlr.demo;

import com.zhou.springboot.antlr.demo.DemoParser.ProgContext;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

public class DemoTestr {

    public static void main(String[] args) {
        run("a+  (b*3)");
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
        System.out.println();

        List<ProgContext> l = visit(new ArrayList<ParserRuleContext>() {{
            add(context);
        }}, ProgContext.class);
        System.out.println();
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
