package com.javabasic;

public class Gold implements Mineral {
    int weight = 100;

    @Override
    public int getValue() {
        return weight;
    }
}
