package com.design_pattern._01_creational.singleton;

import java.io.Serializable;

public class SynchronizedSingleton implements Serializable {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){}

    // synchronized 예약어를 통해 class lock
    // 메소드 호출할때마다 동기화 처리 되므로 느릴수 있다.
    public static synchronized SynchronizedSingleton getInstance(){
        if(instance == null){
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
