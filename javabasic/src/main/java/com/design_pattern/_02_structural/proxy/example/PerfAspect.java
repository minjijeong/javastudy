package com.design_pattern._02_structural.proxy.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfAspect {
    // ProceedingJoinPoint 특정 메소드를 지칭
    @Around("bean(gameService)")
    public void timestamp(ProceedingJoinPoint point) throws Throwable {
        long before = System.currentTimeMillis();
        point.proceed(); // 타켓메소드를 실행, 별도의 지정 없이
        System.out.println(System.currentTimeMillis() - before);
    }
}
