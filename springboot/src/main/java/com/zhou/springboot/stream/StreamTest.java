package com.zhou.springboot.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<List<String>> ll = new ArrayList<>();
        List<String> l1 = new ArrayList<String>() {{
            add("1");
            add("2");
        }};
        List<String> l2 = new ArrayList<String>() {{
            add("3");
            add("4");
        }};
        ll.add(l1);
        ll.add(l2);
        String s = ll.stream().flatMap(List::stream).map(String::toString).collect(Collectors.joining(","));
        System.out.println(s);

        List<String> ls = new ArrayList<String>() {{
            add("asd");
            add("123fd");
        }};
        ls.stream().map(String::hashCode).collect(Collectors.toList()).stream().forEach((t) -> {
            System.out.println(t);
        });
    }

}
