package com.programmers;

import java.util.Arrays;
import java.util.Comparator;
import org.springframework.util.comparator.Comparators;

public class HIndex {
    public static void main(String[] args){
        int[] c = {3, 0, 6, 1, 5};
    }
    public static int solution(int[] citations) {
        int answer = 0;
        // n편 중 h번 이상 인용된 논문이 h편, 그 나머지는 h 이하 인용
        Arrays.sort(citations);
        for(int i=0; i< citations.length; i++){
            // h 이상의 항의 개수 = 본인 포함하여 개수 세기
            // 0 -> 5, 1-> 4, 3->3
            int h = citations.length -i;
            if(citations[i] >= h) return h;
        }
        return answer;
    }
}
