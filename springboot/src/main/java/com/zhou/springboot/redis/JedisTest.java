package com.zhou.springboot.redis;

import redis.clients.jedis.Jedis;

public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 7000);
//        jedis.pipelined().lpush();
        String resp = jedis.set("mytestkey", "123");
        System.out.println(resp);
    }

}
