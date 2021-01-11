package com.zhou.springboot.mybatis.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SwitchSource implements Ordered {

    public static String masterName = "mysql";

    public static String slaverName = "presto";

    // 更加完善的数据源切换方案

    @Around("@annotation(dataSource)")
    public Object switchSource(ProceedingJoinPoint point, DataSource dataSource) throws Throwable {
        switch (dataSource.value()) {
            case "mysql":
                DynamicSource.setDataSource(masterName);
                break;
            case "presto":
                DynamicSource.setDataSource(slaverName);
                break;
        }
        String method = point.getSignature().getName();

        Object proceed = point.proceed(point.getArgs());

        // 切换回主数据源
        DynamicSource.setDataSource(masterName);

        return proceed;
    }

    // 同时声明事务和数据源切换的情况下，保证数据源切换先于事务切换
    public int getOrder() {
        return 0;
    }

}
