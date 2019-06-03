package com.zhou.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhou.springboot.dao.TestMapper;
import com.zhou.springboot.model.TestBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * springboot学习
 *
 * @author zhou
 * @data 2018-8-7
 */
@Log4j2
@Controller
@RequestMapping(value = "/base64")
@Lazy
public class Base64Controller {

    public static void main(String[] args) {
        TestMapper mapper;
        Object object = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{TestMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        mapper = (TestMapper) object;
        mapper.selectModultIdByUserLoginId("1");
        System.out.println(1);
    }

    @Autowired
    private TestMapper testMapper;

    @PostMapping(value = "/exception")
    @ResponseBody
    public String exceptionTest(@RequestBody TestBean data, HttpServletRequest request) {
        int a = 10 / 0;
        return "end";
    }

/*    @PostMapping(value = "/post")
    public JSONObject getBase64(@RequestBody String data) {
        return null;
    }*/

    @PostMapping(value = "/post")
    public String getStream(HttpServletRequest request) {
        InputStream inputStream = null;
        int length = request.getContentLength();
        String data = null;
        try {
            inputStream = request.getInputStream();
            data = getStreamData(inputStream, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("获取输入流中的数据为{}", data);
        return data;
    }

    /**
     * 获取流中的数据
     *
     * @param inputStream
     * @param length
     * @return
     * @throws IOException
     */
    private String getStreamData(InputStream inputStream, int length) throws IOException {
        byte[] bytes = new byte[length];
        int count = -1;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
        while ((count = inputStream.read(bytes)) != -1) {
            bos.write(bytes);
            log.info("正在读取数据中...");
        }
        bytes = null;
        return new String(bytes);
    }

}
