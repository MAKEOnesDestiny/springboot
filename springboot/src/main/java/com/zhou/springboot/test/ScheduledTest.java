package com.zhou.springboot.test;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ScheduledTest {

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
//        BeanUtils.instantiateClass();
/*
        ScheduledExecutorService s = Executors.newScheduledThreadPool(2);
        s.schedule(() -> {
            System.out.println("hahhahahah");
        }, 10, TimeUnit.SECONDS);
*/
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        rwLock.readLock().lock();

        ScheduledExecutorService ss = new ChangeAbleScheduledThreadPoolExecutor(10);
        ss.scheduleAtFixedRate(() -> {
            System.out.println(new Date());
//            throw new RuntimeException();
        }, 1, 5, TimeUnit.SECONDS);

        Thread.sleep(20 * 1000);
        ChangeAbleScheduledThreadPoolExecutor.override = true;
    }

    public static class ChangeAbleScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

        public static long overridePeriod = 10 * 1000 * 1000 * 1000L;

        public static boolean override = false;

        public ChangeAbleScheduledThreadPoolExecutor(int corePoolSize) {
            super(corePoolSize);
        }

        public ChangeAbleScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
            super(corePoolSize, threadFactory);
        }

        public ChangeAbleScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler) {
            super(corePoolSize, handler);
        }

        public ChangeAbleScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, threadFactory, handler);
        }

        @Override
        protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
            try {
                Class tClass = Class.forName("java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask");
                Constructor c = tClass.getDeclaredConstructor(ScheduledThreadPoolExecutor.class, Runnable.class, Object.class, long.class, long.class);
                Field timeField = ReflectionUtils.findField(tClass, "time");
                timeField.setAccessible(true);
                Field periodField = ReflectionUtils.findField(tClass, "period");
                periodField.setAccessible(true);
                RunnableScheduledFuture result = (RunnableScheduledFuture<V>) BeanUtils.instantiateClass(c,
                        this,
                        runnable,
                        null,
                        ReflectionUtils.getField(timeField, task),
                        override ? overridePeriod : ReflectionUtils.getField(periodField, task));
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return task;
            }
        }
    }



}
