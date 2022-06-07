package com.javabasic;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        System.out.println(System.identityHashCode(array));
        System.out.println(Arrays.toString(array));
        int capacity = 5;
        int[] oldArray = array;
        System.out.println(System.identityHashCode(oldArray));
        System.out.println(Arrays.toString(oldArray));
        array = new int[capacity*2];
        for(int i=0; i< oldArray.length;i++){
            array[i] = oldArray[i];
        }
        System.out.println(System.identityHashCode(array));
        System.out.println(Arrays.toString(array));

    }
}
