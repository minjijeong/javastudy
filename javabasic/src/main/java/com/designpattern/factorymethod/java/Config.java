package com.designpattern.factorymethod.java;

import com.designpattern.factorymethod.BlackShip;
import com.designpattern.factorymethod.ShipFactory;
import com.designpattern.factorymethod.WhiteShip;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public String hello(){return "hello";}

    @Bean
    public WhiteShip whiteship(){return  new WhiteShip();}
}
