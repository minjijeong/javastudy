package com.designpattern.singleton;

/**
 * - 생성자를 private로 만든 이유?
 *  -   객체 생성을 제한 하기 위해
 * - getInstance()가 멀티쓰레드 환경에서 안전하지 않은 이유?
 * ( = Thread safe 하지 않는 이유)
 *  -   쓰레드가 동시에 getInstance 호출한 경우, 각자 인스턴스를 생성
 */
public class PrivateStaticSingleton {

    private static PrivateStaticSingleton instance;

    // 생성자
    private PrivateStaticSingleton(){}

    public static PrivateStaticSingleton getInstance(){
        if(instance == null){
            instance = new PrivateStaticSingleton();
        }
        return instance;
    }
}
