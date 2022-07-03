package com.backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773_Zero {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        int[] spends = new int[N];
        Stack<Integer> spends = new Stack<>();
        for(int i=0; i<N;i++){
            int cur = Integer.parseInt(br.readLine());
            // 0을 부르면 삭제
            if(cur == 0) spends.pop();
            else spends.push(cur);
        }
        int sum = 0;
        while(!spends.isEmpty()){
            sum += spends.pop();
        }
        System.out.println(sum);
        br.close();
    }
}
