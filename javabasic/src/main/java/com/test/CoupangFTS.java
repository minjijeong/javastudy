package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CoupangFTS {
    public static void main(String[] args){
//        sol01();
        sol02();
//        sol03();
    }
    private static void sol01() {
        int n = 6;
        int[][] del = {{1, 3, 1},{3, 5, 0},{5, 4, 0},{2, 5, 0}};
        String result = solution01(n, del);
        System.out.println(result);
    }
    public static String solution01(int n, int[][] delivery){
        String anwser = "";
        char[] status = new char[n];
        Arrays.fill(status, '?');
        Arrays.sort(delivery, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        // 첫번째 상품 번호, 두번째 상품번호 , 배송여부
        for(int i=0; i<delivery.length;i++){
            int[] order = delivery[i];
            if(order[2] == 1){
                status[order[0]-1] = 'O';
                status[order[1]-1] = 'O';
            }else{
                if(status[order[0]-1] == 'O'){
                    status[order[1]-1] = 'X';
                }else if(status[order[1]-1] == 'O'){
                    status[order[0]-1] = 'X';
                }
            }
        }
        anwser = new String(status);
        return anwser;
    }


    private static void sol02() {
        long n = 6;
        long[] result = solution02_1(n);
        System.out.println(Arrays.toString(result));
    }
    static Set<Long> primeNumbers;
    static Set<Long> unPrimeNumbers;

    public static long[] solution02(long n){
        long[] list = new long[2];
        List<Long> numbers = new ArrayList<>();
        primeNumbers = new HashSet<>();
        unPrimeNumbers = new HashSet<>();

        for(long i=2;i<n;i++){
            if(isPrime(i)) {
                long t = (n % i == 0 ) ? n / i : 0;
                if( t!= i) {
                    if (isPrime(t)) {
                        if (list[0] != i && list[1] != i && list[0] != t && list[1] != t) {
                            list[0] = i;
                            list[1] = t;
                        }
                    }
                }else{
                    break;
                }
            }
        }
        if(numbers.size() == 0){
            return new long[]{-1,-1};
        }
        return list;
    }

    private static boolean isPrime(long n) {
        if(primeNumbers.contains(n)) return true;
        if(unPrimeNumbers.contains(n)) return false;
        if(n < 2){
            unPrimeNumbers.add(n);
            return false;
        }
        for(int i=2; i < n; i++){
            if(n % i == 0 ){
                unPrimeNumbers.add(n);
                return false;
            }
        }
        primeNumbers.add(n);
        return true;
    }
    public static class Pair{
        long m;
        long n;
        Pair(long m , long n){
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return m == pair.m && n == pair.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(m, n);
        }
    }
    public static long[] solution02_1(long n){
        long[] list = new long[2];
        List<Pair> numbers = new ArrayList<>();
        for(long i=2; i <n;i++){
            long t = (n % i == 0)? n/i : 0;
            if(t!= i && t != 0){
                if(!numbers.contains(new Pair(t,i)) && !numbers.contains(new Pair(i,t))){
                    numbers.add(new Pair(i,t));
                }
            }
        }
        for(Pair p : numbers){
            if(isPrime2(p.m) && isPrime2(p.n)){
                list[0] = p.m;
                list[1] = p.n;
                break;
            }
        }
        if(list[0] == 0) return new long[]{-1,-1};
        return list;
    }
    public static int dfs(long n, int cnt){
        if(cnt > 2){
            return cnt;
        }
        for(int i=2; i < n; i++) {
            if (n % i == 0) {
                long t = n / i;
                cnt = dfs(t, cnt + 1);
            }
        }
        return cnt;
    }
    private static boolean isPrime2(long n) {
        if(n < 2){
            return false;
        }
        for(int i=2; i < n; i++){
            if(n % i == 0 ){
                return false;
            }
        }
        return true;
    }

    private static void sol03() {
        int[][] board = {{3, 2, 3, 2},{2, 1, 1, 2},{1, 1, 2, 1},{4, 1, 1, 1}};
        int result = solution03(board);
        System.out.println(result);
    }
    static int[][] move = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static int max;
    static boolean[][] visited;
    static int h;
    static int w;
    public static int solution03(int[][] board){
        h = board.length;
        w = board[0].length;
        max = 0;
        visited = new boolean[h][w];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                dfs(board, visited, j, i ,0, board[i][j]);
            }
        }
        if(max == 0) return -1;
        return max;
    }
    static void dfs(int[][] board, boolean[][] visited, int x, int y,int depth, int before){
        // 사방으로 이동
        for(int d=0; d< move.length;d++){
            int ty = y + move[d][0];
            int tx = x + move[d][1];
            if(isValid(ty, tx) && !visited[ty][tx] && before == board[ty][tx]){
                visited[ty][tx] = true;
                dfs(board, visited, tx, ty, depth+1, board[ty][tx]);
                visited[ty][tx] = false;
            }
        }
        max = Math.max(max, depth);
        return;
    }
    static boolean isValid(int r, int c) {
        return r >= 0 && r < h && c >= 0 && c < w;
    }
}
