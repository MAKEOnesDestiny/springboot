package com.zhou.springboot.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class ChangableThreadPool extends ScheduledThreadPoolExecutor {

    public ChangableThreadPool(int corePoolSize) {
        super(corePoolSize);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {

        return super.decorateTask(runnable, task);
    }
}
