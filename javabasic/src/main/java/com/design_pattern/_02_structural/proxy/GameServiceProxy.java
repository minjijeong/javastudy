package com.design_pattern._02_structural.proxy;

public class GameServiceProxy extends GameService{
    @Override
    public void startGame() {
        long before = System.currentTimeMillis();
        super.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
