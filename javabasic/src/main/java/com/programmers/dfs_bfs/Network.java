package com.programmers.dfs_bfs;

import java.util.Arrays;
import java.util.Stack;

public class Network {
    public static void main(String[] args){
        int n = 8;
        int[][] computers = {{1,1,0,1,0,0,0,0}, {1,1,0,0,0,0,0,0}, {0,0,1,0,1,0,0,0}
                            , {1,0,0,1,0,0,0,0}, {0,0,1,0,1,0,0,0}, {0,0,0,0,0,1,0,0}
                            , {0,0,0,0,0,0,1,0} , {0,0,0,0,0,0,0,1}};
        int result = solution(n, computers);
        System.out.println(result);
        result = solution3(n, computers);
        System.out.println(result);
    }

    private static int solution3(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        Stack<Integer> list = new Stack<>();
        for(int i=0;i< computers.length;i++){
            if(!visited[i]){
                list.push(i);
                while(!list.isEmpty()){
                    int start = list.peek();
                    for(int j=start; j< computers.length;j++){
                        if(i!=j && computers[i][j] == 1 && visited[j] == false){
                            list.push(j);
                        }
                    }
                    list.pop();
                    visited[start] = true;
                }
            }
            answer++;
        }
        return answer;
    }

    static int[] parent;
    public static int solution(int n, int[][] computers) {
        //Arrays.sort(computers, (int[] c1, int[] c2) -> c1[2] - c2[2]);
        parent = new int[n];
        for(int i=0; i< n; i++) parent[i] = i;
        int total =0;
        for(int i=0; i < computers.length;i++){
            for(int j=0; j < computers[0].length; j++){
                if(i!=j && computers[i][j] == 1) {
                    int fromParent = getParent(i);
                    int toParent = getParent(j);
                    parent[toParent] = fromParent;
                }
            }
        }
        Arrays.sort(parent);
        return total = (int) Arrays.stream(parent).distinct().count();
    }

    private static int getParent(int node) {
        if(node == parent[node]) return node;
        return parent[node] = getParent(parent[node]);
    }

    public static int solution2(int n, int[][] computers){
        int answer = 0;
        boolean[] checked = new boolean[n];

        for(int i=0; i <n ;i++){
            if(!checked[i]){
                dfs(computers, i, checked);
                answer++;
            }
        }
        return answer;
    }

    private static boolean[] dfs(int[][] computers, int i, boolean[] checked) {
        checked[i] = true;
        for(int j=0; j < computers.length;j++){
            if( i!=j && computers[i][j] == 1 && checked[j] == false){
                checked = dfs(computers,j,checked);
            }
        }
        return checked;
    }
}
