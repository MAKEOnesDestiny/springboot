package com.zhou.springboot.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCacheTest {

    public static void main(String[] args) throws ExecutionException {
//        CacheLoader.from()
        Cache<String, String> cache = CacheBuilder.newBuilder()
//                .expireAfterWrite(8, TimeUnit.SECONDS)
                .maximumSize(2)
                .removalListener(t -> {
                    System.out.println(t.getKey() + ",我被移除了");
                })
                .build();
        cache.put("1", "1");
        cache.put("2", "2");
        cache.get("1", () -> {return "1";});
        cache.put("3", "3");
//        cache.put("4", "4");
    }

}
