package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        int[] num1 = {1,1,3,2};
        int[] num2 = {2,3};
        int[] num3 = {3};
        List<Integer> result = twoOutOfThree(num1, num2, num3);
        System.out.println(result);
    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> list = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(int i : nums1){
            list.add(i);
        }

        for(int i : nums2){
            if(list.contains(i)){
                if(!answer.contains(i)) answer.add(i);
            }
            list.add(i);
        }
        for(int i : nums3){
            if(list.contains(i)){
                if(!answer.contains(i)) answer.add(i);
            }
            list.add(i);
        }
        return answer;
    }

}
