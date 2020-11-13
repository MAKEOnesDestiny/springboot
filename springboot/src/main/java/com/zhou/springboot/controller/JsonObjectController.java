package com.zhou.springboot.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhou.springboot.controller.wirecollection.InterfaceTest;
import com.zhou.springboot.model.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/json")
public class JsonObjectController {

    @Autowired
    private Result result;

    @Autowired
    private List<InterfaceTest> interfaceTests;


    @PostMapping("/test2")
    public JSONObject test2(@RequestBody String string){
        JSONObject jsonObject = JSONObject.parseObject(string);
        return jsonObject;
    }

    @PostMapping("/test3")
    public String test3(){
        return "OK";
    }

//    @PostMapping("/dubbo")
//    public String testDubbo(){
//        return serviceBeanInterface.doService();
//    }
}
