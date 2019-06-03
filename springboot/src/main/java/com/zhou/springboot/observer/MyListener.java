package com.zhou.springboot.observer;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener {

//    @EventListener
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof MyEvent) {
            MyEvent myEvent = (MyEvent) event;
            System.out.println("MyListener deals MyEvent");
        }
    }
}
