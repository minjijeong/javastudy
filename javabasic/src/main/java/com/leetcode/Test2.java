package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args){
        int[][] num1 = {{2,4},{6,8}};
        int x = 2;
        int result = minOperations(num1, x);
        System.out.println(result);
    }
    public static int minOperations(int[][] grid, int x) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int tot = 0;
        for(int[] i : grid){
            for(int j : i){
                list.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<list.size();i++){
            int sum = 0;
            for(int j=0; j<list.size();j++){
                if(i!=j){
                   int div = Math.abs(list.get(i) - list.get(j))/x;
                   sum += div;
                }
            }
            min = Math.min(min, sum);
        }
        return  answer;
    }
}
