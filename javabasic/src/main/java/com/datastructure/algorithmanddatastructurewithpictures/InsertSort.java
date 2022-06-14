package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.Arrays;

/**
 * 삽입 정렬 알고리즘
 */
public class InsertSort {
    public static void main(String[] args){
        int[] a = {12,326,127,467,110,58};
        for(int j=1; j < a.length;j++){
            int key = a[j];
            int i = j-1;
            while(i >= 0 && a[i] > key){
                a[i+1] = a[i];
                i = i-1;
            }
            a[i+1] = key;
        }

        System.out.println(Arrays.toString(a));
    }
}
