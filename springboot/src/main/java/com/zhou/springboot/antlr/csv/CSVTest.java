package com.zhou.springboot.antlr.csv;

import com.zhou.springboot.antlr.csv.CSVParser.EmptyContext;
import com.zhou.springboot.antlr.csv.CSVParser.HdrContext;
import com.zhou.springboot.antlr.csv.CSVParser.RowContext;
import com.zhou.springboot.antlr.csv.CSVParser.StringContext;
import com.zhou.springboot.antlr.csv.CSVParser.TextContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CSVTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("name,age,sex\n"
                                                       + "kobe,42,male\n"
                                                       + "james,38,male\n"
                                                       + "gigi,16,female\n");
        Lexer lexer = new CSVLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        CSVParser parser = new CSVParser(cts);
        ParseTree tree = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        Loader loader = new Loader();
        walker.walk(loader, tree);
        System.out.println(loader.rows);
    }

    public static final class Loader extends CSVBaseListener {

        public static final String EMPTY = "";

        List<Map<String, String>> rows = new ArrayList<>();

        List<String> header;

        List<String> currentRowFieldValues = new ArrayList<>();

        @Override
        public void exitText(TextContext ctx) {
            currentRowFieldValues.add(ctx.TEXT().getText());
        }

        @Override
        public void exitString(StringContext ctx) {
            currentRowFieldValues.add(ctx.STRING().getText());
        }

        @Override
        public void exitEmpty(EmptyContext ctx) {
            currentRowFieldValues.add(EMPTY);
        }

        @Override
        public void exitHdr(HdrContext ctx) {
            header = new ArrayList<>();
            header.addAll(currentRowFieldValues);
        }

        @Override
        public void enterRow(RowContext ctx) {
            currentRowFieldValues.clear();
        }

        @Override
        public void exitRow(RowContext ctx) {
            //找上级的Rule规则
            if (ctx.getParent().getRuleIndex() == CSVParser.RULE_hdr) {
                //表头的话直接返回
                return;
            }
            //数据row
            Map<String, String> singleRow = new LinkedHashMap<>();
            int i = 0;
            for (String h : header) {
                singleRow.put(h, currentRowFieldValues.get(i++));
            }
            rows.add(singleRow);
        }

    }

}
