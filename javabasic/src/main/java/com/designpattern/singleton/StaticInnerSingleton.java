package com.designpattern.singleton;

public class StaticInnerSingleton {
    private StaticInnerSingleton(){}

    private static class StaticInnerSingletonHolder{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
        private static StaticInnerSingleton otherInstance = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance(){
        System.out.println("otherInstance ->" + StaticInnerSingletonHolder.otherInstance.hashCode());
        System.out.println("INSTANCE ->" + StaticInnerSingletonHolder.INSTANCE.hashCode());

        return StaticInnerSingletonHolder.INSTANCE;
    }

}
