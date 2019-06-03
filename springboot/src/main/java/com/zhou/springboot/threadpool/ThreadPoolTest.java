package com.zhou.springboot.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest {



    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future future = pool.submit(new Callable<Object>(){
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                System.out.println(1);
                return new Object();
            }
        });
        try {
            Object object = future.get(1,TimeUnit.SECONDS);
            System.out.println(object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            future.cancel(true);
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
        }
    }

}
