package com.programmers.level1;

public class CheckNumber {
    public static void main(String[] args) {
        String str = "a234";
        boolean result = solution(str);
        System.out.println(result);
    }

    public static boolean solution(String s) {
        boolean answer = true;
        char[] chars = s.toCharArray();
        if(chars.length != 4 && chars.length != 6){
            return false;
        }
        for(char c : chars){
            if(c < 48 || c > 57){
                return false;
            }
        }
        return answer;
    }
}
