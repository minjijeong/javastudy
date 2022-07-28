package com.design_pattern.factory_method;

public class Client {
    public static void main(String[] args){
        Client client = new Client();
        // print에 주입되는 ShipFactory 구현체에 따라 적용된다.
        client.print(new WhiteShipFactory(), "WhiteShip", "keesun@mail.com");
        client.print(new BlackShipFactory(), "WhiteShip", "keesun@mail.com");
    }

    private void print(ShipFactory shipFactory, String name, String email){
        System.out.println(shipFactory.orderShip(name, email));
    }
}
