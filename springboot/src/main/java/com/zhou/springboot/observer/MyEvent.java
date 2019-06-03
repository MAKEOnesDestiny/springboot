package com.zhou.springboot.observer;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
        System.out.println("My event instantiated");
    }
}
