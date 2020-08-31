package com.zhou.springboot.redis;

import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("spring", "test");
    }

    @Test
    public void testCPU() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void topN() {
        redisTemplate.opsForZSet().add("shop-topn-1", new HashSet<ZSetOperations.TypedTuple>() {{
            add(new DefaultTypedTuple("【贝亲官方旗舰店】新品迪士尼婴儿湿巾棉柔湿纸巾80抽6连包PL350", 5.76d));
            add(new DefaultTypedTuple("【贝亲官方旗舰店】新生儿宽口径玻璃奶瓶婴儿宝宝奶瓶160/240ml", 5.23d));
            add(new DefaultTypedTuple("【贝亲官方旗舰店】湿纸巾婴儿专用棉柔猫爪湿巾大包装", 5.09d));
            add(new DefaultTypedTuple("【贝亲官方旗舰店】宽口径婴儿硅橡胶奶嘴新生儿宝宝奶嘴SS-LL号", 4.85d));
        }});
        redisTemplate.opsForGeo().add("hangzhou", new Point(1.1d, 1.2d), "binjiang");
    }

    @Test
    public void transRate() {
        redisTemplate.opsForHash().putAll("trans_rate_1", new HashMap() {{
            put("付费流量", "1.21");
            put("自主访问", "1.11");
            put("淘内免费", "5.21");
        }});
        System.out.println(redisTemplate.opsForHash().keys("trans_rate_1"));
    }

    //利用zset去实现页面访问统计
    //zremrangebyscore  URL:/controller/test:60m  0 2020100202
    //但是新增数据的(increby)比较不方便
    //删除特别方便
    @Test
    public void clickCountUsingZSet() {
        redisTemplate.opsForZSet().add("URL:/controller/test:60m", new HashSet<ZSetOperations.TypedTuple>() {{
            //value代表统计数据，score代表时间
            add(new DefaultTypedTuple("1", 2020100200d));
            add(new DefaultTypedTuple("12", 2020100201d));
            add(new DefaultTypedTuple("123", 2020100202d));
            add(new DefaultTypedTuple("1234", 2020100203d));
            add(new DefaultTypedTuple("12345", 2020100204d));
        }});
    }

    //利用hash去实现页面访问统计
    //URL  精度   时间点   count
    //新增数据特别方便
    //删除数据不方便
    @Test
    public void clickCountUsingHash() {
        redisTemplate.opsForHash().putAll("URL:/controller/test:1h", new HashMap() {{
            put("2020100200",10);
            put("2020100201",100);
            put("2020100202",1000);
        }});
        redisTemplate.opsForHash().increment("URL:/controller/test:1h","2020100202",1);
        redisTemplate.opsForHash().increment("URL:/controller/test:1h","2020100302",1);
    }


}
