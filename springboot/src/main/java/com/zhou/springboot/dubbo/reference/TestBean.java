package com.zhou.springboot.dubbo.reference;

import com.zhou.springboot.dubbo.ServiceBeanInterface;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

    @Reference
    private ServiceBeanInterface service;

    public String test(){
        return service.doService();
    }

}
