package com.datastructure;

import java.util.Vector;

public class VectorPractice {
    public static void main(String[] args){
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(4);
        vector.add(3);
        vector.add(-1);
        vector.add(2,100);

        System.out.printf("벡터 안의 요소 객체 수 : %d \n", vector.size());
        System.out.printf("벡터의 현재 용량 : %d \n", vector.capacity());

        for(Integer a : vector){
            System.out.println(a);
        }
        /**
         * 벡터 안의 요소 객체 수 : 5
         * 벡터의 현재 용량 : 10
         * 5
         * 4
         * 100
         * 3
         * -1
         */
    }
}
