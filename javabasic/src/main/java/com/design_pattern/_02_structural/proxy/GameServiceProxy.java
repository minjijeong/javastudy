package com.design_pattern._02_structural.proxy;

public class GameServiceProxy implements GameService{

    private GameService gameService;
    public GameServiceProxy(GameService gameService){
        this.gameService = gameService;
    }
    @Override
    public void startGame() {
        long before = System.currentTimeMillis();
        gameService.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}
