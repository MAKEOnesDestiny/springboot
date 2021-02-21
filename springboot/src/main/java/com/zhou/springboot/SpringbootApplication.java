package com.zhou.springboot;

import com.zhou.springboot.dao.TestBiz;
import com.zhou.springboot.dao.TimeOutMapper;
import com.zhou.springboot.rocketmq.RocketMqTransTest;
import com.zhou.springboot.rocketmq.RocketMqVersionTest;
import java.io.UnsupportedEncodingException;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.elasticsearch.ElasticsearchHealthIndicatorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackages = {"com.zhou.springboot.controller", "com.zhou.springboot.model",
        "com.zhou.springboot.dao", "com.zhou.springboot"}
        , exclude = {CloudAutoConfiguration.class, EurekaClientAutoConfiguration.class
        , ElasticsearchHealthIndicatorAutoConfiguration.class
        , ElasticsearchAutoConfiguration.class
        , ElasticsearchDataAutoConfiguration.class
        , ElasticsearchRepositoriesAutoConfiguration.class

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
        TestBiz testBiz = ac.getBean(TestBiz.class);
        testBiz.testMysql();
        //        testBiz.testPresto();

        //        testHATable(ac);
        //        testTrans(ac);
        //        testVersionConsume(ac);
        //        testDealLock(ac);
    }

    public static void testHATable2(ApplicationContext ac) throws InterruptedException {
        TimeOutMapper mapper = ac.getBean(TimeOutMapper.class);
        TestBiz testBiz = ac.getBean(TestBiz.class);

        testBiz.doRename1();
        System.out.println("迁移成功");
    }

    public static void testHATable(ApplicationContext ac) throws InterruptedException {
        TimeOutMapper mapper = ac.getBean(TimeOutMapper.class);
        TestBiz testBiz = ac.getBean(TestBiz.class);
        //不能开启事务，如果开启事务则会导致commit的时候隐式释放锁
        mapper.lockTable();
        System.out.println("加锁成功");

        //模拟同步数据操作
        Thread.sleep(7 * 1000);

        testBiz.doRename();
        System.out.println("更改表名成功");
        //        Thread.sleep(7 * 1000);

        //        mapper.unlockTable();

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

    public static void testDealLock(ApplicationContext applicationContext) {
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

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
