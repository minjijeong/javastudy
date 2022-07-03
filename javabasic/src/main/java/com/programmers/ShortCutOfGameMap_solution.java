package com.programmers;

import java.util.*;

public class ShortCutOfGameMap_solution {
    public static void main(String[] args) {
        // 1,3,5,7
        // 2,2,6,8
//        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
//        System.out.println(solution(maps));
        int[][] maps2 = {{1,1,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,1,0}, {0,0,0,0,1}};
        System.out.println(solution(maps2));
    }

    /**
     * 시작점과 끝점이 고정되어 있어 방문이력을 다시 복원할 필요가 없음
     */
    public static final int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static int n, m;

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        Queue<Integer> queue = new LinkedList<>();
        // 방문 + 가중치
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }

        queue.add(0);
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curX = cur / 100;
            int curY = cur % 100;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                // 맵 안쪽에 위치, 다음 이동지점이 길인지, 방문한적 없는지
                if (!outOfBound(nextX, nextY) &&
                        maps[nextX][nextY] == 1 && visited[nextX][nextY] == -1) {
                    // X,Y - 파싱이나 변환없이 넘겨주기위해, y가 100미만 인것을 고려하여 구성된 코드
                    queue.add(nextX * 100 + nextY);
                    // 가중치 추가
                    visited[nextX][nextY] = visited[curX][curY] + 1;
                }
            }
        }

        return visited[n - 1][m - 1];
    }

    // 맵을 벗어나는 케이스 처리
    public static boolean outOfBound(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return false;
        }
        return true;
    }
}
