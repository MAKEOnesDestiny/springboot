package com.zhou.springboot.multithread.suspendthread;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuspendThread4 extends Thread{

    private Bean bean;

    @Data
    public static class Bean{
        private String name="1";
        private String city="11";

        public void setAttr(String name,String city){
            this.name=name;
            Thread.currentThread().suspend();
            this.city=city;
        }

        public void printString(){
            System.out.println("name="+this.name);
            System.out.println("city="+this.city);
        }

    }

    @Override
    public void run() {
        super.run();
        bean.setAttr("a","aa");
    }

    public static void main(String[] args) throws InterruptedException {
        SuspendThread4 thread = new SuspendThread4(new Bean());
        thread.start();
        Thread.sleep(1000);
        thread.getBean().printString();
    }

}
