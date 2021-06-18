package com.zhou.springboot.antlr.csvn;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CsvTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("name,age,sex\n"
                                                       + "kobe,42,male\n"
                                                       + "james,38,male\n"
                                                       + "gigi,16,female\n");
        CSVNLexer lexer = new CSVNLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);

        CSVNParser parser = new CSVNParser(cts);
        ParseTree pt = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new CSVNBaseListener(), pt);
    }

}
