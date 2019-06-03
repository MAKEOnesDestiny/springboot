package com.zhou.springboot.multithread.suspendthread;

public class YieldThread extends Thread{

    private long num;

    @Override
    public void run() {
        super.run();
        long begin = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            this.yield();
            num++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public static void main(String[] args){
        new YieldThread().run();
    }


}
