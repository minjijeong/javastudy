package com.datastructure.datastructureandalgorithm;

public class Heap {
    int[] array;
    public int count;
    public int capacity;
    public int heap_type;

    public Heap(int capacity, int heap_type){
        this.capacity = capacity;
        this.heap_type = heap_type;
        this.count = 0;
        this.array = new int[capacity];
    }

    public int Parent(int i){
        if( i <= 0 || i >= this.count){
            return  -1;
        }
        return  i-1/2;
    }
    public int LeftChild(int i){
        int left = 2 * i +1;
        if(left >= this.count) return  -1;
        return left;
    }

    public int RightChild(int i){
        int right = 2 * i + 2;
        if (right >= this.count) return -1;
        return right;
    }
    public int GetMaximum(int i){
        if (this.count == 0) return  -1;
        return this.array[0];
    }
}
