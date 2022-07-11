package com.test;

import java.util.*;

public class DevMatchingTest {
    public static void main(String[] args){
//        test01();
        test02();
//        test03();
//        test04();
    }
    private static void test01() {
        // 1 - 1
//        int[] A = {2, 1, 3};
        int[] A = {9,8,7,6,5,7,9};
        int result = solution01(A);
        System.out.println(result);
    }

    /**
     * 시험본 순으로 성적 기입
     * 앞사람 보다 뒷사람이 작지 않아야함
     * 앞사람이 뒷사람 보다 크다면 성적 하향 가능
     * 성적을 낮추는 것의 최소합
     */
    public static int solution01(int[] grade) {
        int answer = 0;
        int target = 0;
        for(int i=0; i< grade.length-1;i++){
            if(grade[i] > grade[i+1]){
                target++;
            }else{
                int j=i;
                while(target > 0){
                    j = i-target;
                    if(grade[j] > grade[i]) {
                        answer += grade[j] - grade[i];
                        grade[j] = grade[i];
                    }
                    target--;
                }
            }
        }
        return answer;
    }



    private static void test02() {
        int n = 4;
        boolean horizontal = true;
        int[][] result = solution02(n,horizontal);
        for(int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
    static int[][] answer;
    // direct 상, 하, 좌, 우
    static int[][] dx ={{1,0},{-1,0},{0,-1},{0,1}};
    static int N;
    static int lastX;
    static int lastY;

    public static int[][] solution02(int n, boolean horizontal) {
        answer = new int[n][n];
        N = n;
        for(int[] arr : answer) {
            Arrays.fill(arr, -1);
        }
        int depth = 1;
        lastX = 0;
        lastY = 0;
        // direct 상, 하, 좌, 우
        int startD = horizontal ? 4 : 1;
        while (depth < n){
            move(startD,0, depth++, 1,lastX,lastY);
        }

        return answer;
    }
    // direct 상, 하, 좌, 우
    public static int move(int direct, int visited, int depth, int dxCnt, int curX, int curY){
        if(dxCnt == dx.length){
            lastX = curX-dx[direct-1][1];
            lastY = curY-dx[direct-1][0];
            return depth;
        }
        if(depth < visited){
            curX = curX-dx[direct-1][1];
            curY = curY-dx[direct-1][0];
            direct = getDirection(direct, depth, curX, curY );
            dxCnt++;
            visited = 0;
        }
        int nextX = curX+dx[direct-1][1];
        int nextY = curY+dx[direct-1][0];
        answer[curY][curX]++;
        visited++;
        if(isValid(nextX,nextY,N)) move(direct, visited, depth, dxCnt,nextX ,nextY );
        return 0;
    }

    public static int getDirection(int curDirect, int depth, int curX, int curY){
        int direct = 0;
        for(int i=0; i < dx.length;i++){
            int nextX = curX + dx[i][1];
            int nextY = curY + dx[i][0];
            // 좌,우 -> 수평 이동 x
            if(curDirect%2 == 0 && dx[i][1] !=0) continue;
            // 상,하 -> 수직 이동 x
            if(curDirect%2 == 1 && dx[i][0] !=0) continue;
            // 이동불가 지역
            if(!isValid(nextX,nextY,depth)) continue;
            // 이미 방문 지역
            if(answer[nextY][nextX] > -1) continue;
            return direct = i+1;
        }
        return direct;
    }
    public static boolean isValid(int x, int y, int size){
        boolean isValid = true;
        if(x < 0 || x > size || y > size || y < 0) isValid = false;
        return isValid;
    }

    /**
     * 호수구하기
     * - 섬들로 둘러쌓인
     */
    private static void test03() {
        // 1 - [1,4]
        int rows = 9;
        int columns = 7;
        int[][] lands = {{2, 2}, {2, 3}, {2, 5}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {4, 3}, {4, 6}, {5, 2}, {5, 5}, {6, 2}, {6, 3}, {6, 4}, {6, 6}, {7, 2}, {7, 6}, {8, 3}, {8, 4}, {8, 5}};

        int[] result = solution03(rows,columns,lands);
        System.out.println(result);
    }
    public static int[] solution03(int rows, int columns, int[][] lands) {
        int[] answer = {};
        return answer;
    }


    /**
     * month 별로 리뷰가 가장 많은 row 찾아서 해당 id 기준 제목 출력
     */
    private static void test04() {
        String sql = "";
    }


}
