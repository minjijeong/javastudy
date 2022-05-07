package com.programmers;

public class IntegerTriangle_1 {
    static int answer = 0;
    static int[][] table;
    public static int solution(int[][] triangle) {
        //int answer = 0;
        table = triangle;
        dfs(0,0, 0);
        return answer;
    }

    // n : 삼각형 층
    // size : 해당 층의 숫자 개수
    static void dfs(int n, int idx, int sum){
        int maxLevel = table.length -1;
        int maxIdx = table[n].length -1;
//        System.out.printf("n : %d, idx : %d, sum: %d, answer : %d ", n, idx , sum, answer);
//        System.out.printf(", data : %d \n", table[n][idx]);
        if(n >= maxLevel && idx >= maxIdx) return;

        sum += table[n][idx];
        if(answer < sum){
            answer = sum;
        }
        if(n + 1 >  maxLevel){
            return;
        }

        int nextSize = table[n+1].length -1;
        // 좌측 하위
        dfs(n + 1, idx, sum);

        // 우측 하위
        if(nextSize < idx + 1){
            return;
        }
        dfs(n + 1, idx + 1, sum);
    }

    public static void main(String[] args) {
//        int[][] triangle  ={{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6}};
        int[][] triangle  ={{9},{2,7},{7,3,2}};
        System.out.println(solution(triangle));
    }
}
