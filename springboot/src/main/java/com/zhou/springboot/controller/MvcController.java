package com.zhou.springboot.controller;


import com.zhou.springboot.bean.TestMvcFatherBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/mvc")
public class MvcController {

    @RequestMapping("test")
    public void testmvc(TestMvcFatherBean fatherBean){
        System.out.println(fatherBean.getSon().getId());
    }

}
