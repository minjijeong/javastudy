package com.programmers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TripRoot {
    public static void main(String[] args){
//        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
        String[] result = solution2(tickets);
        System.out.println(Arrays.toString(result));
    }
    public static String[] solution(String[][] tickets) {
        // 출발  "ICN"
        List<String> answer = new ArrayList<>();
        Queue<String> trip = new LinkedList<>();
        trip.offer("ICN");

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o2[0].equals(o1[0])) return (o1[1]+o2[1]).compareTo(o2[1]+o1[1]);
                else return (o1[0]+o2[0]).compareTo(o2[0]+o1[0]);
            }
        });

        boolean[] used = new boolean[tickets.length];
        int idx = used.length;
        while(!trip.isEmpty()){
            for(int i=0;i < tickets.length; i++){
                String depart = trip.peek();
                if(!used[i] && depart.equals(tickets[i][0])){
                    used[i] = true;
                    idx--;
                    String current = trip.poll();
                    answer.add(current);
                    trip.offer(tickets[i][1]);
                }
            }
            if(idx == 0){
                String last = trip.poll();
                answer.add(last);
                break;
            }
        }
        return answer.stream().toArray(String[]::new);
    }

    static List<String> cities;
    static boolean[] visited;
    public static String[] solution2(String[][] tickets){
        cities = new ArrayList<>();
        visited = new boolean[tickets.length];
        // 기준 데이타, 방문 데이타, depth, 시작점, 방문한 도시 조합
        dfs(tickets, visited, 0, "ICN", "ICN");
        Collections.sort(cities);
        return Arrays.stream(cities.get(0).split(" ")).toArray(String[]::new);
    }

    private static void dfs(String[][] tickets, boolean[] visited, int idx, String s, String result) {
        // depth = 전체 티켓 조회 했는지?
        if(idx == tickets.length){
            cities.add(result);
            return;
        }

        for(int j=0; j < tickets.length;j++){
            // 방문 안한 티켓 && 이전 도착 공항 = 현재 출발공항 일치하면
            if(!visited[j] && tickets[j][0].equals(s)){
                visited[j] = true;
                // 다음 공항 비교
                dfs(tickets, visited, idx+1, tickets[j][1], result+" "+tickets[j][1]);
                visited[j] = false;
            }
        }
    }
}
