package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.logging.log4j.util.Strings;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 *
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * ## 제한사항
 * - numbers의 길이는 1 이상 100,000 이하입니다.
 * - numbers의 원소는 0 이상 1,000 이하입니다.
 * - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */
public class TheLargestNumber {

    public static String solution(int[] numbers) {
        String answer = "";
        String[] strs = new String[numbers.length];
        int i=0;
        for(int n : numbers){
            strs[i] = String.valueOf(n);
            i++;
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for(String s : strs){
            sb.append(s);
        }

        // 0으로 시작하면 답은 0
        if("0".equals(strs[0])){
            return "0";
        }

        return sb.toString();
    }


    //[6, 10, 2]	"6210"
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(solution(arr));
    }
}
