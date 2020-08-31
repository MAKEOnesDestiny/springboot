package com.zhou.springboot.leetcode;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(1,"1");
        treeMap.put(2,"2");
        treeMap.put(3,"3");
        treeMap.put(4,"4");

        System.out.println(treeMap.firstKey());
    }

}
