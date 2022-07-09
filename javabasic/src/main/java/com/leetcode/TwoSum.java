package com.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = {0,4,3,0};
        int target = 0;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int[][] visited = new int[nums.length][nums.length+1];
        // nums에서 2개를 골라서 sum = target
        // return

        for(int i=0; i<nums.length; i++){
            int next = target - nums[i];
            for(int j=nums.length-1;j>=0;j--){
                if(i>=j){
                    break;
                }
                System.out.printf(" next : %d, nums[%d] : %d \n", next, j, nums[j]);
                if(nums[j] == next){
                    System.out.printf("i : %d, j : %d , sum : %d \n", i, j, nums[i] + nums[j]);
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }

        }
        return answer;
    }
}
