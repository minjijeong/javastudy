package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] src = new int[]{1,9,8,5,4,2,3,7,6};
        int[] tmp = new int[src.length];
        System.out.println(Arrays.toString(src));
        mergeSort(0, src.length -1, src, tmp);
        System.out.println(Arrays.toString(src));
    }
    public static void mergeSort(int start, int end, int[] src, int[] tmp){
        if(start < end){
            int mid = (start + end) / 2;
            // 반반씩 나누어서 다시 시작
            mergeSort(start, mid, src, tmp);
            mergeSort(mid + 1, end, src, tmp);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while(p<= mid || q <= end){
                if(q > end || (p <= mid && src[p] < src[q])){
                    tmp[idx++] = src[p++];
                }else{
                    tmp[idx++] = src[q++];
                }
            }
            for(int i=start; i <= end ; i++){
                src[i] = tmp[i];
            }
            System.out.printf("start : %d, mid : %d, end : %d \n", start, mid, end);
            System.out.println(Arrays.toString(src));
        }
    }
}
