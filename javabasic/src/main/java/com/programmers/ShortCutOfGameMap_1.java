package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ShortCutOfGameMap_1 {
    public static class Position{
        int x, y;
        boolean isValid(int width, int height){
            if(x<0 || x >= width) return false;
            if(y<0 || y >= height) return false;
            return true;
        }
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 1. 네 방향으로 한 칸씩 이동한다.
     * 2. 이동한 후에는 현재값보다 1 큰 값을 채운다.
     * 3. 벽, 미로 밖, 왔던길 못간다.
     *
     * BFS - Queue에 케이스를 담고, 다 소진할때까지 루프도는 것
     */
    public static int solution(int[][] maps) {
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;

        Queue<Position> queue = new LinkedList<>();
        int[][] count = new int[mapHeight][mapWidth];
        boolean[][] visited = new boolean[mapHeight][mapWidth];

        queue.add(new Position(0,0));
        count[0][0] = 1;
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Position current  = queue.poll();

            int currentCount = count[current.y][current.x];

            // 4가지 경우   
            final int[][] moving = {{0,-1},{0,1},{-1,0},{1,0}};
            for(int i=0; i< moving.length;i++){
                Position moved = new Position(current.x + moving[i][0], current.y+moving[i][1]);
                if(!moved.isValid(mapWidth,mapHeight)) continue; // 맵바깥으로
                if(visited[moved.y][moved.x]) continue;// 이미 방문한 곳
                if(maps[moved.y][moved.x] == 0) continue; // 0: 벽, 1: 길

                count[moved.y][moved.x] = currentCount +1;
                visited[moved.y][moved.x] = true;
                queue.offer(moved);
            }
        }
        int answer = count[mapHeight-1][mapWidth-1];
        if(answer == 0) return  -1;
        return answer;
    }

    public static void main(String[] args) {
        // 1,3,5,7
        // 2,2,6,8
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
        int[][] maps2 = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
        System.out.println(solution(maps2));
    }
}
