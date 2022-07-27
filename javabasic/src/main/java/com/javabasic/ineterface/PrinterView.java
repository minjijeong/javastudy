package com.javabasic.ineterface;

public class PrinterView implements ViewInterface{
    @Override
    public void printView(String content) {
        System.out.println("PRINTER :: printing~~ "+content);
    }
}
