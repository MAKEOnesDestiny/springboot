package com.zhou.springboot.dubbo;

import org.apache.dubbo.config.annotation.Service;

@Service
public class ServiceBean implements ServiceBeanInterface {

    @Override
    public String doService() {
        System.out.println("收到请求");
        try {
            return "我是springboot的服务";
//            throw new RuntimeException();
//            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
//        return "I'm local service1111";
    }
}
