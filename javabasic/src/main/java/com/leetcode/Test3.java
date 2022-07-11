package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * pre[r] - pre[l-1] = a[l] + ... + a[r]
 *
 * pre = [0 ] * (n+1)
 * for i in range(1, n+1);
 *  pre[i] = pre[i-1] + a[i-1]
 */
public class Test3 {
    public static void main(String[] args){
        int[] nums = {4,5,0,-2,-3,1};
        int k=5;
        System.out.println(subarraysDivByK(nums, k));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        int n = nums.length;
        int[] pre = new int[n];

        for(int i=1; i< n;i++) pre[i] = pre[i-1] + nums[i-1];
        System.out.println(Arrays.toString(pre));
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n;i++){
            int y = ((pre[i] % k) + k) %k;
            int val = map.get(y) == null ? 1 : map.get(y);
            answer ++;
            map.put(y,++val);
        }
        System.out.println(map);
        return answer;
    }
}
