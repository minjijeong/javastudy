package com.programmers;

import java.util.*;

public class ShortCutOfGameMap {
    public static class Location{
        int x, y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        boolean equals (Location other){
            return this.x == other.x && this.y == other.y;
        }

        Location left() {return new Location(x-1,y);}
        Location right(){return  new Location(x+1, y);}
        Location up(){return new Location(x, y-1);}
        Location down(){return  new Location(x,y+1);}

    }
    public static class Position{
        int steps;
        Location location;
        Position(Location loc, int s){
            this.location = loc;
            this.steps = s;
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
        int mapSizeX = maps.length;
        int mapSizeY = maps[0].length;

        final Location target = new Location(mapSizeX-1, mapSizeY-1);

        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0,0),1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Position now  = queue.poll();

            // map 밖인 경우
            if(now.location.x < 0 || now.location.x >= mapSizeX) continue;
            if(now.location.y < 0 || now.location.y >= mapSizeY) continue;
            // 현재가 벽이라면...?
            if(maps[now.location.x][now.location.y] == 0) continue;

            // 이미 방문했다면
            if(visited[now.location.x][now.location.y]) continue;

            visited[now.location.x][now.location.y] = true;

            // 최종인지 확인
            if(now.location.equals(target)){
                return now.steps;
            }

            // 다음 방문할 곳 등록
            queue.offer(new Position(now.location.left(), now.steps+1));
            queue.offer(new Position(now.location.right(), now.steps+1));
            queue.offer(new Position(now.location.up(), now.steps+1));
            queue.offer(new Position(now.location.down(), now.steps+1));
        }
        return -1;
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
