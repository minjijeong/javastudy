package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TvingTest {
    public static void main(String[] args){
//        sol01();
//        sol02();
        sol03();
//        sol04();
    }
    public static void sol01(){
        int[][] p = {{1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}};
        int k = 2;
        int result = solution01(p,k);
        System.out.println(result);
    }

    public static int solution01(int[][] office, int k) {
        int max = 0;
        int x = 0;
        int y = 0;
        while(x <= office[0].length-k && y <= office.length-k){
            int cnt = 0;
            for(int i=y;i<y+k;i++){
                for(int j=x;j<x+k;j++){
                    if(office[i][j] == 1){
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
            x++;
            System.out.println(office[0].length);
            System.out.println(x);
            if(x == office[0].length-k+1){
                x = 0;
                y++;
            }
        }
        return max;
    }
    private static void sol02() {
        long n = 1000000000;
        long result = solution02(n);
        System.out.println(result);
    }

//    static List<Long> list = new ArrayList<>();
//    static long now = 0;
    public static long solution02(long n) {
        long[] arr = new long[(int)n+1];
        int idx = 0;
        int powNum = 1;
        while(idx < n){
            if(idx==0) arr[idx++] = 1;
            else{
                if(idx > n-1){
                    break;
                }
                long current = (long) Math.pow(3,powNum++);
                arr[idx++] = current;
                int curIdx = idx;
                for(int i=0;i<curIdx-1;i++){
                    if(idx > n){
                        break;
                    }
                    arr[idx++] = arr[i] + current;
                }
            }
        }
        return arr[(int)n-1];
    }
    private static void sol03() {
        int n = 6;
        int result = solution03(n);
        System.out.println(result);
    }
    public static int solution03(int N) {
        int answer = 1;
        int maxNext = N/2;
        int start = 1;
        while(start <= maxNext) {
            int single = N - start*2;
            int cases = 1;

            if(maxNext + single < 2){
                answer++;
                break;
            }
            cases = single + 1;

            answer += cases;
            start ++;
        }

        return answer;
    }
    /**
     *         int answer = 1;
     *         int maxNext = N/2;
     *         while(maxNext > 0) {
     *             int single = N - maxNext*2;
     *             int cases = 1;
     *             if(maxNext + single < 2){
     *                 answer++;
     *                 break;
     *             }
     *             for (int i = 2; i <= maxNext+single; i++) {
     *                 cases *= i;
     *             }
     *             for(int i=single; i> 1; i--){
     *                 cases /= i;
     *             }
     *             for(int i=maxNext; i>1;i--){
     *                 cases /= i;
     *             }
     *             answer += cases;
     *             maxNext--;
     *         }
     *
     *         return answer;
     */

//    private static void sol04() {
//        String[] map = {"..FF", "###F", "###."};
//        int k = 4;
//        int result = solution04(map, k);
//        System.out.println(result);
//    }
}
