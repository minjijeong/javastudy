package com.OOPRules.lsp;

public class Main {
    public static void main(String[] args){
        //
        Rectangle rectangle = new Square(50);
        resize(rectangle,100,150);
        System.out.println(rectangle.toString()); // 출력 150
    }

    public static void resize(Rectangle rectangle, int width, int height){
        if(rectangle.getClass() == Square.class){
            throw new IllegalArgumentException();
        }
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        if(rectangle.getHeight() != height && rectangle.getWidth() != width){
            throw new IllegalStateException();
        }
    }
}
