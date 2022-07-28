package com.design_pattern.singleton;

import java.io.Serializable;
import java.util.Objects;

public class DoubleCheckedSingleton implements Serializable {
    private static volatile DoubleCheckedSingleton instance = null;
    /**
     * ** 메인메모리와 스레드의 Working 메모리 간에 데이터의 이동이 있기 때문에
     * 메인메모리와 Working 메모리간에 동기화가 진행되는 동안 빈틈이 생기게 되므로,
     * 이를 위해 volatile로 선언해주어야 한다.
     *
     * volatile :
     * 각 스레드가 해당 변수의 값을 메인 메모리에서 직접 읽어온다.
     * volatile 변수에 대한 각 write 는 즉시 메인 메모리로 플러시 된다.
     * 스레드가 변수를 캐시하기로 결정하면 각 read/write 시 메인 메모리와 동기화 된다.
     */
    private DoubleCheckedSingleton(){}

    public static DoubleCheckedSingleton getInstance(){
        // null이 아닌경우 바로 return 해주기 위해
        if(Objects.isNull(instance)){
            // synchronized는 해당 메소드를 호출할때마다 다른 스레드에서 접근할 수 없게 처리한다.
            synchronized (DoubleCheckedSingleton.class){
                // 인스턴스가 실제로 생성되었는지 확인하고 1개만 생성되게 할려고 null 체크를 한다.
                if(Objects.isNull(instance)){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
