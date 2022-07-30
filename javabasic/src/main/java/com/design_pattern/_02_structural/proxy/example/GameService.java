package com.design_pattern._02_structural.proxy.example;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    public void startGame() {
        System.out.println("이 자리에 오신 여러분을 진심으로 환영합니다.");
    }

}

