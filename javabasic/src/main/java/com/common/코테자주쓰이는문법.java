package com.common;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class 코테자주쓰이는문법 {
    public static void main(String[] args){
        string();
    }

    private static void string() {
        char[] chars  = "ABCD".toCharArray();
        List<Character> charList = new LinkedList<>();
        for(char c : chars) charList.add(c);

        //  List<Character> -> String
        String result = charList.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.printf(" List<Character> -> String  : %s \n", result);

        // char[] -> String
        String result2 = String.valueOf(chars);
        System.out.printf(" char[] -> String  : %s \n", result2);
    }

}
