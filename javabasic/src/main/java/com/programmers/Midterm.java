package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 > 완전탐색 > 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */

public class Midterm {
    public static void main(String[] args){
        int[] answers = {1,2,3,4,5};
        int[] result = solution(answers);
        System.out.println(Arrays.toString(result));
    }
    static int[] student1 = {1, 2, 3, 4, 5};
    static int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    // student pattern
    // 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    // 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    // 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,

    public static int[] solution(int[] answers) {
        int s1Score = 0;
        int s2Score = 0;
        int s3Score = 0;

        int max=0;
        for(int i=0; i< answers.length;i++){
            if(answers[i] == student1[i%student1.length]){
               s1Score++;
            }
            if(answers[i] == student2[i%student2.length]){
                s2Score++;
            }
            if(answers[i] == student3[i%student3.length]){
                s3Score++;
            }
        }
        int[] scores = {s1Score, s2Score, s3Score};
        max = Math.max(max, s1Score);
        max = Math.max(max, s2Score);
        max = Math.max(max, s3Score);

        List<Integer> largest = new ArrayList<>();
        for(int j=0; j < scores.length;j++){
            if(max == scores[j]){
                largest.add(j+1);
            }
        }

        return largest.stream().mapToInt(Integer::intValue).toArray();
    }
}
