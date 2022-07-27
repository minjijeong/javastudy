package com.designpattern.singleton;

import org.omg.CORBA.BAD_CONTEXT;

/**
 * 클라이언트에서 사용하지 않더라도 인스턴스는 항상 생성된다는 것이 단점이다.
 */
public class EagerSingleton {
    // static한 final, 고정 값이므로, 상수로 생각하여 instance 대문자로 표기
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // 생성자 contructor
    private EagerSingleton(){
//        if(INSTANCE != null) {
//            throw new BAD_CONTEXT("test!!");
//        }
    }

    public static EagerSingleton getInstance(){
        System.identityHashCode(INSTANCE);
        System.out.println("getInstance!!");
        return INSTANCE;
    }

    public String getName(){
        return "eager singleton";
    }
}
