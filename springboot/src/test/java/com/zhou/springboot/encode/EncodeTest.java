package com.zhou.springboot.encode;

import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class EncodeTest {


    @Test
    public void testEncode() throws UnsupportedEncodingException {
//        String s = "缺少任务类型";
        String s = "{\n"
                + "    \"message\":\"缺少任务类型:str\"\n"
                + "}";
        String s1 = "{\n"
                + "    \"message\": {\n"
                + "        \"type\": \"\\u7f3a\\u5c11\\u4efb\\u52a1\\u7c7b\\u578b:str\"\n"
                + "    }\n"
                + "}\n";
        byte[] ss = s1.getBytes("utf-8");
        for (byte b : ss) {
            System.out.println(ss);
        }
    }


}
