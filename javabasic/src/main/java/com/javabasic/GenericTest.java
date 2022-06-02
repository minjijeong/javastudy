package com.javabasic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static class Storage<T> {
        T item;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args){
        Storage<String> storage1 = new Storage<>();
        storage1.setItem("test!!!");

        Storage<Integer> storage2 = new Storage<>();
        storage2.setItem(128883991);

        System.out.println(storage1.getItem()); // test!!!
        System.out.println(storage2.getItem()); // 128883991

        GenericTest gt2 = new GenericTest();

        System.out.println(gt2.convert(storage1)); // [t, e, s, t, !, !, !]
        System.out.println(gt2.convert(storage2)); // [1, 2, 8, 8, 8, 3, 9, 9, 1]
    }

    public <T> List<Character> convert(Storage<T> storage) {
        ArrayList<Character> list = new ArrayList<>();

        String s = String.valueOf(storage.getItem());
        int size = s.length();
        for (int i = 0; i < size; i++) {
            list.add(s.charAt(i));
        }
        return list;
    }


}
