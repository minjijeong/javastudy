package com.design_pattern._02_structural.adapter.java;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class AdapterInJava {
    public static void main(String[] args) {
        // 배열 인터페이스 -> 리스트 인터페이스로 변환
        List<String> strings = Arrays.asList("a","b","c"); // 가변인자 T...

        // 리스트 인터페이스 -> Enumeration 변환
        Enumeration<String> enumeration = Collections.enumeration(strings);
        while(enumeration.hasMoreElements()){
            String str = enumeration.nextElement();
            System.out.println(str);
        }

        // Enumeration -> List로 변환
        ArrayList<String> list = Collections.list(enumeration);

        // IO
        // File -> InputStream으로 변환
        // FileInputStream은 InputStream을 상속받아서 해당형으로 리턴
        try(InputStream is = new FileInputStream("input.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr)){
            while(reader.ready()){
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
