package com.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCMLCM {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        int[] result = solution(n, m);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int n, int m) {
        List<Integer> answer = new ArrayList<>();
        int GCM = m > n ? m : n;
        int LCM = m > n ? m : n;
        // 최대공약수 - 나누어지는 것이 최대인것
        for(int i=1;i <=LCM/2;i++){
            if(n%i==0 && m%i==0){
                GCM = i;
            }
        }
        answer.add(GCM);
        // 최소공배수 - 최대공약수
        LCM = Math.floorDiv((m * n), GCM) ;
        answer.add(LCM);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
