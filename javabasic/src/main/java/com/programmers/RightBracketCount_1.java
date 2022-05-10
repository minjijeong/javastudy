package com.programmers;

/**
 * 참고 소스 : https://velog.io/@bokiri409/%EC%BB%A4%EB%AE%A4%EB%9F%AC%EB%8B%9D1%EA%B8%B0-2%EC%A3%BC%EC%B0%A8B-DFS
 */

/**
 * 깊이 우선 탐색
 * 1. 열리는 괄호를 배치한다.
 * 2. 그 이후에 닫히는 괄호를 배치한다.
 * 3. 괄호는 N개 이상 사용할 수 없다.
 * 4. 열리기 전에는 닫히는 괄호를 사용할 수 없다.
 */

public class RightBracketCount_1 {
    public static int solution(int n) {
        int[] catalan = new int[n+1];

        catalan[0] = 1;
        for(int i=1; i <= n; i++){
            for(int j=0; j<i; j++){
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
    }

    public static void main(String[] args) {
        // 1,3,5,7
        // 2,2,6,8
        int n = 1;
        System.out.println(solution(n));
        int n2 = 4;
        System.out.println(solution(n2));
    }
}
