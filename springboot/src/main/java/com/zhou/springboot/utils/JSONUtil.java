package com.zhou.springboot.utils;

import com.alibaba.fastjson.JSONObject;
import com.zhou.springboot.model.TestBean;

public class JSONUtil {

    public static JSONObject String2JsonObject(String str){
        return JSONObject.parseObject(str);
    }

    public static Object JsonObject2Object(JSONObject jsonObject,Class clazz){
        JSONObject.toJSONString(new TestBean());
        return JSONObject.parseObject(jsonObject.toJSONString(),clazz);
//        JSONObject.toJSON()
    }

}
