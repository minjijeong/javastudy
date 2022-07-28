package com.designpattern.factorymethod.java;

import com.designpattern.factorymethod.BlackShip;
import com.designpattern.factorymethod.WhiteShip;

public class SimpleFactory {
    public Object createProduct(String name){
        if(name.equals("whiteship")){
            return new WhiteShip();
        }else if(name.equals("blackship")){
            return new BlackShip();
        }
        throw new IllegalArgumentException();
    }
}
