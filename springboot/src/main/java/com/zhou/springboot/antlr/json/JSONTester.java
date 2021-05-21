package com.zhou.springboot.antlr.json;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JSONTester {

    public static void main(String[] args) {
        CharStream cs = CharStreams.fromString("{\n"
                                                       + "    \"description\": \"An imaginary server config file\",\n"
                                                       + "    \"logs\": {\n"
                                                       + "        \"level\": \"verbose\",\n"
                                                       + "        \"dir\": \"/var/log\"\n"
                                                       + "    },\n"
                                                       + "    \"host\": \"antlr.org\",\n"
                                                       + "    \"admin\": [\n"
                                                       + "        \"parrt\",\n"
                                                       + "        \"tombu\"\n"
                                                       + "    ],\n"
                                                       + "    \"aliases\": []\n"
                                                       + "}");
        Lexer lexer = new JSONLexer(cs);
        CommonTokenStream cts = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(cts);
        ParseTree tree = parser.json();

        ParseTreeWalker walker = new ParseTreeWalker();
        XMLEmitter listener = new XMLEmitter();
        walker.walk(listener, tree);
        System.out.println(listener.getXML(tree));
    }

}
