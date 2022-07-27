package com.designpattern.factorymethod;

/**
 *
 */
public class Client {
    public static void main(String[] args){
        Client client = new Client();

        Ship whiteShip = new WhiteShipFactory().orderShip("WhiteShip", "keesun@gamil.com");
        System.out.println(whiteShip);

        Ship blackShip = new BlackShipFactory().orderShip("blackShip", "keesun@gmail.com");
        System.out.println(blackShip);

    }
}
