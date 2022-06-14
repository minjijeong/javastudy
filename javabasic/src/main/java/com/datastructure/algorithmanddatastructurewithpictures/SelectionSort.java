package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.Arrays;

/**
 * 선택 정렬 알고리즘
 */
public class SelectionSort {
    public static void main(String[] args){
        int[] array = {12,326,127,467,110,58};
        int size = 6;
        array = SelectionSort(array, size);
        System.out.println(Arrays.toString(array));
    }
    public static int[] SelectionSort(int[] arr, int MAX){
        int i,j;
        int min, temp;
        System.out.println(Arrays.toString(arr));
        for(i=0; i< MAX;i++){
            min = i;
            for(j=i+1;j<MAX;j++){
                if(arr[j] < arr[min]) min = j;
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
