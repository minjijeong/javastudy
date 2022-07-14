package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.TestTimeUtils;

public class YanoljaTest {
    public static void main(String[] args){
//        test01();
//        test02();
//        test03();
        test04();
    }

    public static void test01() {
//        int[] integ = {10, 0, 8, 2, -1, 12, 11, 3};
//        int[] integ = {-1, -3, 2, 4, 10};
//        int[] integ = {5,5};
//        int[] integ = {-10, -9, -3, 0, 2, 5};
        int[] integ = {-10, 10, 0, 8, 2, -1, 12, 11, 3};
        System.out.println(solution1(integ));
    }

    public static int solution1(int[] A) {
        // 시간복잡도 O(nlogn) ~ O(n^2) (pivot으로 선택한 데이타를 기준으로 한곳에 쏠려있을때 최악!! )
        // Dual-Pivot Quicksort : 삽입 정렬(Insertion Sort)와 Quick Sort를 합친 것
        // 참고 : https://www.secmem.org/blog/2019/05/06/special-sorts-2/
        Arrays.sort(A);
        int length = 0;
        // 잡았다 요놈 - 사용자 오류..버그
        // for (int i = 1; i < A.length-1; i++) {
        for (int i = 1; i < A.length; i++) {
                int value = A[i] - A[i-1];
            length = Math.max(length, value);
        }
        return length / 2;
    }

    private static void test02() {
//        int[] block = {2,6,8,5}; //3
//        int[] block = {1,5,5,2,6}; //4
//        int[] block = {1,1}; //2
        int[] block = {100,100,100,90,90,90,90,90,90,90
                        ,90,90,90,90,90,90,90,90,90,90
                        ,90,90,90,90,90,90,90,90,90,90
                        ,90,90,90,90,90,90,90,90,90,90
                        ,90,80,80,80,80,80,80,80,80,80
                        ,80,80,80,80,80,80,80,80,80,80
                        ,80,100,100,100,100,100,100,100,100,100
                        ,100,100,100,100,100,70,70,70,70,70
                        ,70,70,70,70,70,70,70,70,70,70
                        ,70,70,70,70,70,70,70,70,70,70
                        ,70,70,70,70,70,70,70,70,100}; //75

        TestTimeUtils time = new TestTimeUtils();
        int result = solution2_orgin(block);
        time.printSpendTime();
        System.out.println(result);
        // 0.007
        System.out.println("================");

        time = new TestTimeUtils();
        result = solution2(block);
        time.printSpendTime();
        System.out.println(result);
        System.out.println("================");
        // 0.0
    }
    public static int solution2_orgin(int[] blocks) {
        // 시간복잡도 N^2
        int distance = 0;
        for(int i=0;i<blocks.length;i++){
            int nextX = i;
            int nextY = i;
            // search left
            while(nextX > 0){
                // can't move to left
                if(blocks[nextX] > blocks[nextX-1]){
                    break;
                }
                nextX--;
            }
            // search right
            while(nextY < blocks.length -1){
                // can't move to right
                if(blocks[nextY] > blocks[nextY+1]){
                    break;
                }
                nextY++;
            }
            distance = Math.max(distance, nextY-nextX+1);
        }
        return distance;
    }

    public static int solution2(int[] blocks) {
        int distance = 0;
        int idx = 0;
        for(int i=0 ;i<blocks.length;i++){
            int nextX = i;
            int nextY = i;
            // search left
            while(nextX > 0){
                // can't move to left
                if(blocks[nextX] > blocks[nextX-1]){
                    break;
                }
                nextX--;
            }
            // search right
            while(nextY < blocks.length -1){
                // can't move to right
                if(blocks[nextY] > blocks[nextY+1]){
                    i = nextY; // 골짜기 정상으로 이동 - 복잡도를 조금 줄일수 잇음
                    break;
                }
                nextY++;
            }
            distance = Math.max(distance, nextY-nextX+1);
        }
        return distance;
    }

    private static void test03() {
//        //1  - 3
//        int[] X = {1,2,3,4,0};
//        int[] Y = {2,3,6,8,4};

//        //2 - 1
//        int[] X = {3,3,4};
//        int[] Y = {5,4,3};

        //3 - 4
        int[] X = {4,4,7,1,2};
        int[] Y = {4,4,8,1,2};

//        //4 -3
//        int[] X = {1,2,3,1,2};
//        int[] Y = {2,4,6,5,10};
        TestTimeUtils time = new TestTimeUtils();
        System.out.println(solution3_orgin(X, Y));
        time.printSpendTime();
        System.out.println("================");
        /**
         * Start Time :: 1.656828489372E12
         * 4
         * Current Time :: 1.656828489424E12
         * Spend Time :: 0.053
         */

        time = new TestTimeUtils();
        System.out.println(solution3(X, Y));
        time.printSpendTime();
        System.out.println("================");
        /**
         * Start Time :: 1.656828489425E12
         * 4
         * Current Time :: 1.656828489426E12
         * Spend Time :: 0.001
         */

    }

    public static int solution3_orgin(int[] X, int[] Y){

        Map<String, Integer> fractionMap = new HashMap<>();

        int max = 0;
        for(int i = 0; i < X.length; i++)
        {
            int numerator = X[i] /gcd(X[i],Y[i]);
            int denominator = Y[i] /gcd(X[i],Y[i]);

            String key = String.format("%s/%s",numerator, denominator);
            fractionMap.put(key, fractionMap.getOrDefault(key,0)+1);

        }
        for(String key : fractionMap.keySet()){
            max = Math.max(max,fractionMap.get(key));
        }
        return max;
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int solution3(int[] X, int[] Y){

        Map<String, Integer> fractionMap = new HashMap<>();

        int max = 0;
        for(int i = 0; i < X.length; i++)
        {
            int numerator = X[i] /gcd(X[i],Y[i]);
            int denominator = Y[i] /gcd(X[i],Y[i]);

            String key = String.format("%s/%s",numerator, denominator);
            // String을 HashMap으로 조회하면 2,/,3 이런형태이기 때문에 조금 더 오래 걸릴수 있다.
            // 이부분을 개선하는 방향 생각해보자
            // get하는 부분때문에 시간복잡도 올라갈수 있다.
            // 해시는 10개 이상의 데이타인 경우 연결리스트를 타서 조회가 순차적으로만 접근 가능해서 느릴수 있다.
            // String 형태가 아니라 Pair 클래스 선언해서 처리하면 어떨지 확인 해보자
            fractionMap.put(key, fractionMap.getOrDefault(key,0)+1);
        }
        for(int val : fractionMap.values()){
            max = Math.max(max,val);
        }
        return max;
//        return Collections.max(fractionMap.values());
    }


    private static void test04() {
        //1 - 31
        int N = 5;
        int[] A = {2,2,1,2};
        int[] B = {1,3,4,4};
//         //2 - 5
//        int N = 3;
//        int[] A = {1};
//        int[] B = {3};
//        //3 - 10
//        int N = 4;
//        int[] A = {1, 3};
//        int[] B = {2, 4};
        System.out.println(solution4(N,A,B));
    }
    public static int solution4(int N, int[] A, int[] B) {
        // write your code in Java SE 8
        int cost = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // count each edge
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
            map.put(B[i], map.getOrDefault(B[i],0) + 1);
        }
        List<Integer> reverseWeight = new ArrayList<>();
        for (Integer integer : map.values()) {
            reverseWeight.add(integer);
        }
        /**
         * Merge Sort or Tim Sort(Insertion Sort + Merge Sort) 활용 👉 O(nlogn)
         * 참고 : https://da-nyee.github.io/posts/java-arrays-sort-vs-collections-sort/
         * if (LegacyMergeSort.userRequested)
         *    legacyMergeSort(a, c);
         * else
         *    TimSort.sort(a, 0, a.length, c, null, 0, 0);
         */
        reverseWeight.sort(Comparator.reverseOrder());

        // order large number of edges
        // edge(x,y) cost = vertex x.val + vertex y.val
        int val = N;
        for (Integer v : reverseWeight) {
            cost += v * val;
            val -= 1;
        }
        return cost;
    }

}
