package com.datastructure.algorithmanddatastructurewithpictures;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args){
        int[] arr = {3,7,5,4,2,8};
        System.out.println(Arrays.toString(arr));
        int[] simpleSortResult = simpleSort(arr);
        System.out.println(Arrays.toString(simpleSortResult));
    }
    public static int[] simpleSort(int[] array){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int val : array){
            heap.add(val);
        }
        for(int i=0; i < array.length;i++){
            array[i] = heap.poll();
        }
        return array;
    }

    // 부모 인덱스를 얻는 함수
    private static int getParent(int child){
        return (child -1)/2;
    }

    // 두 인덱스 원소를 교환하는 함수
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 힙을 만드는 함수
    private static void heapify(int[] a , int parentIdx, int lastIdx){

        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;
        int largestIdx = parentIdx;

        if(leftChildIdx < lastIdx && a[largestIdx] < a[leftChildIdx]){
            largestIdx  = leftChildIdx;
        }

        if(rightChildIdx < lastIdx && a[largestIdx] < a[rightChildIdx]){
            largestIdx = rightChildIdx;
        }

        if(parentIdx != largestIdx){
            swap(a, largestIdx, parentIdx);
            heapify(a, largestIdx, lastIdx);
        }
    }
}

