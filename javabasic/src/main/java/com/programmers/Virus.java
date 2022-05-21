package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Virus {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};
//        int[][] result = solution(rows,columns,max_virus, queries);
        int[][] result = solution01(rows, columns, max_virus,queries);
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

    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] answer;

    private static int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
        // 쿼리를 순서대로 세균증식 시킨다.
        // r행 c열 세균이 < max_virus -> 세균수++;
        // r행 c열 세균이  == max_virus -> 상화좌우 캉에 세균 증식을 시킨다.
        // 한 쿼리(한 지점)에서 동일한 칸에서는 최대 1번의 세균 증식만 일어난다.  ????
        Queue<int[]> standBy = new LinkedList<>();
        for(int i=0; i<queries.length;i++) {
            int[] current = queries[i];
            int y = current[0]-1;
            int x = current[1]-1;
            System.out.printf("%d 번째, x: %d, y : %d \n", i, x, y);
            printMap(answer);
            //            System.out.printf("x : %d, y : %d \n", x, y);
//            System.out.printf("rows : %d, columns : %d \n", rows, columns);
            while(!standBy.isEmpty()){
                int[] tmp = standBy.poll();
//                System.out.println(" >>> tmp ::"+Arrays.toString(tmp));
//                System.out.println(" move.length : "+move.length);
                for(int j=0; j < move.length;j++){
                    int yy = tmp[0] + move[j][0];
                    int xx = tmp[1] + move[j][1];
//                    System.out.printf("xx : %d, yy : %d \n", xx, yy);
                    if(xx >= answer[0].length  || xx < 0) continue;
                    if(yy >= answer.length || yy < 0 ) continue;
//                    System.out.printf(" >> xx : %d, yy : %d \n", xx, yy);
                    if(answer[yy][xx] < max_virus) {
                        answer[yy][xx]++;

                        if(answer[yy][xx] == max_virus){
                            int[] tmp2 = {yy,xx};
                            standBy.add(tmp2);
//                        answer[yy][xx] = max_virus;
                        }
                    }
                    if(answer[yy][xx] == max_virus){
                        continue;
                    }
                }
                printMap(answer);
            }

//                int[] current = queries[c][r];
            if(answer[y][x] < max_virus){
                answer[y][x]++;
            }

            if(answer[y][x] >= max_virus){
                int[] tmp = {y,x};
                standBy.add(tmp);
                answer[y][x] = max_virus;
            }
        }
        // 최종 세균 증식 상태 return
        return answer;
    }

    static void printMap (int[][] map){
        System.out.println("==================");
        for(int i=0;i<map.length;i++) System.out.println(Arrays.toString(map[i]));
        System.out.println("==================");
        System.out.println(Arrays.deepToString(map));
    }

    public static int[][] solution01(int rows, int columns, int max_virus, int[][] queries) {
        answer = new int[rows][columns];

        for(int i = 0; i < queries.length; i++){
            int r = queries[i][0];
            int c = queries[i][1];
            visited = new boolean[rows][columns];

            DFS(r-1, c-1, max_virus);

        }

        return answer;
    }

    private static void DFS(int r, int c, int max){
        if(answer[r][c] < max) answer[r][c]++;
        else if(answer[r][c] == max){
            visited[r][c] = true;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= visited.length || nc < 0 || nc >= visited[0].length) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;

                if(answer[nr][nc] >= max - 1) DFS(nr, nc, max);
                else answer[nr][nc]++;


            }
        }
    }

}
