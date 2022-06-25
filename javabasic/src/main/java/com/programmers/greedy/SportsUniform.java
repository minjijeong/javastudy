package com.programmers.greedy;

import java.util.Arrays;

public class SportsUniform {
    public static void main(String[] args){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int result = solution(n, lost, reserve);
        System.out.println(result);
//        lost = new int[]{2, 4};
//        reserve = new int[]{1,3,5};
//        result = solution2(n, lost, reserve);
//        System.out.println(result);
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        int[] status = new int[n];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여벌 있는 체육복 도난 경우
        for(int j=0; j < lost.length;j++){
            for(int i=0; i < reserve.length;i++){
                if(reserve[i] == lost[j]){
                    answer++;
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        // 여벌없는 체육복 도난 경우
        for(int j=0; j < lost.length;j++){
            for(int i=0; i < reserve.length;i++){
                if(reserve[i] == lost[j] - 1 || reserve[i] == lost[j] + 1){
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }

//    public static int solution2(int n, int[] lost, int[] reserve){
//        int answer = 0;
//        int[] status = new int[n];
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
//        Arrays.fill(status,1);
//
//        // 여벌이 있는데 도난당한 경우
//        for(int i=0;i<lost.length;i++){
//            for(int j=0; j<reserve.length;j++){
//                if(lost[i] == reserve[i]){
//                    answer++;
//                    lost[i] = -1;
//                    reserve[i] = -1;
//                }
//            }
//        }
//        // 여벌 없는데 도난당한 경우
//        for(int i=0;i<lost.length;i++) {
//            for (int j = 0; j < reserve.length; j++) {
//                if(reserve[i] == lost[i]-1 || reserve[i] == lost[i] + 1){
//                    answer++;
//                    reserve[i]  = -1;
//                    break;
//                }
//            }
//        }
//
//
//        answer = (int) Arrays.stream(status).filter(value -> value > 0).count();
//        return answer;
//    }
}
