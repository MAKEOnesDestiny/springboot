package com.zhou.springboot.redis;

import com.zhou.springboot.utils.BitmapUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BitMapTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testBitMap() {
        //模拟从数据库获取到的id
        List<Long> ids = new ArrayList<Long>() {{
            add(123456L);
            add(1L);
        }};
        byte[] bytes = new byte[123456];
        bytes[0] = 1;
        bytes[123455] = 1;
        String bitMapStr = new String(bytes);

        //时间+筛选code+订单offset
        redisTemplate.opsForValue().set("202012251000:code1:1", bitMapStr);

        String s = (String) redisTemplate.opsForValue().get("202012251000:code1:1");
        List res = BitmapUtil.bitmapToIds(s, 1);

        //        redisTemplate.opsForValue().setBit("202011240100:code1:100000",2L,true);

        System.out.println();

        //        redisTemplate.opsForHash().put("202011240100:code1:100","1","10001");

    }


}
