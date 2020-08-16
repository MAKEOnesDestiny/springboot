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

}
