package com.programmers;

import java.util.Arrays;

/**
 * 프로그래머스 > 완전탐색 > 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Carpet {
    public static void main(String[] args){
        int brown = 10;
        int yellow = 2;
        int[] result = solution(brown, yellow);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totol = brown + yellow;
        for(int i=3;i < totol;i++){
            int j = totol/i;
            if(i * j == totol) {
                int col = i;
                int row = j;
                if(col < row) {
                    col = j;
                    row = i;
                }
                if((i-2) * (j-2) == yellow){
                    answer[0] = col;
                    answer[1] = row;
                }
            }
        }
        return answer;
    }
    public static int[] solution_2(int brown, int yellow) {
        int[] answer = new int[2];
        int sum= brown + yellow;

        for(int i=3; i < sum; i++){
            int j = sum /i;
            if(sum % i == 0 && j >= 3){
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col -2) * (row -2);

                if(center == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
