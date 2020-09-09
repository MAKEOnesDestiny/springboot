package com.zhou.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;


@SpringBootApplication(scanBasePackages = {"com.zhou.springboot.controller", "com.zhou.springboot.model",
        "com.zhou.springboot.dao","com.zhou.springboot"}
        , exclude = {CloudAutoConfiguration.class, EurekaClientAutoConfiguration.class})
@RestController
@MapperScan(value = "com.zhou.springboot.dao")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class SpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
                .run(SpringbootApplication.class, args);       //main entry
        DispatcherServlet ds = applicationContext.getBean(DispatcherServlet.class);
        System.out.println();
        //        applicationContext.getBean("testMapper");
        //        applicationContext.publishEvent(new MyEvent(new Object()));

    }

}
