package com.programmers;

/**
 * 참고 소스 : https://velog.io/@bokiri409/%EC%BB%A4%EB%AE%A4%EB%9F%AC%EB%8B%9D1%EA%B8%B0-2%EC%A3%BC%EC%B0%A8B-DFS
 */

import java.util.Stack;

/**
 * 깊이 우선 탐색
 * 1. 열리는 괄호를 배치한다.
 * 2. 그 이후에 닫히는 괄호를 배치한다.
 * 3. 괄호는 N개 이상 사용할 수 없다.
 * 4. 열리기 전에는 닫히는 괄호를 사용할 수 없다.
 */

public class RightBracketCount_2 {
    static class P{
        int open, close;
        P(int open, int close){
            this.open = open;
            this.close = close;
        }
    }
    public static int solution(int n) {
       int answer = 0;
       Stack<P> stack = new Stack<>();
       stack.push(new P(0,0));
       while(!stack.isEmpty()){
           P p = stack.pop();

           if(p.close > n) continue;
           if(p.open < p.close) continue;
           if(p.open + p.close == 2*n) continue;

           stack.push(new P(p.open+1, p.close));
           stack.push(new P(p.open, p.close+1));
       }
       return answer;
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
