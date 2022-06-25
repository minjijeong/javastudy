package com.programmers.greedy;

import java.util.Arrays;

public class LifeBoot {
    public static void main(String[] args){
        int[] ppl = {10, 10, 10, 30, 50, 50, 50, 60, 70, 80, 90, 100};
        int limit = 100;
        int result = solution(ppl, limit);
        System.out.println(result);
        result = solution2(ppl, limit);
        System.out.println(result);
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int front = 0;
        int back = people.length -1;
        // 구명보트 승선 인원 최대 2명, 무게 제한 limit
        while(front <= back){
            if(people[front] + people[back] <= limit){
                front++;
            }
            answer++;
            back--;
        }
        return answer;
    }

    public static int solution2(int[] people, int limit){
        int answer= 0 ;
        Arrays.sort(people);
        int min = 0;
        for(int max = people.length -1; min <= max ; max--){
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }
        return answer;
    }
}
