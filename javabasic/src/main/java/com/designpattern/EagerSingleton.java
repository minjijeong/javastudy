package com.designpattern;

/**
 * 클라이언트에서 사용하지 않더라도 인스턴스는 항상 생성된다는 것이 단점이다.
 *
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    // 생성자 contructor
    private EagerSingleton(){
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}
