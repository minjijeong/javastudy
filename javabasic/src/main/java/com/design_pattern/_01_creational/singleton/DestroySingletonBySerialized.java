package com.design_pattern._01_creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class DestroySingletonBySerialized {
    public static void main(String[] args){
        DoubleCheckedSingleton singleton = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton singleton1;

        // 직렬화하여 파일로 생성 - singleton.obj
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.obj"))){
            out.writeObject(singleton);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // singleton.obj 파일 역직렬화하여 객체정보 주입
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.obj"))){
            singleton1 = (DoubleCheckedSingleton) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(singleton1 == singleton);

        System.out.println("============================");

        EnumSingleton eSingleton = EnumSingleton.INSTANCE;
        EnumSingleton eSingleton2;
        // 직렬화하여 파일로 생성 - singleton.obj
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("enumSingleton.obj"))){
            out.writeObject(eSingleton);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // singleton.obj 파일 역직렬화하여 객체정보 주입
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("enumSingleton.obj"))){
            eSingleton2 = (EnumSingleton) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(eSingleton2 == eSingleton);
    }
}
