package com.zhou.springboot.mybatis.config;


import com.zhou.springboot.mybatis.interceptor.CustomMybatisPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

@Configuration
public class MybatisConfig {
    //注意，这里必须是tkmybatis的ConfigurationCustomizer
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (configuration) -> {
            configuration.addInterceptor(new CustomMybatisPlugin());
        };
    }
}
