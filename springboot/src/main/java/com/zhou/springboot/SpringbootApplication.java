package com.zhou.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.zhou.springboot.dao.TestBiz;
import com.zhou.springboot.dao.VersionBiz;
import com.zhou.springboot.rocketmq.RocketMqTransTest;
import com.zhou.springboot.rocketmq.RocketMqVersionTest;
import java.io.UnsupportedEncodingException;
import javax.sql.DataSource;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackages = {"com.zhou.springboot.controller", "com.zhou.springboot.model",
        "com.zhou.springboot.dao", "com.zhou.springboot"}
        , exclude = {CloudAutoConfiguration.class, EurekaClientAutoConfiguration.class
        //                , DataSourceAutoConfiguration.class
})
@RestController
@MapperScan(value = "com.zhou.springboot.dao")  //tkmbatis重新写了mybatis的注解，并且加入了自己的逻辑再里面
@PropertySource("classpath:/spring/dubbo-provider.properties")
@ImportResource
public class SpringbootApplication implements EnvironmentAware {


    public static void main(String[] args)
            throws Exception {
        ApplicationContext ac = SpringApplication
                .run(SpringbootApplication.class, args);       //main entry

        //        testTrans(ac);
//        testVersionConsume(ac);
    }


    public static void testVersionConsume(ApplicationContext ac) throws MQClientException {
        RocketMqVersionTest test = ac.getBean(RocketMqVersionTest.class);
        test.consumeMessage();
    }

    public static void testTrans(ApplicationContext applicationContext)
            throws InterruptedException, RemotingException, UnsupportedEncodingException, MQClientException, MQBrokerException {
        RocketMqTransTest test = applicationContext.getBean(RocketMqTransTest.class);
        test.test();
    }

    public void testDealLock(ApplicationContext applicationContext) {
        TestBiz testBiz = applicationContext.getBean(TestBiz.class);
        new Thread(() -> {

            try {
                testBiz.testDeadLock(1, 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                testBiz.testDeadLock(2, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


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
