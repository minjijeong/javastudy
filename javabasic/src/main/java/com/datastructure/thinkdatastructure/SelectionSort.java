package com.datastructure.thinkdatastructure;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] array = {12,326,127,467,110,58};
        int size = 6;
        //array = selectionSort(array,size);
        System.out.println(Arrays.toString(array));
        System.out.println(System.identityHashCode(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] selectionSort(int[] arr, int MAX) {
        int i,j;
        int min, temp;
        for(i=0;i<MAX-1;i++){
            min = i;
            for(j=i+1; j<MAX; j++){
                if(arr[j] < arr[min]) min = j;
            }
            // 자기 자리 그대로 있는거 바꿔주면 안될것 같은데 ...
            if(min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * i,j 위치 값 교환
     */
    public static void swapElements(int[] array, int i, int j){
        System.out.println("swapElements :: "+System.identityHashCode(array));
        System.out.println("swapElements:i :: "+System.identityHashCode(i));
        System.out.println("swapElements:j :: "+System.identityHashCode(j));
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * start로 부터 시작하는 최솟값의 위치를 찾고(start포함)
     * 배열의 마지막 위치로 갑니다.
     */
    public static int indexLowest(int[] array, int start){
        System.out.println("indexLowest :: "+System.identityHashCode(array));
        System.out.println("indexLowest:start :: "+System.identityHashCode(start));
        int lowIndex = start;
        for(int i=start; i < array.length;i++){
            if(array[i] < array[lowIndex]){
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    /**
     * 선택 정렬을 사용하여 요소를 정렬한다.
     */
    public static void selectionSort(int[] array){
        System.out.println("selectionSort :: "+System.identityHashCode(array));
        for(int i=0;i<array.length;i++){
            System.out.println("selectionSort:i :: "+System.identityHashCode(i));
            int j = indexLowest(array,i);
            System.out.println("selectionSort:j :: "+System.identityHashCode(j));
            swapElements(array,i,j);
        }
    }

}
