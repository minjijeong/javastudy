package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SKTest {
    public static void main(String[] args){
//        sol01();
//        sol02();
//        sol03();
        sol04();
    }

    private static void sol04() {
        String[] map = {"..FF", "###F", "###."};
        int k = 4;
        int result = solution04(map, k);
        System.out.println(result);
    }

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

    public static int solution04(String[] grid, int k) {
        int answer = -1;
        int mapSizeX = grid.length;
        int mapSizeY = grid[0].length();
        char[][] maps = new char[mapSizeX][mapSizeY];
        int idx = 0;
        for(String row : grid){
            maps[idx] = grid[idx].toCharArray();
        }
        final Location target = new Location(mapSizeX-1, mapSizeY-1);

        boolean[][] visited = new boolean[mapSizeX][mapSizeY];

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0,0),1));
        //visited[0][0] = true;
        while(!queue.isEmpty()){
            Position now  = queue.poll();

            // map 밖인 경우
            if(now.location.x < 0 || now.location.x >= mapSizeX) continue;
            if(now.location.y < 0 || now.location.y >= mapSizeY) continue;
            // 현재가 강이라면...?
            if(maps[now.location.x][now.location.y] == '#') continue;

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

    private static void sol03() {
        int n = 5;
        String[] plans = {"100 1 3", "500 4", "2000 5"};
        String[] clients = {"300 3 5", "1500 1", "100 1 3", "50 1 2"};
        int[] result = solution03(n, plans, clients);
        System.out.println(Arrays.toString(result));
    }
    public static class Table{
        int idx; // 요금제번호
        int data; // 데이타 제공량
        List<Integer> extras; // 제공되는 부가서비스 종료
        Table(int idx, int data, List<Integer> extras){
            this.idx = idx;
            this.data = data;
            this.extras = extras;
        }

    }

    public static int[] solution03(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        Map<Integer, Table> planMap = castStringArrayToMapList(plans, true);
        Map<Integer, Table> customerMap = castStringArrayToMapList(clients, false);

        for(int customer : customerMap.keySet()){
            Table cusInfo = customerMap.get(customer);
            int choice = -1;
            int minPlanIdx = n;
            for(int plan : planMap.keySet()){
                Table planInfo = planMap.get(plan);
                if(plan >= customer){
                    // extras = 모든 부가서비스 plan 내에 있어야 한다.
                    int chkExtra = cusInfo.extras.size();
                    for(int j=0; j<cusInfo.extras.size();j++) {
                        boolean includedExtra = false;
                        for (int i = 0; i < planInfo.extras.size(); i++) {
                            if(cusInfo.extras.get(j) == planInfo.extras.get(i)){
                                includedExtra = true;
                                break;
                            } else if (planInfo.extras.get(i) > cusInfo.extras.get(j)) {
                                break;
                            }
                        }
                        if(!includedExtra){
                            answer[cusInfo.idx] = 0;
                            break;
                        }else{
                            chkExtra --;
                        }
                    }
                    if(chkExtra == 0){
                        minPlanIdx = Math.min(minPlanIdx,planInfo.idx + 1);
                    }
                }
            }
            if(minPlanIdx <= n){
                answer[cusInfo.idx] = minPlanIdx;
            }
        }

        return answer;
    }

    private static Map<Integer, Table> castStringArrayToMapList(String[] strings, boolean isCombine) {
        Map<Integer, Table> map = new HashMap<>();
        List<Integer> totExtras = new ArrayList<>();
        for(int i=0; i<strings.length;i++) {
            List<Integer> extras = new ArrayList<>();
            if(isCombine) {
                extras.addAll(totExtras);
            }
            String[] string = strings[i].split(" ");
            int data = Integer.parseInt(string[0]);
            for(int j=1;j<string.length;j++){
                int num = Integer.parseInt(string[j]);
                extras.add(num);
                totExtras.add(num);
            }
            Table tb = new Table(i, data,extras );
            map.put(data, tb);
        }
        return map;
    }

    private static void sol02() {
        int[] periods = {24, 59, 59, 60};
        int[][] payments = {{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
                , {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
                , {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
                , {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
        int[] estimates = {350000, 50000, 40000, 50000};

        int[] result = solution02(periods, payments, estimates);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution02(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2]; // VIP 자격취득/ VIP 자격손실
        int[][] customer = new int[periods.length][4]; // 0 : 이번달 차수, 1: 다음달 예상차수, 2 : 이번달 총 금액, 3: 다음달 총 금액
        /**
          * VIP 조건
          * 조건1 : 가입기간 2년 이상 ~ 5년 미만 - 90만원 이상
          * 조건2 : 가입기간 5년이상 - 60만원 이상
          */
        int vipAmt = 900000;
        int vipMonth = 24;
        int vipAmt2 = 600000;
        int vipMonth2 = 60;

        for(int i=0; i< periods.length;i++){
            if(periods[i] < vipMonth - 1){
                continue;
            }
            customer[i][0] = periods[i]; // 0 : 이번달 차수
            customer[i][1] = periods[i] + 1; // 1: 다음달 예상차수
            for(int j=0; j< payments[i].length; j++){
                if(j != 0) customer[i][3] += payments[i][j];
                customer[i][2] += payments[i][j]; // 2 : 이번달 총 금액
            }
            customer[i][3] += estimates[i]; // 3: 다음달 총 금액
            boolean thisMonth = false; // 이번달 VIP여부
            boolean nextMonth = false; // 다음달 VIP여부
            // 고객 이번달 VIP 인지 확인
            // 24개월보다 크고 60개월보다 작을때 90만원 요금보다 많거나 같을때
            // 60개월보다 크거나 같고 60만원보다 많거나 같을때
            if(customer[i][0] >= vipMonth && customer[i][0] < vipMonth2 && customer[i][2] >= vipAmt){
                thisMonth = true;
            }
            else if(customer[i][0] >= 60 && customer[i][2] >= vipAmt2){
                thisMonth = true;
            }

            // 고객 다음달 VIP 인지 확인
            if(customer[i][1] >= vipMonth && customer[i][1] < vipMonth2 && customer[i][3] >= vipAmt){
                nextMonth = true;
            }
            else if(customer[i][1] >= vipMonth2 && customer[i][3] >= vipAmt2){
                nextMonth = true;
            }

            // 고객 이번달 VIP고 다음달 VIP 아니면
            if(thisMonth && !nextMonth) {
                answer[1]++;
            }else if(!thisMonth && nextMonth){
                // 고객 이전달 VIP아니고 다음달 VIP면
                answer[0]++;
            }

            System.out.println(Arrays.toString(customer[i]));
            System.out.println(thisMonth + ", " + nextMonth);
            System.out.println(Arrays.toString(answer));
        }
        return answer;
    }

    public static void sol01(){
        int[] p = {2, 5, 3, 1, 4};
        int[] result = solution01(p);
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution01(int[] p) {
        int[] answer = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;

            for (int j = i + 1; j < p.length; j++) {
                if (p[i] > p[j]) {
                    if(min > p[j]){
                        min = p[j];
                        minIdx = j;
                    }
                }
            }
            if(min != Integer.MAX_VALUE) {
                System.out.println(i + "번째 :");
                System.out.println(Arrays.toString(p));
                //swap
                int temp = p[i];
                p[i] = p[minIdx];
                p[minIdx] = temp;
                answer[i]++;
                answer[minIdx]++;
                System.out.println(Arrays.toString(p));
                System.out.println(Arrays.toString(answer));
            }
        }

        return answer;
    }

}
