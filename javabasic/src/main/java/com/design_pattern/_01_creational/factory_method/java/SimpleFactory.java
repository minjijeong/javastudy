package com.design_pattern._01_creational.factory_method.java;

import com.design_pattern._01_creational.factory_method.BlackShip;
import com.design_pattern._01_creational.factory_method.WhiteShip;

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
