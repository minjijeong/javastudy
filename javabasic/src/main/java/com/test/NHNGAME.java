package com.test;

import com.programmers.ShortCutOfGameMap_1;
import com.programmers.ShortCutOfGameMap_1.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.UnaryOperator;

public class NHNGAME {
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
        test04();
    }

    private static void test01() {
        int[][] card1 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int[][] card2 = {{5, 7, 9, 11, 13},{11, 13, 15, 17, 19}};
        // 카드는 오름차순
        // 라운드마다 더미에서 5장씩 받음 = card[n] = 5
        // 카드 1~52  1 ≤ cards1[i][j] ≤ 52

        int result = solution1(card1,card2);
        System.out.println(result);
    }
    public static int solution1(int[][] cards1, int[][] cards2) {
        int answer = 0;
        int maxCardCnt = 5;
        Map<Integer,List<Integer>> p1 = new HashMap<>();
        Map<Integer,List<Integer>> p2 = new HashMap<>();

        for(int i=0;i<cards1.length;i++) {
            List<Integer> card1 = new ArrayList<>();
            List<Integer> card2 = new ArrayList<>();

            for(int j=0;j<cards1[i].length;j++){
                card1.add(cards1[i][j]);
                card2.add(cards2[i][j]);
            }
            p1.put(i,card1);
            p2.put(i,card2);
        }
        // n개의 라운드 max 100
        // 라운드가 끝나면 반납
        int n = p1.size();
        List<Integer> card1before = new ArrayList<>();
        List<Integer> card2before = new ArrayList<>();
        for(int i=0;i<n;i++) {
            List<Integer> card1  = p1.get(i);
            List<Integer> card2  = p2.get(i);
            // 카드가 잘섞이지 않으면 문제가 있는 라운드로 인정 = 문제가 있는경우
            // 한 라운드에서 두 플레이어가 받은 카드 10장 중에서 중복되는 번호가 있는 경우
            int dup1 = 0;
            int dup2 = 0;
            for (int j = 0; j < maxCardCnt; j++) {
                if(card1.contains(card2.get(j))){
                    answer++;
                    break;
                }

                // 한 플레이어가 직전 라운드에서 받은 카드 5장과 이번 라운드에서 받은 카드 5장을 비교했을 때, 중복되는 번호가 2개 이상 있는 경우
                if(card1before.size() > 1) {
                    if(dup1 >= 2){
                        answer++;
                        break;
                    }

                    if(card1before.contains(card1.get(j))){
                        dup1++;
                    }
                }
                if(card2before.size() > 1) {
                    if(dup2 >= 2){
                        answer++;
                        break;
                    }

                    if(card2before.contains(card2.get(j))){
                        dup2++;
                    }
                }
            }

            card1before.clear();
            card1before.addAll(card1);
            card2before.clear();
            card2before.addAll(card2);
        }
        return answer;
    }

    private static void test02() {
        int[] balance = {30, 30, 30, 30};
        int[][] transaction ={{1, 2, 10}, {2, 3, 20}, {3, 4, 5}, {3, 4, 30}} ;
        int[] abnormal = {1};
        int[] result = solution2(balance, transaction,abnormal);
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution2(int[] balance, int[][] transaction, int[] abnormal) {
        int[] answer = {};
        // 가장 최근에 획극한 재화부터 줄수 있다.
        return answer;
    }


    private static void test03() {
        String[] maze = {};
        String[] queries = {};
        int[] result = solution3(maze, queries);
        System.out.println(Arrays.toString(result));
    }

    static boolean[][] visited;
    static char[][] map;
    public class miro{
        String allowStr;
        int move;
        int[][] visited;
        miro(String allowStr, int[][] visited){
            this.allowStr = allowStr;
            move = 0;
            this.visited = visited;
        }
        void move(){
            // 상

            // 하
            // 좌
            // 우
        }
    }
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
    public static int[] solution3(String[] maze, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        int mapWidth = maze[0].length();
        int mapHeight = maze.length;
        visited = new boolean[mapHeight][mapWidth];
        map = new char[mapHeight][mapWidth];
        for(int i=0;i<mapHeight;i++){
            map[i] = maze[i].toCharArray();
        }
        // 입구
        //maze[queries[1]][queries[0]]
        // 출구
        //maze[queries[3]][queries[2]]
        // 이동가능한 알파벳 :
        String allowStr = queries[4];

        Queue<Position> queue = new LinkedList<>();
        int x = Integer.parseInt(queries[0]);
        int y = Integer.parseInt(queries[1]);
        queue.add(new Position(x,y));
        visited[y][x] = true;
        int distance = 1;
        while(!queue.isEmpty()){
            Position current = queue.poll();

            char currentMap = map[current.y][current.y];

            // 4가지 경우
            final int[][] moving = {{0,-1},{0,1},{-1,0},{1,0}};
            for(int i=0; i < moving.length ; i++){
                Position moved = new Position(current.x + moving[i][0], current.y + moving[i][1]);
                if(!moved.isValid(mapWidth,mapHeight)) continue; // 맵바깥으로
                if(visited[moved.y][moved.x]) continue;// 이미 방문한 곳
                if(allowStr.contains(String.valueOf(map[moved.y][moved.x]))) {
                    continue; // 0: 벽, 1: 길
                }
                visited[moved.y][moved.x] = true;
                distance++;
                queue.offer(moved);
            }
        }

        // 최소 이동 격자 = 5
        return answer;
    }

    private static void test04() {
        long[] players = {10, 11, 15, 14, 16, 18, 19, 20}; // 상대할 플레이어의 공격력
        int power = 10; // 당신의 처음 공격력을 뜻하는 정수
        int k = 2; //게임에서 패배하면 얻는 공격력
        long result = solution4(players, power, k);
        System.out.println(score);
    }
    static int score = 0;
    public static long solution4(long[] players, int power, int k) {
        long max = 0;
        for(int i=0;i<players.length;i++){
            max = Math.max(max, players[i]);
        }
        // 공격력이 높은 사람이 승리하고, 낮은 사람은 패배합니다.
        // 공격력이 같다면, 두 플레이어 모두 승리합니다.
        // 당신은 고의로 패배할 수 있습니다. 단, 상대방은 고의로 패배하지 않습니다.

        // 게임에서 패배하면 공격력 k를 얻습니다.
        // 게임에서 연승했을 경우, 연승한 횟수만큼 공격력을 얻게 됩니다. (1연승시 공격력 1, 2연승시 공격력 2, ...)
        // 예를 들어, 3승 0패로 게임을 끝냈을 경우, 1연승과 2연승을 거쳐 3연승을 한 것이므로, 총 1 + 2 + 3 = 6의 공격력을 추가로 얻습니다.

        // player 선택
        // 승리 - 공격력이 같거나 큰 경우
        // 패배 - 공격력 모자라서 패배
        // 패배 - 자의적 패배 -
        score = players.length * k + power;
        if( players.length * k + power > (players.length * (players.length+1) / 2) + power * players.length){
            return score;
        }

        dfs(players, power, k, 0,0);
        return score;
    }
    public static void dfs(long[] players, int power, int k, int location, int victory){
        score = Math.max(power,score);
        int expectFail = power+k;
        int expectSucc = power+(victory+1);
        boolean now = players[location] >= power;

        if(location >= players.length - 1){
            return;
        }

        // 승리
        if(players[location] <= power){
            // 자의적 패배
            if(expectFail > expectSucc) {
                dfs(players, power + k, k, location + 1, 0);
            }
            // 승리
            victory++;
            if(victory > 0){
                power += victory;
            }
            dfs(players, power, k, location+1, victory);
        }
        // 패배
        else{
            power += k;
            dfs(players, power, k, location+1, 0);
        }
    }

}
