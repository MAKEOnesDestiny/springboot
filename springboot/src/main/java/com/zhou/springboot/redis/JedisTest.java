package com.zhou.springboot.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

public class JedisTest {

    public static void test() throws ExecutionException, InterruptedException {
        RedisClusterConfig config = new RedisClusterConfig("127.0.0.1:7000", "127.0.0.1:7001", "127.0.0.1:7002"
                , "127.0.0.1:7003", "127.0.0.1:7004", "127.0.0.1:7005");
        RedirectExecuteFactory factory = new RedirectExecuteFactory(config);
        Object result = factory.execute(new RedirectExecuteFactory.RetryRun() {
            @Override
            public Response doRun(Jedis jedis) {
                Pipeline pipeline = jedis.pipelined();
                pipeline.lpush("recent:", "Lebron", "kebo", "周豪峰", "小明");
                Response res1 = pipeline.lrem("recent:", 0, "Lebron");
                Response res2 = pipeline.lpush("recent:", "Lebron");
                Response res3 = pipeline.ltrim("recent:", 0, 3);
                pipeline.sync();
                return res1;
                //                return new ResponseComposition(new ArrayList<Response>() {{
                //                    add(res1);
                //                    add(res2);
                //                    add(res3);
                //                }});
            }
        });
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis();
        Long begin = System.currentTimeMillis();
        String s = jedis.get("20200422090000:55:193310865");
        Long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    static class LogRetryRun extends RedirectExecuteFactory.RetryRun<Object> {

        @Override
        public Response doRun(Jedis jedis) {
            Pipeline pipeline = jedis.pipelined();
            Response response1 = pipeline.zadd("slowest:AccessTime", 15.1, "首页1");
            Response response2 = pipeline.zremrangeByRank("slowest:AccessTime", 0, -101); //
            //                Response<List<Object>> response = pipeline.exec();
            pipeline.sync();
            return response1;
        }
    }

    static class IpRetryRun extends RedirectExecuteFactory.RetryRun<Long> {

        public static final String[] city = new String[]{"hangzhou", "beijing", "shanghai", "taizhou"};

        public static final Double[] ip_score = new Double[]{123d, 124d, 125d, 126d};

        @Override
        public Response<Long> doRun(Jedis jedis) {
            Pipeline pipeline = jedis.pipelined();
            Map<String, Double> cityAndIp = new HashMap<>();
            for (int i = 0; i < city.length; i++) {
                cityAndIp.put(city[i] + "_" + i, ip_score[i]);
            }
            Response<Long> response = pipeline.zadd("ip2cityid:", cityAndIp);
            pipeline.sync();
            return response;
        }
    }

    static class CityidRetryRun extends RedirectExecuteFactory.RetryRun<Long> {

        public static final String[] city = new String[]{"hangzhou", "beijing", "shanghai", "taizhou"};

        public static final String[] city_info = new String[]{"{'name':'aaa'}", "{'name':'bbb'}", "{'name':'ccc'}",
                "{'name':'ddd'}"};

        @Override
        public Response<Long> doRun(Jedis jedis) {
            Pipeline pipeline = jedis.pipelined();
            Map<String, String> cityAndInfo = new HashMap<>();
            for (int i = 0; i < city.length; i++) {
                cityAndInfo.put(city[i] + "_" + i, city_info[i]);
            }
            Response<Long> response = pipeline.hset("cityid2city:", cityAndInfo);
            pipeline.sync();
            return response;
        }
    }

    static class MaintainRetryRun<String> extends RedirectExecuteFactory.RetryRun<java.lang.String> {

        @Override
        public Response<java.lang.String> doRun(Jedis jedis) {
            Pipeline pipeline = jedis.pipelined();
            Response response = pipeline.get("is-under-maintenance");
            pipeline.sync();
            return response;
        }
    }


}
