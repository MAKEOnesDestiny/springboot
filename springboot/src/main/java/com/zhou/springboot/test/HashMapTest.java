package com.zhou.springboot.test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("ids",1);
        Map<String,Object> hh = new HashMap<>(hashMap);
        hh.put("ids",2);
        System.out.println(hashMap.get("ids"));
        System.out.println(hh.get("ids"));
    }

}
