package com.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 > 완전탐색 > 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */

public class PrimeNumber_review {
    public static void main(String[] args){
        String num = "17";
        int result = solution(num);
        System.out.println(result);
    }

    static boolean[] visited = new boolean[7];
    static List<Integer> cases = new ArrayList<>();
    private static int solution(String num) {
        int answer = 0;
        // 숫자 믹스
        for(int i=1; i <= num.length();i++){
            dfs(num, "", i);
        }


        // 소수인지 판별
        for(int c : cases){
           if(isPrime(c)){
               answer++;
           }
        }
        return answer;
    }

    private static void dfs(String num, String str, int size) {
        if(str.length() == size){
            int number = Integer.parseInt(str);
            if(!cases.contains(number)){
                cases.add(number);
            }
            return;
        }
        for(int i=0; i<num.length();i++){
            if(!visited[i]){
                visited[i] = true;
                str += num.charAt(i);
                dfs(num, str, size);
                visited[i] = false; // 완전탐색 끝까지 다녀오고 난다음 그 시점에서 다시 시작하기 위해
                str = str.substring(0, str.length() -1);
            }
        }
    }

    private static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i < n; i++){
            if(n % i == 0 ) return false;
        }
        return true;
    }
}
