package com.zhou.springboot.collection;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        for (int i = 0; i < 20; i++) {
            map.put(new SameHashCodeBean(),i);
        }
        map.put("1","1");
    }

    static class SameHashCodeBean{
        @Override
        public int hashCode() {
            return 10;
        }
    }

}
