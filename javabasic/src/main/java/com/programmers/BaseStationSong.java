package com.programmers;

import java.util.Arrays;
import java.util.Collections;

public class BaseStationSong {

    static int cnt  = Integer.MAX_VALUE;
    public static String solution(int[] numbers) {
        String answer = "";
        float[] floats = new float[numbers.length];
        for(int i = 0; i<floats.length; i++){
            floats[i] = numbers[i];
        }

        for(int i = 0; i<floats.length; i++){
            while(floats[i] >= 10){
                floats[i] /= 10.0;
            }
        }

        for(int i = 0; i<floats.length; i++){
            System.out.println(floats[i]);
        }
        int[] idxArr = new int [numbers.length];
        for(int i = 0; i<numbers.length; i++){
            idxArr[i] = i;
        }

        int digit = 0; // 2, 3, 4, ...

        int debug = 0;
        while(debug < 1){
            //while(cnt > 0){

            floats = sort(idxArr, floats);
            System.out.println("cnt == " + cnt);
            idxArr = makeArr(floats, digit);

            digit++;
            debug++;
        }

        for(int i = 0; i<floats.length; i++){
            while(floats[i] != (int)floats[i]){
                floats[i] *= 10;
            }
        }

        for(int i = 0; i<floats.length; i++){
            answer += (int)floats[i];
        }

        return answer += 0;
    }

    public static float[] sort(int[] idx, float[] floats){
        Float [] result = new Float[idx.length];
        for(int i = 0; i<idx.length; i++){
            result[i] = floats[idx[i]];
        }
        Arrays.sort(result, Collections.reverseOrder());
        for(int i = 0; i<idx.length; i++){
            floats[idx[i]] = result[i];
        }

        System.out.println("call sort() !!!");
        for(float f : floats){
            System.out.print(f + ", ");
        }
        System.out.println();

        return floats;
    }

    public static int[] makeArr(float[] floats, int digit){
        //System.out.println("digit == " + digit);
        System.out.println("digit == " + digit);
        int target = (int)Math.pow(10, digit);
        //System.out.println("target == " + target);
        int[] idxArr = new int [floats.length];
        int idx = 0;

        for(int i = 0; i<floats.length; i++){
            //float tmp = floats[i] * 10;
            int tmp = (int)(floats[i]*target);

            //System.out.println("tmp & target == " + tmp + " & " + target);
            //if(tmp > target){
            if(floats[i]*target !=  tmp){
                System.out.println("floats[i]*target !=  tmp ==> " + floats[i]*target + " != " + tmp);
                idxArr[idx] = i;
                idx++;
            }
        }

        cnt = idx;

        return idxArr;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(solution(arr));
    }
}
