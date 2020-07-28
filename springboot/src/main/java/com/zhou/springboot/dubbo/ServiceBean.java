package com.zhou.springboot.dubbo;

import org.apache.dubbo.config.annotation.Service;

@Service
public class ServiceBean implements ServiceBeanInterface {
    @Override
    public String doService() {
        return "I'm local service";
    }
}
