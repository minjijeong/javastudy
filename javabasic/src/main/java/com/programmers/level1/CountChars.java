package com.programmers.level1;

public class CountChars {
    public static void main(String[] args){
        String str = "pPoooyY";
        boolean result = solution(str);
        System.out.println(result);
    }
    public static boolean solution(String s) {
        boolean answer = true;
        int pNum = 0;
        int yNum = 0;
        for(char c : s.toLowerCase().toCharArray()){
            if(c == 'y') yNum++;
            if(c == 'p') pNum++;
        }
        if(pNum != yNum) answer = false;
        return answer;
    }
}
