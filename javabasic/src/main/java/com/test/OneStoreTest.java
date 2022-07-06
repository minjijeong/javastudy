package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import util.TestTimeUtils;

/**
 * 41%
 * 1번 0프로
 * 2번 22프로
 * 3번 100프로
 * https://app.codility.com/c/feedback/F77BND-AGH/
 */
public class OneStoreTest {
    public static void main(String[] args){
//        /**
//         * 문제 1번 - Bug Fix
//         */
//        int[] arr = {1, 2, 3, 3, 1, 3, 1};
//        System.out.println(solution(3, arr));
//        System.out.println("================");
//
//        /**
//         * 문제 2번 - Optimize
//         */
//        TestTimeUtils time = new TestTimeUtils();
//        int[] A = {4, 6, 2, 2, 6, 6, 1};
//        System.out.println(solution2_origin(A));
//        time.printSpendTime();
//        System.out.println("================");
//
//        time = new TestTimeUtils();
//        System.out.println(solution2(A));
//        time.printSpendTime();
//        System.out.println("================");

        int[] C = {7, 13, 8, 2, 3};
//        int[] C = {1,3,6};
        TestTimeUtils time = new TestTimeUtils();
        System.out.println(solution03(C));
        time.printSpendTime();
        System.out.println("================");

        time = new TestTimeUtils();
        C = new int[]{7, 13, 8, 2, 3};
        System.out.println(solution03_origin(C));
        time.printSpendTime();
        System.out.println("================");
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
            if (count[A[i]] > 0 ){
                // 문제를 잘못 이해한듯.. 수의 개수는 M을 초과할수 있을듯..
//            if (count[A[i]] > 0 && count[A[i]] <= M) {
                count[A[i]]++; // 신규 추가.. 웬지 카운트를 먼저 세고 비교 했어야 하지 않았나 추측
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                // count[A[i]] = tmp + 1;
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
    public static int solution2_origin(int[] A) {
        /**
         * orginal source
         */
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N ; j++){
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
            }
        return result;
    }
    public static int solution2(int[] A) {
//        int N = A.length;
//        int result = 0;
//        List<Pair> pairs = new ArrayList<>();
//        for(int i=0; i < N; i++){
//            pairs.add(new Pair(i,A[i]));
//        }
//
//        pairs.sort(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                if(o1.val == o2.val) return o2.idx - o1.idx;
//                return o2.val - o1.val;
//            }
//        });
//
//        Pair before = pairs.get(0);
//        for(int i=1; i < N; i++){
//            Pair current = pairs.get(i);
//            if(before.val == current.val){
//                result = Math.max(result, Math.abs(before.idx - current.idx));
//            }
//        }
//        return result;
        /**
         * orginal source
         */
         Arrays.sort(A);

         int N = A.length;
         int result = 0;
         for (int i = 0; i < N; i++)
             // max 값이 어차피.. 같은 값을 가진 두 수의 index가 크게 차이날수록 크니깐..
             // 뒤에서부터 비교하고 제일먼저 나온애가 제일 많이 차이나는 친구지..break;
             for (int j = N-1; j >= 0 ; j--){
                 if (A[i] == A[j]) {
                     result = Math.max(result, Math.abs(i - j));
                     break;
                 }
             }
         return result;
    }

    /**
     * https://www.geeksforgeeks.org/find-the-size-of-largest-subset-with-positive-bitwise-and/
     * returns the size of the largest possible subset of A such that AND of all its elements is greater than 0.
     * e.g.
     * A = {13,7,2,8,3} your function should return 3.
     * A = {1,2,4,8} then return 1. The AND of each pair from the array is equal to 0.
     * A = {16, 16} than return 2.
     */
    public static int solution03_origin(int[] A) {
        int N = A.length;

        int bit[] = new int[32];

        for (int i = 0; i < N; i++) {
            int x = 0;
            while (A[i] > 0) {
//                System.out.println("----------");
//                System.out.println("A["+i+"]: " + A[i] +" => x : "+x);
//                System.out.println("A["+i+"] & 1 => " + (A[i] & 1));
                if ((int)(A[i] & 1) == (int)1) {
                    bit[x]++;
                }
                A[i] = A[i] >> 1;
//                System.out.println(Arrays.toString(bit));
//                System.out.println(A[i]);
                x++;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 32; i++) {
            max = Math.max(max, bit[i]);
        }
        System.out.println(Arrays.toString(bit));
        return max;
    }
    public static int solution03(int[] A) {
        int N = A.length;
        // Stores the number of set bits
        // at each bit position
        int bit[] = new int[32];

        // Traverse(순회) the given array arr[]
        for (int i = 0; i < N; i++) {

            // Current bit position
            int x = 31;

            // Loop till array element
            // becomes zero
            while (A[i] > 0) {

                // If the last bit is set
                if ((int)(A[i] & 1) == (int)1) {

                    // Increment frequency
                    bit[x]++;
                }

                // Divide array element by 2
                A[i] = A[i] >> 1;

                // Decrease the bit position
                x--;
            }
        }
        // Size of the largest possible subset
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 32; i++) {
            max = Math.max(max, bit[i]);
        }
        System.out.println(Arrays.toString(bit));
        return max;
    }
}
