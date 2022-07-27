package com.designpattern.factorymethod;

public class Client {
    public static void main(String[] args){
        Client client = new Client();

        Ship whiteShip = ShipFactory.orderShip("WhiteShip", "keesun@gamil.com");
        System.out.println(whiteShip);

        Ship blackShip = ShipFactory.orderShip("blackShip", "keesun@gmail.com");
        System.out.println(blackShip);

    }
}
