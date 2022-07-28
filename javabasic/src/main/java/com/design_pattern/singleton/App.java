package com.design_pattern.singleton;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        EagerSingleton singleton = EagerSingleton.getInstance();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                StaticInnerSingleton singleton = StaticInnerSingleton.getInstance();
                System.out.println("Sync-> " + Thread.currentThread().getName() + ":"+ singleton.hashCode());
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                StaticInnerSingleton singleton = StaticInnerSingleton.getInstance();
                System.out.println("Sync-> " + Thread.currentThread().getName() + ":"+ singleton.hashCode());
            }).start();
        }
    }
}
