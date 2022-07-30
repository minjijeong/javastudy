package com.design_pattern._02_structural.proxy;

public class Client {
    public static void main(String[] args) {
        // startGame 실행 시간을 측정하는 Stop Watch 추가하기
        // proxy로 default 서비스 의존성 주입하고 감싸준다
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }
}
