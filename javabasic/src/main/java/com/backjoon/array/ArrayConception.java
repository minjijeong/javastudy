package com.backjoon.array;

import java.util.Arrays;

/**
 * 배열 (Array)
 * - 자료구조의 크기를 선 지정 후 할당할 수 있는 형태 (고정적)
 * - 인덱스로 랜덤 엑세스 가능하여 접근은 빠르지만, 데이터 검색은 n 만큼 소요됨
 * - 데이타가 통으로 메모리에 할당되어 접근 시간은 짧다. (cache hit 율이 높다)
 * - 해당 데이타 사이즈가 큰 경우 메모리에 통으로 할당할 공간이 없는 경우 문제가 발생될 수 있다.
 * - 배열은 컴파일 타임에 정적 메모리 할당
 */
public class ArrayConception {
    public static void main(String[] args){
        // 배열 선언
        int[] arr; // 배열 형태 어떻게 될거다 정의. 값은 null 할당되지 않았으므로
        arr = new int[10];  // size 고정
        for(int i=0; i<arr.length;i++){
            arr[i] = i;
        }

        System.out.println(arr[3]); // 인덱스 랜덤 방식 접근 가능
        System.out.println("arr : "+System.identityHashCode(arr)); // arr : 1828972342
        int[] copy = new int[10];
        System.out.println("copy : "+System.identityHashCode(copy)); // copy : 1452126962
        copy = arr.clone(); // 클론하면 재할당되는군...
        System.out.println("arr : "+System.identityHashCode(arr)); // arr : 1828972342
        System.out.println(Arrays.toString(arr));
        System.out.println("copy : "+System.identityHashCode(copy)); // copy : 931919113
        System.out.println(Arrays.toString(copy));

//        try {
//            arr.finalize();
//            // GC 수행될때 사용하지 않는 자원 정리하는 메소드
//            // Effective Java "종료자는 사용하면 안 된다. 예측이 불가능하고 대체로 위험하고 일반적으로 필요하지 않다."
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }

    }
}
