package com.zhou.springboot.redis;

import com.zhou.springboot.utils.BitmapUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BitMapBenchTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private NamingModule namingModule;

    public Jedis jedis = new Jedis();

    //618个id,耗时254ms
    @Test
    public void benchmark() {
        redisTemplate.opsForValue().get("testbit");

        Long begin = System.currentTimeMillis();
        String key = "20200422090000:55:193310865";
        String bitmap = redisTemplate.opsForValue().get(key);
        //        String bitmap = jedis.get(key);
        Long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");

        begin = System.currentTimeMillis();
        List<Long> list = BitmapUtil.bitmapToIds(bitmap, namingModule.getOffsetByKey(key));
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms"); //4ms

        begin = System.currentTimeMillis();
        String ss = list.stream().map(String::valueOf).collect(Collectors.joining(","));
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin) + "ms");
        //        System.out.println(list.size());
    }

}
