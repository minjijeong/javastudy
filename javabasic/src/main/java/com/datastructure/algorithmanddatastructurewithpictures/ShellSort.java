package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.Arrays;

public class ShellSort {
    public static void main (String[] args){
        int[] arr = {23,12,45,3,18,32,49,1};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
//        shellsort(arr);
//        int[] result = shellsort(arr);
//        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(arr));

    }
//    // 결과가 이상하게 나옴.. 책이 잘못된듯 수정해야함
//    public static void intervalSort(int arr[], int begin, int end, int interval){
//        int item = 0;
//        int j =0 ;
//
//        for(int i = begin + interval; i <= end; i= i+interval){
//            item = arr[i];
//            System.out.printf("\n begin => %d, interval => %d",begin, interval);
//            for(j=i-interval; j >= begin && item < arr[j]; j -= interval){
//                arr[j+interval] = item;
//                System.out.printf(" i => %d, j => %d ",i, j);
//            }
//        }
//    }
//    public static void shellsort(int[] arr){
//        int interval = 0;
//        int t=1;
//        int arrSize = arr.length;
//
//        interval = arrSize/2;
//
//        while (interval >=1 ){
//            for(int i=0; i< interval; i++){
//                intervalSort(arr, i, arrSize-1, interval);
//            }
//            System.out.println("셀 정렬 "+t+" 단계 : interval => " + interval);
//            System.out.println(Arrays.toString(arr));
//            interval /= 2;
//        }
//    //    return arr;
//    }

    public static void shellSort(int[] arr) {

        // h 인덱스를 기준으로 비교 시작
        // h는 현재를 반으로 나눈 기준으로 잡았다.
        // 삽입 정렬 코드와 거의 같다. 차이점은 선택한 요소와 비교하는 요소가
        // 이웃하지 않고 h 만큼 떨어져 있다.
        for (int h = arr.length / 2; h > 0; h /= 2 ) {
            for (int i = h; i < arr.length; i++) {
                int idx = i - h;
                int tmp = arr[i];

                while( (idx >= 0) && (arr[idx] > tmp) ) {
                    arr[idx + h] = arr[idx];
                    idx -= h;
                }

                arr[idx + h] = tmp;
            }
        }
    }
}
