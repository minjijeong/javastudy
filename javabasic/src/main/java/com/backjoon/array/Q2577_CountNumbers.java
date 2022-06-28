package com.backjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/submit/2577/45167131
 */
public class Q2577_CountNumbers {
//public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int tot = A*B*C;
        int[] numbers = new int[10];
        for(char c : String.valueOf(tot).toCharArray()){
            int number = c - '0';
            numbers[number]++;
        }
        for(int i : numbers){
            System.out.println(i);
        }
        br.close();
    }
}
