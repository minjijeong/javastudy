package com.design_pattern._03_behavioral.observer.example;

public class MyEvent {
    private String message;
    public MyEvent(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
