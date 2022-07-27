package com.OOPRules.lsp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle {
    private int width, height;

    public int getArea(){
        return width * height;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
