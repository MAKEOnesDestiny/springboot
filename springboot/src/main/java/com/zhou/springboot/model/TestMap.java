package com.zhou.springboot.model;

import java.util.HashMap;

/**
 * JSONObject测试
 *
 * @author zhou
 * @date 2018-8-9
 */
public class TestMap {

    private final HashMap<String,Object> map;

    public TestMap(){
        map = new HashMap<>();
    }

    public Object get(String key){
        return map.get(key);
    }

    public void put(String str,Object obj){
        map.put(str,obj);
    }

}
