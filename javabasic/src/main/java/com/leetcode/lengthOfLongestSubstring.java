package com.leetcode;

import java.util.*;

public class lengthOfLongestSubstring {
    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<String> list = new HashSet<>();
        int answer = 0;
        for(int i=0;i<s.length();i++){
            int size= 1;
            int next = i+size;
            StringBuffer now = new StringBuffer(s.substring(i, next));

            while(next+size <= s.length()){
                String nextOne = s.substring(next, next+size);
                if(!now.toString().equals(nextOne)){
                    now.append(s.substring(next,next+1));
                    size++;
                    next = i+size;
                }
                else{
                    break;
                }
            }
            answer = Math.max(answer, now.length());
        }
        return answer;
    }
}
