package com.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetPractice {
    /**
     * Set : 선형 데이터구조 + 탐색 알고리즘
     * 이미존재하는 데이타인가?(탐색한다) Y -> 추가하지 않는다. N -> 새로 추가
     * 중복제거를 목표로함
     * 순서 보장하지 않음
     * Not Syncronized
     * Set - HashSet (Hash를 사용하므로 객체를 비교하기 위해서는 hashCode Override 받아 처리해야한다)
     * 합집합
     * A.addAll(B) = A U B
     * 교집합
     * A.retainAll(B) = A와 B의 교집합 (*retain 유지하다)
     * 차집합
     * A.removeAll(B) = A - B
     */
    public static void main(String[] args) {
//        setConception();
//        validateLotto();
//        playWordGame();
        hateSameNumber();
    }

    private static void hateSameNumber() {
        int[] arr = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};
        System.out.println(Arrays.toString(solution03(arr)));
        System.out.println(Arrays.toString(solution03(arr2)));
    }

    private static int[]  solution03(int[] arr) {
        List<Integer> uniqueNums = new LinkedList<>();
        int tmp = -1;
        for(int num : arr){
            if(tmp != num) {
                uniqueNums.add(num);
            }
            tmp = num;
        }
        return uniqueNums.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void playWordGame() {
        String[] words  = {"tank", "kick", "know", "wheel", "land", "dream"};
        String[] words2  = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(solution02(words));
        System.out.println(solution02(words2));
    }

    private static boolean solution02(String[] words) {
        boolean answer = true;
        Set<String> wordSet = new HashSet<>();
        String before = "";

        for(String word : words){
            if(!"".equals(before)){
                char chkFirstChar = before.charAt(before.length()-1);
                if(chkFirstChar != word.charAt(0)){
                    return false;
                }
            }
            if(!wordSet.add(word)){
                return false;
            }
            before = word;
        }
        return answer;
    }

    private static void validateLotto() {
        int[] lotto  = {4, 7, 32, 43, 22, 19};
        int[] lotto2  = {3, 19, 34, 39, 39, 20};
        System.out.println(solution01(lotto));
        System.out.println(solution01(lotto2));
    }

    private static boolean solution01(int[] lotto) {
        boolean answer = true;
        Set<Integer> numSet = new HashSet<>();
        for(int num : lotto){
            // 1 ~ 45 가능
            if(num < 1 || num > 45){
                return false;
            }
            // 중복된 값 존재시 false 리턴
            if(!numSet.add(num)){
                return false;
            }
        }
        return answer;
    }

    private static void setConception() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        if(!list.contains(1)) list.add(1);
        if(!list.contains(2)) list.add(2);
        if(!list.contains(3)) list.add(3);
    }
}
