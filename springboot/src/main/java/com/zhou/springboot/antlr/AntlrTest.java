package com.zhou.springboot.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerInterpreter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.tree.xpath.XPathLexer;

public class AntlrTest {

    public static void main(String[] args) {
        String sql = "select a from table_a where id=1";
        CodePointCharStream stream = CharStreams.fromString(sql);
        System.out.println();
/*


        Lexer lexer = new LexerInterpreter(stream); //词法分析
        CommonTokenStream tokens = new CommonTokenStream(lexer); //
        Parser parser = new ParserInterpreter(tokens);
*/

    }

}
