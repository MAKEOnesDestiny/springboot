package com.zhou.springboot.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MergeTest {

    public static final ExecutorService service = new ThreadPoolExecutor(4, 4, 0, TimeUnit.SECONDS,
                                                                         new LinkedBlockingQueue<>());

}
