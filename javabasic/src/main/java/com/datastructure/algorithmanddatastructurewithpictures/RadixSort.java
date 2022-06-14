package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.Arrays;

/**
 * 기수 정렬 알고리즘(Radix Sort)
 * 버킷정렬의 개선 버젼, 각 자릿수별로 버킷 정렬을 반복 수행하는 방법
 */
public class RadixSort {
    public static void main(String[] args){
        int[] array = {12,326,127,467,110, 58};
        array = rSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] rSort(int[] array) {
        for(int shift=Integer.SIZE -1; shift > -1; shift--){
            int[] tmp = new int[array.length];
            int j=0;
            System.out.println(shift + "-1=> " + Arrays.toString(array));
            for(int i=0; i < array.length;i++){
                boolean move = array[i] << shift >= 0;
                if(shift == 0 ? ! move : move){
                    tmp[j] = array[i];
                    j++;
                } else{
                    array[i - j] = array[i];
                }
            }
            System.out.println(shift + "-2=> " + Arrays.toString(array));

            for(int i=j; i < tmp.length;i++){
                tmp[i] = array[i-j];
            }
            array = tmp;
            System.out.println(shift + "-3=> " + Arrays.toString(array));
        }
        return array;
    }
}
