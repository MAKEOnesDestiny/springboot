package com.zhou.springboot.controller;

import com.zhou.springboot.dao.TestMapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/get")
    @ResponseBody
    public String mybatisTest(@RequestParam("userLoginId") String userLoginId){
        return testMapper.selectModultIdByUserLoginId(userLoginId);
    }

    public static void main(String[] args) {
        TypeConverter converter= new BeanWrapperImpl();
        List<String> map = converter.convertIfNecessary("111,222",List.class);
        System.out.println();
    }

}
