package com.test;

import java.util.Arrays;
import util.TestTimeUtils;

public class DevMatching_2022_02 {
    public static void main(String[] args) {
        TestTimeUtils time = new TestTimeUtils();
        int n = 3;
        boolean horizontal = false;
        int[][] result = solution02(n,horizontal);
        System.out.println("Time Spend :: "+ time.getSpendTime());
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
    static int cost;
    static int lastDirect;

    public static int[][] solution02(int n, boolean horizontal) {
        answer = new int[n][n];
        N = n;
        cost = 2;
        for(int[] arr : answer) {
            Arrays.fill(arr, -1);
        }
        int depth = 2;
        // direct 상, 하, 좌, 우
        // 처음 방향은 고정
        lastDirect = horizontal ? 3 : 0;
        answer[0][0] = 1;
        while (depth <= n){
            lastX += dx[lastDirect][1];
            lastY += dx[lastDirect][0];
            // 방향, 현재위치, 가중치, depth
            move(lastDirect,lastX,lastY, depth++);
        }

        return answer;
    }

    private static void move(int direct, int x, int y, int depth) {
        // cost == depth * depth
        int beforeY = y - dx[direct][0];
        int beforeX = x - dx[direct][1];
        if(cost > depth * depth){
            lastX = beforeX;
            lastY = beforeY;
            lastDirect = direct;
            return;
        }
        // 방향 바꾸는 타이밍
        if(!isValid(x,y,depth)){
            // 방향 바꾸기
            x = beforeX;
            y = beforeY;
            direct = changeDirection(x,y,depth,direct);
            // 이동
            move(direct,x+dx[direct][1],y+dx[direct][0],depth);
        }else{
            answer[y][x] = cost;
            cost++;
            move(direct,x+dx[direct][1],y+dx[direct][0],depth);
        }
    }
    public static int changeDirection(int x, int y, int depth, int direct){
        for(int i=0; i<dx.length;i++){
            int nextX = x + dx[i][1];
            int nextY = y + dx[i][0];
            if(i == direct) continue;
            boolean valid = isValid(nextX,nextY,depth);
            if(!valid) continue;
            int nextVal = answer[nextY][nextX];
            System.out.println(nextVal);
            if(answer[nextY][nextX] > 0) continue;
            return direct = i;
        }
        return direct;
    }

    public static boolean isValid(int x, int y, int size){
        boolean isValid = true;
        if(x < 0 || x >= size || y >= size || y < 0) isValid = false;
        return isValid;
    }

}
