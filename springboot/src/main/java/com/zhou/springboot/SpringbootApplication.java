package com.zhou.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhou.springboot.dao.TimeOutMapper;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(scanBasePackages = {"com.zhou.springboot.controller", "com.zhou.springboot.model",
        "com.zhou.springboot.dao", "com.zhou.springboot"}
        , exclude = {CloudAutoConfiguration.class, EurekaClientAutoConfiguration.class
//                , DataSourceAutoConfiguration.class
})
@RestController
@MapperScan(value = "com.zhou.springboot.dao")
@PropertySource("classpath:/spring/dubbo-provider.properties")
@ImportResource
public class SpringbootApplication implements EnvironmentAware {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication
                .run(SpringbootApplication.class, args);       //main entry
        TimeOutMapper tom = applicationContext.getBean(TimeOutMapper.class);
        while(true) {
            System.out.println(tom.selectCount());
            Thread.sleep(1000L);
        }
        //        new ThreadTest();
        //        DispatcherServlet ds = applicationContext.getBean(DispatcherServlet.class);
        //        applicationContext.getBean("testMapper");
        //        applicationContext.publishEvent(new MyEvent(new Object()));

    }

/*    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory(@Autowired DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean;
    }*/

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
