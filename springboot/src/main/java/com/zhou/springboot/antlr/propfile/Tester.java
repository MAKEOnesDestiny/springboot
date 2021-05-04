package com.zhou.springboot.antlr.propfile;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Tester {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("a=\"100\"\n");

        PropertyFileLexer lexer = new PropertyFileLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        PropertyFilePrinter parser = new PropertyFilePrinter(cts);

        parser.file();

    }

}
