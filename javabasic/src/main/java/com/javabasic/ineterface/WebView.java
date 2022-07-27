package com.javabasic.ineterface;

public class WebView implements ViewInterface{
    @Override
    public void printView(String content) {
        System.out.println("WEB VIEW :: " + content);
    }
}
