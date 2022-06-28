package com.backjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3273_SumNumbers {
//public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] numberList = (br.readLine()).split(" ");
        int[] numbers = new int[N];
        for(int j=0; j< N ; j++) {
            numbers[j] = Integer.parseInt(numberList[j]);
        }
        int X = Integer.parseInt(br.readLine());
        Arrays.sort(numbers);
        // 수열(numbers) 2개의 수 조합의 합이 X인 개수 구하기
        // 2중 for문으로는 시간초과
        // 2 포인터 기준으로 변경
        int answer = 0;
        int start = 0;
        int end = N-1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(X ==sum){
                answer++;
            }
            if(sum <= X){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
