package com.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sentences = new String[N];
        for(int j=0; j< N ; j++) {
            sentences[j] = br.readLine();
        }
        for(int j=0; j< N ; j++) {
            String s = sentences[j];
            String[] words = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                for (int i = word.length() - 1; i >= 0; i--) {
                    sb.append(word.substring(i, i + 1));
                }
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
