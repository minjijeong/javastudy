package com.designpattern.factorymethod;

import org.springframework.beans.factory.annotation.Autowired;

public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
