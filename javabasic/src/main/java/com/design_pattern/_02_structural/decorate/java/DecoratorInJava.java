package com.design_pattern._02_structural.decorate.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;

public class DecoratorInJava {
    public static void main(String[] args) {
        // IO
        // FileInputStream 기준으로 보면 adapter 패턴일수 있지만
        // 관점과 사용에 따라 Decorator 패턴으로도 볼수 있다.
//        try(InputStream is = new FileInputStream("input.txt");
//            // InputStreamReader로 InputStream을 감싸고(=decorating)
//            InputStreamReader isr = new InputStreamReader(is);
//            // BufferedReader로 InputStreamReader을 감싸고(=decorating)
//            BufferedReader reader = new BufferedReader(isr)){
//            while(reader.ready()){
//                System.out.println(reader.readLine());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        // Collections가 제공하는 데코레이터 메소드
        ArrayList list = new ArrayList<>();
        list.add(new Book());

        // 부가적인 기능을 추가해서 변환해주는 메소드
        // checked~ 타입을 확인하여 반환
        List books = Collections.checkedList(list, Book.class);
        books.add(new Book());
        // checkedList로 생성되어, Book 외의 타입을 받을 수 없도록 세팅
        // books.add(new Item()); // 오류발생

        List unmodifiableList = Collections.unmodifiableList(list);
        // unmodifiableList 리스트는 더이상 변경이 어렵기 때문에 추가하는 것도 오류가 난다.
        // unmodifiableList.add(new Item()); // 오류발생
        // unmodifiableList.add(new Book()); // 오류발생


        // Collections.synchronized*()

        // 서블릿 요청 또는 응답 랩퍼
        HttpServletRequestWrapper requestWrapper;
        HttpServletResponseWrapper responseWrapper;
    }

    private static class Book{

    }

    private static class Item{

    }
}
