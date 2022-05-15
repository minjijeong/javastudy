package com.test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GreepTest {
    public static void main(String[] args) {
//        test01();
        test02();
//        test03();
    }


    private static void test01() {
        int n = 3;
        String text = "hi bye";
        int second = 6;
        System.out.println(solution01(n,text,second));
    }
    public static String solution01(int n, String text, int second) {
        String answer = "";
        StringBuffer buffer = new StringBuffer();
        StringBuffer emptySpace = new StringBuffer();;
        // text + (n-second) *
        for(int i=0;i<n;i++) emptySpace.append(" ");
        buffer.append(emptySpace.toString());
        char[] chars = text.toCharArray();
        for(int i=0;i< chars.length;i++){
//            if(chars[i] == ' '){
//                chars[i] = '_';
//            }
            buffer.append(chars[i]);
        }
        buffer.append(emptySpace.toString());
        int begin = second % (2 * n);
        int end = begin + n > buffer.length() ? buffer.length() : begin + n;
        System.out.println(buffer.toString());
        System.out.printf("begin : %d, end: %d \n",begin,end);
        return buffer.toString().replaceAll(" ","_").substring(begin, end);
    }

    private static void test02() {
        int[] bricks = {5, 1, 2, 3, 4, 3};
        int n = 5;
        int k = 3;
        System.out.println(solution02(bricks,n,k));
    }

    public static int solution02(int[] bricks, int n, int k) {
        int[][] waters = new int[n][bricks.length];
        Queue<Integer> stacked = new LinkedList<>();
        for(int w=0; w < bricks.length; w++){
            int brick = bricks[w];
            for(int d=0; d < n; d++){
                if(brick > 0) {
                    waters[d][w] = 1;
                    brick--;
                }
            }
        }
        for(int d=0; d < n; d++){
            System.out.println(Arrays.toString(waters[d]));
        }

        int needBricks = 0;
        for(int level=n-1;level >=0;level--){
            int brickCnt = 0;
            int before=0;
            for(int next=1;next <bricks.length-1;next++){
                if(waters[level][next] == 1 && before != waters[level][next] ){
                    //next = next+1;
                    brickCnt++;
                }
                before = waters[level][next];

            }
            if(brickCnt > k) break;
            needBricks += (k-1)-brickCnt;
        }
        return needBricks;
    }

    public static int solution02_1(int[] bricks, int n, int k) {
        int[][] waters = new int[n][bricks.length];
        Queue<Integer> stacked = new LinkedList<>();
        for (int w = 0; w < bricks.length; w++) {
            int brick = bricks[w];
            for (int d = 0; d < n; d++) {
                if (brick > 0) {
                    waters[d][w] = 1;
                    brick--;
                }
            }
        }
        for (int level = n - 1; level >= 0; level--) {
            int brickCnt = 0;
            int before = 0;
            for (int next = 1; next < bricks.length - 1; next++) {
                if(waters[level][next] == 1 && before != waters[level][next] ){
                    stacked.offer(next);
                    brickCnt++;
                }
                before = waters[level][next];
            }

        }
        return 0;
    }


    private static void test03() {
//        String[] replies = {"AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF", "FCBBBFCBBECBB"};
        String[] replies = {"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"};
        int n = 4;
        int k = 2;
        System.out.println(Arrays.toString(solution03(replies,n,k)));
    }
    public static int[] solution03(String[] replies, int n, int k) {
        int[] answer = new int[replies.length];
        int answerIdx = 0;
        for(String replie : replies) {
            System.out.println(replie);
            int max = 0;
            for(int m=n;m <= replie.length()/2;m++) {
                for (int i = 0; i + m < replie.length(); i++) {
                    String pattern = replie.substring(i, i + m);
                    int duplicated = 1;
                    int idx = i + m;
                    if(idx + m > replie.length()){
                        break;
                    }
                    for (int j = idx; j+m <= replie.length(); j=j+m) {
                        if (duplicated > k) {
                            break;
                        }
                        String current = replie.substring(j, j + m);
                        if (pattern.equals(current)) {
                            duplicated++;
                        } else {
                            break;
                        }
                    }
                    max = Math.max(duplicated, max);
                }
            }
            System.out.printf("  %d 번째 :: %d",answerIdx, max);
            answer[answerIdx] = max >= k ? 0 : 1;
            answerIdx++;
        }
        return answer;
    }

    public static void sql01(){
        /**
         * SELECT COUNT(*) AS COUNT
         * FROM STARS A,
         *     (SELECT SUM(MASS)/COUNT(*) AS AVG
         *            FROM STARS) B
         * WHERE A.MASS >= B.AVG
         */
    }
    public static void sql02(){
        /**
         SELECT NAME
         , RANK() OVER(PARTITION BY SALARY ORDER BY SALARY DESC, NAME) AS RANK
         --, RANK() OVER(PARTITION BY SALARY ORDER BY SALARY DESC, NAME) AS RANK
         , SALARY
         FROM EMPLOYEES
         --ORDER BY SALARY DESC, RANK ASC

         -- 코드를 입력하세요
         SELECT NAME, RANK, SALARY
         FROM(
         SELECT NAME
         , RANK() OVER(ORDER BY SALARY DESC) AS RANK
         , SALARY
         FROM EMPLOYEES
         ORDER BY RANK
         ) ORDER BY NAME


         SELECT NAME
         , dense_rank() OVER(ORDER BY SALARY DESC) AS "RANK"
         , SALARY
         FROM EMPLOYEES
         ORDER BY NAME

         */
    }
}
