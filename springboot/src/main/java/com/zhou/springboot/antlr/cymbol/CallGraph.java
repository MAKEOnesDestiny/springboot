package com.zhou.springboot.antlr.cymbol;

import java.util.Set;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;

public class CallGraph {

    static class Graph {

        Set<String> nodes = new OrderedHashSet<>();
        //调用者 -> 被调用者
        MultiMap<String, String> edges = new MultiMap<>();

        public void edge(String source, String target) {
            edges.map(source, target);
        }

        public String toDOT() {
            StringBuilder buf = new StringBuilder();
            buf.append("digraph G {\n");
            buf.append("  ranksep=.25;\n");
            buf.append("  edge [arrowsize]=.5\n");
            buf.append("  node [shape=circle, fontname=\"ArialNorrow\",\n");
            buf.append("        fontsize=12, fixedsize=true, height=.45];\n");
            buf.append("  ");
            for (String node : nodes) {
                buf.append(node);
                buf.append("; ");
            }
            buf.append("\n");
            for (String src : edges.keySet()) {
                for (String trg : edges.get(src)) {
                    buf.append("   ");
                    buf.append(src);
                    buf.append(" -> ");
                    buf.append(trg);
                    buf.append(";\n");
                }
            }
            buf.append("}\n");
            return buf.toString();
        }

    }


}
