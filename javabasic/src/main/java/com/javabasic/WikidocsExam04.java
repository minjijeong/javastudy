package com.javabasic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class WikidocsExam04 {
    public static void main(String[] args) {
        // 01. 두 개의 숫자를 입력받아 그 합을 출력하는 프로그램을 작성하시오.
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        /*
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a+" + "+b+" = "+ (a+b));
         */

        // 02. 영문을 입력하고 엔터를 입력하면 입력한 영문을 대문자로 변경하여 출력하는 프로그램을 작성하시오.
        // (단, 사용자가 "END" 라는 문자열을 입력하기 전까지 반복해서 문장을 입력받을 수 있게 할것)
        /*
        String str = "";
        while(!str.toUpperCase().equals("END")){
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(str.toUpperCase());
        }
        */

        // 03. "sample.txt"라는 파일에 "Write once, run anywhere" 문자열을 저장한 후 다시 그 파일을 읽어서 출력
        try {
            FileWriter fw = new FileWriter("sample.txt");
            fw.write("Write once, run anywhere");
            fw.close(); // FileWriter를 닫아주지 않으면 저장이 안되어 읽어 올수 없다.

            br = new BufferedReader(new FileReader("sample.txt"));
            String line = br.readLine();
            System.out.println(line);  // null 이 출력된다.
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 04.사용자의 입력을 파일(sample.txt)에 저장하는 프로그램을 작성해 보자.
        // (단 프로그램을 다시 실행하더라도 기존에 작성한 내용을 유지하고 새로 입력한 내용을 추가해야 한다.)
        try {
            FileWriter fw = new FileWriter("sample.txt");
            fw.write("Another row :: Write once, run anywhere");
            fw.close(); // FileWriter를 닫아주지 않으면 저장이 안되어 읽어 올수 없다.

            br = new BufferedReader(new FileReader("sample.txt"));
            while (true) {
                String line = br.readLine();
                if ("".equals(line) || line.isEmpty()){
                    break;
                }
                System.out.println(line);  // null 이 출력된다.
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 05. 파일의 내용 중 "python" 이라는 문자열을 "java"로 바꾸어서 저장
        try {
            FileWriter fw05 = new FileWriter("sample05.txt");
            fw05.write("Life is too short \n");
            fw05.write("you need python");
            fw05.close(); // FileWriter를 닫아주지 않으면 저장이 안되어 읽어 올수 없다.

            br = new BufferedReader(new FileReader("sample05.txt"));
            ArrayList<String> contents = new ArrayList<>();
            while (true) {
                String line = br.readLine();


                if ("".equals(line) || line.isEmpty()){
                    break;
                }
                contents.add(line+"\n");
            }
            br.close();
            System.out.println( "contents :: "+contents );
            fw05 = new FileWriter("sample05.txt");
            for(String content : contents) {
                fw05.write(content.replaceAll("python","java"));
            }
            fw05.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
