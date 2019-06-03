package com.zhou.springboot.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BeanFactoryTest {


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(null,"1");
        new HashSet<>().add(null);
        System.out.println(new String("asd").hashCode());
    }

}
