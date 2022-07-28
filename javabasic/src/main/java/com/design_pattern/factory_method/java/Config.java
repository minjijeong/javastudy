package com.design_pattern.factory_method.java;

import com.design_pattern.factory_method.WhiteShip;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public String hello(){return "hello";}

    @Bean
    public WhiteShip whiteship(){return  new WhiteShip();}
}
