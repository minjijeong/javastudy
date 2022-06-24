package com.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 > 완전탐색 > 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */

public class PrimeNumber {
    public static void main(String[] args){
        String num = "17";
        int result = solution(num);
        System.out.println(result);
    }
    static List<Integer> cases = new ArrayList<>();
    static boolean[] check = new boolean[10];

    public static int solution(String numbers) {
        int answer = 0;
        for(int i=0;i<numbers.length();i++){
            dfs(numbers, "", i+1);
        }
        for(int c : cases){
            if(isPrime(c)){
                answer++;
            }
        }
//        System.out.println(cases);
        return answer;
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i<n ; i++){
            if( n % i == 0) return false;
        }
        return true;
    }

    public static void dfs(String str, String temp, int size){
        if(temp.length() == size){
            int num = Integer.parseInt(temp);
            if(!cases.contains(num)){
                cases.add(num);
            }
        }

        for(int i=0; i <str.length();i++){
            if(!check[i]){
                check[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, size);
                check[i] = false;
                temp = temp.substring(0, temp.length() -1);
            }
        }
    }
}
