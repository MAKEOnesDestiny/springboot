package com.zhou.springboot.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.exceptions.JedisRedirectionException;

import java.util.concurrent.*;

public class RedirectExecuteFactory {

    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(20));

    private RedisClusterConfig config;

    public RedirectExecuteFactory(RedisClusterConfig config) {
        this.config = config;
    }

    public <T> T execute(RetryRun<T> callable) throws ExecutionException, InterruptedException {
        callable.redirectExecuteFactory = this;
        if (callable.jedis == null) {
            callable.jedis = new Jedis(this.config.findOne());
        }
        return executor.submit(callable).get();
    }

    static abstract class RetryRun<T> implements Callable<T> {

        Jedis jedis;

        RedirectExecuteFactory redirectExecuteFactory;

        public RetryRun() {
        }

        public RetryRun(RedirectExecuteFactory factory) {
            this.redirectExecuteFactory = factory;
            HostAndPort hostAndPort = redirectExecuteFactory.config.findOne();
            Jedis jedis = new Jedis(hostAndPort);
            this.jedis = jedis;
        }

        RetryRun(Jedis firstJedis, RedirectExecuteFactory factory) {
            this.redirectExecuteFactory = factory;
            this.jedis = firstJedis;
        }

        @Override
        public T call() throws Exception {
            try {
                Response<T> response = doRun(jedis);
                return response.get();
            } catch (JedisRedirectionException e) {
                HostAndPort redirect = e.getTargetNode();
                this.jedis = new Jedis(redirect);
                System.out.println("redirect to " + redirect);
                return redirectExecuteFactory.execute(this);
            } catch (Throwable e) {
                throw e;
            }
            //if other exception happens,retry will stop.
        }

        public abstract Response<T> doRun(Jedis jedis);

    }

}
