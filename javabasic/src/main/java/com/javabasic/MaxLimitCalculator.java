package com.javabasic;

public class MaxLimitCalculator extends Calculator{
    @Override
    void add(int value){
        this.value += value;
        if(this.value > 100){
            this.value = 100;
        }
    }
}
