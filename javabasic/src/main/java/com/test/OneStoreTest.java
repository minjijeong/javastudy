package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 41%
 * 1번 0프로
 * 2번 22프로
 * 3번 100프로
 * https://app.codility.com/c/feedback/F77BND-AGH/
 */
public class OneStoreTest {
    public static void main(String[] args){
//        int[] A = {4, 6, 2, 2, 6, 6, 1};
//        System.out.println(solution2(A));
        int[] C = {7, 13, 8, 2, 3};
        System.out.println(solution03(C));
    }

    /**
     * Incorrect code - fix bug
     */
    public static int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = -1;
        for (int i = 0; i < N; i++) {
            // 기존소스, no greater than M 조건 빠져서 추가
//            if (count[A[i]] > 0 {
            if (count[A[i]] > 0 && count[A[i]] <= M) {
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp + 1;
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }

    /**
     * optimize algorithm
     */
    public static class Pair{
        int idx;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return idx == pair.idx && val == pair.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, val);
        }

        int val;
        public Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static int solution2(int[] A) {
        int N = A.length;
        int result = 0;
        List<Pair> pairs = new ArrayList<>();
        for(int i=0; i < N; i++){
            pairs.add(new Pair(i,A[i]));
        }

        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.val == o2.val) return o2.idx - o1.idx;
                return o2.val - o1.val;
            }
        });

        Pair before = pairs.get(0);
        for(int i=1; i < N; i++){
            Pair current = pairs.get(i);
            if(before.val == current.val){
                result = Math.max(result, Math.abs(before.idx - current.idx));
            }
        }
        return result;
        /**
         * orginal source
         */
        // int N = A.length;
        // int result = 0;
        // for (int i = 0; i < N; i++)
        //     for (int j = 0; j < N ; j++){
        //         if (A[i] == A[j])
        //             result = Math.max(result, Math.abs(i - j));
        //     }
        // return result;

    }

    /**
     * returns the size of the largest possible subset of A such that AND of all its elements is greater than 0.
     * e.g.
     * A = {13,7,2,8,3} your function should return 3.
     * A = {1,2,4,8} then return 1. The AND of each pair from the array is equal to 0.
     * A = {16, 16} than return 2.
     */
    public static int solution03(int[] A) {
        int N = A.length;

        int bit[] = new int[32];

        for (int i = 0; i < N; i++) {
            int x = 0;
            while (A[i] > 0) {
                if ((int)(A[i] & 1) == (int)1) {
                    bit[x]++;
                }
                A[i] = A[i] >> 1;
                x++;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 32; i++) {
            max = Math.max(max, bit[i]);
        }
        return max;
    }
}
