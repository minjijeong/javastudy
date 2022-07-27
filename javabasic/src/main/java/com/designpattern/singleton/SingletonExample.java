package com.designpattern.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonExample {
    public static void main(String[] args){
        // 1. Runtime
        // Runtime 인스턴스는 싱글톤으로 구현되어 있어 신규 인스턴스 생성 안됨
        // Runtime runtime = new Runtime();
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());

        // 2. Spring
        // singleton scope으로 구현해서 쓴다.
        // 빌더, 퍼사드, 추상 팩토리 등 다른 패턴의 구현체의 일부로 쓰이기도 한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String hello = applicationContext.getBean("hello", String.class);
        String hello2 = applicationContext.getBean("hello", String.class);
        System.out.println(hello == hello2);
    }
}
