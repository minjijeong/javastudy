package com.javabasic;

import java.util.ArrayList;

public class Calculator {
    int value;
    Integer valueInteger;


    Calculator() {
        this.value = 0;
        this.valueInteger = 0;
    }


    int getValue() {
        return this.value;
    }
    Integer getValueInteger() {
        return this.valueInteger;
    }
    void add(int val) {
        this.value += val;
    }

    void addInteger(int val) {
        this.valueInteger += val;
    }

    boolean isOdd(){
        // 홀수이면 true, 짝수이면 false
        return this.value % 2 != 0;
    }

    int avg(ArrayList<Integer> arr){
        int avg = 0;
        int tot = 0;
        for(int a : arr){
            tot += a;
        }
        return tot/arr.size();
    }

    int avg(int[] arr){
        int avg = 0;
        int tot = 0;
        for(int a : arr){
            tot += a;
        }
        return tot/arr.length;
    }
}
