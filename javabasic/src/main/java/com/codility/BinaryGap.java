package com.codility;

public class BinaryGap {
    public static void main(String[] args){
        // 9 - 1001 -2
        // 529 1000010001 -4
        // 20 - 10100 - 1
        // 15 - 1111 - 0
        int n = 15;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int N) {
        int answer = 0;
        String number = Integer.toBinaryString(N);
        boolean isBinaryGap = false;
        int size = 0;
        for(int i=0; i< number.length();i++){
            if(number.charAt(i) == '1'){
                isBinaryGap = true;
                answer = Math.max(answer,size);
                size = 0;
            }else{
                if(isBinaryGap){
                    size++;
                }
            }
        }
        return answer;
    }
}
