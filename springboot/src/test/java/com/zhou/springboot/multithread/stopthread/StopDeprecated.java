package com.zhou.springboot.multithread.stopthread;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 第1章、Java多线程技能 P34
 *
 * @author zhou
 * @date 2018-7-11
 */
@Data
@AllArgsConstructor
public class StopDeprecated extends Thread{

    private Bean bean;

    @Data
    public static class Bean{
        private String name;
        private String city;

        public void setAttr(String name,String city){
            this.name=name;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        StopDeprecated thread = new StopDeprecated(new Bean());
        thread.start();
        Thread.sleep(100);
        thread.stop();
        thread.getBean().printString();
    }


}
