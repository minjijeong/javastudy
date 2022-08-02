package com.design_pattern._03_behavioral.observer.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;

public class MyRunner implements ApplicationRunner {
    private ApplicationEventPublisher publisher;

    public MyRunner(ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        publisher.publishEvent(new MyEvent("hello spring event"));
    }
}
