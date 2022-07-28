package com.design_pattern._01_creational.factory_method.java;

import com.design_pattern._01_creational.factory_method.WhiteShip;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public String hello(){return "hello";}

    @Bean
    public WhiteShip whiteship(){return  new WhiteShip();}
}
