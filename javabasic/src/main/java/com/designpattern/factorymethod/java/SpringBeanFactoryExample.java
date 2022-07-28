package com.designpattern.factorymethod.java;

import com.designpattern.factorymethod.WhiteShip;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactoryExample {
    /**
     * AnnotationConfigApplicationContext, ClassPathxmlApplicationContext가 ConCreator 클래스들!
     */
    public static void main(String[] args) {
        // java 파일 기반 bean factory
        BeanFactory javaFactory = new AnnotationConfigApplicationContext(Config.class);
        String hi = javaFactory.getBean("hello", String.class);
        System.out.println(hi);
        System.out.println(hi.hashCode());
        WhiteShip ship = javaFactory.getBean("whiteship", WhiteShip.class);
        System.out.println(ship);
        System.out.println(ship.hashCode());

        // xml 기반 bean factory
        BeanFactory xmlFactory = new ClassPathXmlApplicationContext("config.xml");
        String hello = xmlFactory.getBean("hello", String.class);
        System.out.println(hello);
        System.out.println(hello.hashCode());
        WhiteShip xmlShip = xmlFactory.getBean("whiteship", WhiteShip.class);
        System.out.println(xmlShip);
        System.out.println(xmlShip.hashCode());
    }
}
