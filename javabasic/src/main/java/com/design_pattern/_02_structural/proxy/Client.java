package com.design_pattern._02_structural.proxy;

public class Client {
    public static void main(String[] args) {
        // startGame 실행 시간을 측정하는 Stop Watch 추가하기
        GameService gameService = new GameService();
        gameService.startGame();
    }
}
