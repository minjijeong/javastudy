package com.javabasic;

public class Silver implements Mineral {
    int weight = 90;

    @Override
    public int getValue() {
        return weight;
    }
}
