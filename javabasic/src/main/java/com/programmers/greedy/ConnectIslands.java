package com.programmers.greedy;

import java.util.Arrays;

public class ConnectIslands {
    public static void main(String[] args){
        int n = 4;
        int[][] costs = {{0,1,1}, {0,2,2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int result = solution(n, costs);
        System.out.println(result);
    }

    static int[] parent;
    public static int solution(int n, int[][] costs) {
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);
        parent = new int[n];
        for(int i=0; i < n;i++) parent[i] = i;

        int total = 0;
        for(int[] edge : costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            // 부모 노드 찾기
            int fromParent = findParent(from);
            int toParent = findParent(to);
            // 같은 부모노드를 가진 경우 추가할 필요없음
            // 상단에서 cost기준 소팅했기때문에
            if(fromParent == toParent) continue;

            total += cost;
            parent[toParent] = fromParent;
        }

        return total;
    }
    private static int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    static int[] parents;
    public static int solution2(int n, int[][] costs){
        Arrays.sort(costs, (int[] c1, int[] c2 ) -> c1[2] - c2[2]);
        parent = new int[n];
        for(int i=0; i<n;i++) parent[i] = i;

        int total = 0;
        for(int[] edge : costs){
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findParent2(from);
            int toParent = findParent2(to);
            if(fromParent == toParent) continue;

            total += cost;
            parents[toParent] = fromParent;
        }
        return total;
    }

    private static int findParent2(int node) {
        if(node == parents[node]) return node;
        return parents[node] = findParent2(parents[node]);
    }
}
