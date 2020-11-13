package com.zhou.springboot.mybatis.config;


import com.zhou.springboot.mybatis.interceptor.CustomMybatisPlugin;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (configuration) -> {
            configuration.addInterceptor(new CustomMybatisPlugin());
        };
    }
}
