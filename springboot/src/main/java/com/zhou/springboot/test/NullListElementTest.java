package com.zhou.springboot.test;

import java.util.ArrayList;
import java.util.List;

public class NullListElementTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add(null);
        list.add("2");
        for (String s:list) {
            System.out.println(s);
        }
    }


}
