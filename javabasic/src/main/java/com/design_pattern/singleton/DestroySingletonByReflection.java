package com.design_pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DestroySingletonByReflection {
    public static void main(String[] args){
        DoubleCheckedSingleton singleton = DoubleCheckedSingleton.getInstance();

        try {
            // constructor
            Constructor<DoubleCheckedSingleton> declaredConstructor = DoubleCheckedSingleton.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true); // private로 선언되어 있는 것 접근 가능하도록 처리
            DoubleCheckedSingleton singleton1 = declaredConstructor.newInstance();

            System.out.println(singleton1 == singleton);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==================");

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton1;
        try {
            Constructor<EnumSingleton> enumSingletonConstructor = EnumSingleton.class.getDeclaredConstructor();
            enumSingletonConstructor.setAccessible(true);
            // enum은 생성자를 가질 수 없어 NoSuchMethodException 발생
            enumSingleton1 = enumSingletonConstructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException|IllegalAccessException e ) {
            throw new RuntimeException(e);
        }
        System.out.println(enumSingleton == enumSingleton1);
    }
}
