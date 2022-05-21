package com.programmers;

import static com.programmers.Virus.printMap;

import java.util.Arrays;

public class Virus_Other {

    static int h;
    static int w;
    static int[][] board;
    static boolean[][] visited;
    static int maxVirus;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};
        int[][] result = solution(rows,columns,max_virus, queries);
        int[][] test = new int[rows][columns];
        for(int i=0; i<queries.length;i++) {
            int[] tmp = queries[i];
            int y = tmp[0]-1;
            int x = tmp[1]-1;
            test[y][x]++;
        }
        printMap(test);
        printMap(result);

    }

    public static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        init(rows, columns, max_virus);

        for (int[] query : queries) {
            int r = query[0] - 1;
            int c = query[1] - 1;

            prepare(r, c);
            exploit(r, c);
            fill();
        }

        return board;
    }

    static void init(int rows, int columns, int max_virus) {
        h = rows;
        w = columns;
        board = new int[h][w];
        visited = new boolean[h][w];
        maxVirus = max_virus;
    }

    static void prepare(int r, int c) {
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        visited[r][c] = true;
    }

    static void exploit(int r, int c) {
        if (board[r][c] == maxVirus) {
            for (int d = 0; d < 4; d++) {
                int ty = r + dy[d];
                int tx = c + dx[d];
                if (isValid(ty, tx) && !visited[ty][tx]) {
                    visited[ty][tx] = true;
                    exploit(ty, tx);
                }
            }
        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }

    static void fill() {
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                board[r][c] += board[r][c] < maxVirus && visited[r][c] ? 1 : 0;
            }
        }
    }
}
