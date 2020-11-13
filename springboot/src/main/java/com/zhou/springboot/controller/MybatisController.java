package com.zhou.springboot.controller;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.TypeConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {



    public static void main(String[] args) {
        TypeConverter converter= new BeanWrapperImpl();
        List<String> map = converter.convertIfNecessary("111,222",List.class);
        System.out.println();
    }

}
