package com.programmers;

import java.util.Arrays;

/**
 * 한 사람당 티셔츠를 최대 하나씩 줍니다.
 * 모든 참가자는 자신의 상의 크기와 같거나 큰 티셔츠를 받습니다.
 */
public class TShirts {
    public static int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Arrays.sort(people);
        Arrays.sort(tshirts);
        int tIdx = 0;
        for(int person : people){
            while(tIdx < tshirts.length) {
                if (tshirts[tIdx] >= person) {
                    answer++;
                    tIdx++;
                    break;
                }
                tIdx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//       int[] people = {2,3};
//       int[] tshirts = {1,2,3};
        int[] people = {1,2,3};
        int[] tshirts = {1,1};
       System.out.println(solution(people, tshirts));
    }
}
