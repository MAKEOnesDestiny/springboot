package com.zhou.springboot.mybatis.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.zhou.springboot.mybatis.interceptor.CustomMybatisPlugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import tk.mybatis.mapper.autoconfigure.ConfigurationCustomizer;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class})
@Order(0)
public class MybatisConfig {

    @Autowired
    public ApplicationContext atx;

    @Autowired
    public List<DataSourceProperties> properties;

    @Autowired
    public Environment environment;

    //注意，这里必须是tkmybatis的ConfigurationCustomizer
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (configuration) -> {
            configuration.addInterceptor(new CustomMybatisPlugin());
        };
    }

    public Map<Object, Object> getSourceMap() {
        Map<Object, Object> res = new HashMap<>();
        res.put("mysql", druidDataSource());
        res.put("presto", druidDataSource2());
        return res;
    }

    @Bean(name = {"dynamicSource"})
    public DynamicSource dynamicSource() {
        DynamicSource dynamicSource = new DynamicSource(atx);
        Map<Object,Object> sourceMap = getSourceMap();
        dynamicSource.setDefaultTargetDataSource(sourceMap.get("mysql"));
        dynamicSource.setTargetDataSources(getSourceMap());
        return dynamicSource;
    }

    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    public DataSource druidDataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource2.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource2.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource2.password"));
        return dataSource;
    }

}
