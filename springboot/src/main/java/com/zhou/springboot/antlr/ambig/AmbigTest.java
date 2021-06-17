package com.zhou.springboot.antlr.ambig;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AmbigTest {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("f()");
        AmbigLexer lexer = new AmbigLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        AmbigParser parser = new AmbigParser(cts);
        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        ParseTree pt = parser.stat();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new AmbigListener(), pt);
        System.out.println();
    }

    public static final class AmbigListener extends AmbigBaseListener {


    }


}
































