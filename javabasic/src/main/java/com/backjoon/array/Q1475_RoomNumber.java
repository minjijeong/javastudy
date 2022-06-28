package com.backjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1475_RoomNumber {
//public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        // 6, 9는 뒤집어서 쓸수 있다.
        // N은 1,000,000보다 작거나 같은 자연수
        // 최소 필요한 세트 = 방번호 구성 숫자중 동일한 숫자 max 구하기 (6,9는 중복으로 처리)
        int[] numbers = new int[10];
        for(char c : N.toCharArray()){
            int number = c - '0';
            numbers[number]++;
        }
        // 나눗셈 int/int 하면 int로 계산... double로 강제 cast 해주어야함
        double max = Math.ceil((numbers[6]+numbers[9])/(double)2);
        for(int i=0; i<numbers.length;i++){
            if(i != 6 && i != 9) {
                max = Math.max(max, numbers[i]);
            }
        }
        System.out.println((int)max);
        br.close();
    }
}
