package com.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 깊이 우선 탐색
 * 실패...
 */
public class RightBracketCount {
    static int answer = 0;
    public static int solution(int n) {
        answer = 0;
        dfs(n,0,0,1);
        return answer;
    }

    public static void dfs(int n, int openCnt, int closeCnt, int idx) {
        if(openCnt > n && closeCnt > n) {
            return;
        }else if(openCnt == n && closeCnt == n){
            System.out.printf("[%d] openCnt : %d, closeCnt : %d \n", idx, openCnt, closeCnt);
            answer++;
            return;
        }

        //괄호열기
        if(openCnt < n) {
            dfs(n, openCnt + 1, closeCnt,idx++);
        }
        //괄호닫기
        if(openCnt - closeCnt > 0 && openCnt > 0 && closeCnt < n) {
            dfs(n, openCnt, closeCnt + 1,idx++);
        }
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(solution(n));
        int n2 = 4;
        System.out.println(solution(n2));
    }
}
