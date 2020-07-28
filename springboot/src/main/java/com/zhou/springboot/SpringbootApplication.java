package com.zhou.springboot;

import com.zhou.springboot.observer.MyEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//exclude = {DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}
@SpringBootApplication(scanBasePackages = "com.zhou.springboot.controller")
@RestController
@RequestMapping("/springboot")
@MapperScan(value = "com.zhou.springboot.dao")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class SpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);       //main entry
//        applicationContext.getBean("testMapper");
//        applicationContext.publishEvent(new MyEvent(new Object()));

    }

}
