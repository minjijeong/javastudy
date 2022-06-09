package com.programmers;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClotheCombination {
    public static void main(String[] args){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(clothes);
        result = solutionLamda(clothes);
        System.out.println(result);
    }
    public static int solution(String[][] clothes) {
        Map<String, List<String>> clotheList = new HashMap<>();

        for(int i=0;i<clothes.length; i++){
            List<String> parts = new ArrayList<>();
            if(clotheList.get(clothes[i][1]) != null){
                parts.addAll(clotheList.get(clothes[i][1]));
            }
            parts.add(clothes[i][0]);
            clotheList.put(clothes[i][1], parts);
        }

        /**
         * 선택하지 않는 케이스까지 추가하여 경우의 수 구하기
         */
        int mixCase = 1;
        if(clotheList.size() > 1) {
            for (String key : clotheList.keySet()) {
                mixCase = mixCase * (clotheList.get(key).size() + 1);
            }
            mixCase += mixCase;
        }

        return mixCase - 1;
    }

    public static int solutionLamda(String[][] clothes){
        return Arrays.stream(clothes)
                .collect(groupingBy( p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x,y) -> x * (y +1))).intValue() -1;
    }
}
