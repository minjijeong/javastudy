package com.programmers.greedy;

public class MakeLargeNumber {
    public static void main(String[] args){
        String number = "4177252841";
        int k = 4;
        String result = solution2(number, k);
        System.out.println(result);
        result = solution(number , k );
        System.out.println(result);
    }
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k;
        int start = 0;

        while(start < number.length() && answer.length() != length){
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for(int j = start ; j < leftNum ; j++){
                if( max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    start = j+1;
                }
            }
            answer.append(Integer.toString(max));
        }
        return answer.toString();
    }

    public static String solution2(String number, int k){
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;
        int start = 0;
        while(answer.length() != len && start < number.length()){
            int max = 0;
            int leftNum = k + answer.length() + 1;
            for(int j=start; j < leftNum;j++){
                // 문자 - '0' Integer.parse를 하지 않고도 max 비교
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    start = j+1; // 최고값 다음항 부터 다시 검색
                }
            }
            answer.append(String.valueOf(max));
        }
        return answer.toString();
    }
}
