package com.javabasic;

public class Bronze implements Mineral {
    int weight = 80;

    @Override
    public int getValue() {
        return weight;
    }
}
