package com.zhou.springboot.leqee;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class JSONReadTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/hfzhou/Desktop/彩妆.json");
        int length = fis.available();
        byte[] bytes = new byte[length];
        fis.read(bytes);
        String s = new String(bytes);
        JSONObject jo = JSONObject.parseObject(s);

        JSONReadTest jrt = new JSONReadTest();
        jrt.recursive(jo, null, 1);
        System.out.println(jrt.tts);
    }

    public List<TagTree> tts = new ArrayList<>();

    public void recursive(JSONObject jo, TagTree parent, int index) {
        String title = (String) jo.get("title");
        JSONArray topics = (JSONArray) jo.get("topics");

        int leaf = 0;
        String[] keywords = null;
        if (topics == null) {
            leaf = 1; //代表是叶子节点
            keywords = title.replaceAll("，", ",").split(",");
        }
        TagTree tt;
        if (parent == null) {
            tt = new TagTree("m", title, leaf, null, keywords); //先生成当前节点的树
        } else {
            tt = new TagTree((parent.getTagCode() + "." + index), title, leaf, parent, keywords); //先生成当前节点的树
        }

        tts.add(tt);
        if (topics != null && topics.size() > 0) {
            for (int i = 0; i < topics.size(); i++) {
                recursive(topics.getJSONObject(i), tt, i + 1);
            }
        }
    }


}
