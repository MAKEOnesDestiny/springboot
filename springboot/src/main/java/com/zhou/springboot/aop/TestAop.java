package com.zhou.springboot.aop;

import com.zhou.springboot.bean.EnumTest2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TestAop {

    @Pointcut("execution(* com.zhou.springboot.controller.JsonObjectController.test3())")
    public void test() {
    }

    @Before("test()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("aaaaaaaaaa");
    }

}
