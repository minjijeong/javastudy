package com.design_pattern._03_behavioral.observer.example;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {
    @EventListener(MyEvent.class)
    public void onApplicationEvent(MyEvent event){
        System.out.println(event.getMessage());
    }

}
