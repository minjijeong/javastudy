package com.programmers.dfs_bfs;

public class ConversionWords {
    public static void main(String[] args){
        String b = "hit";
        String t = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution2(b,t,words);
        System.out.println(result);
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        if(!words[words.length-1].equals(target)){
            return answer;
        }
        dfs(words, visited, 0, begin, 0, target);
        for(boolean b : visited) if(b) answer++;
        return answer;
    }
    public static boolean[] dfs(String[] words, boolean[] visited, int i, String before, int common, String target){
        if(common == target.length() || i >= target.length()){
            return visited;
        }
        int cnt = 0;
        // 타겟과 비교
        for(int j=0; j < words[i].length();j++){
            if(target.charAt(j) == words[i].charAt(j)) cnt++;
        }
        if(cnt >= target.length()-1 && target.equals(words[words.length-1])){
            visited[i] = true;
            visited[words.length-1] = true;
            return visited;
        }
        // 다음 항목과 비교
        cnt = 0;
        for(int j=0; j < words[i].length();j++){
            if(before.charAt(j) == words[i].charAt(j)) cnt++;
        }
        if(cnt >= common){
            visited[i] = true;
            visited = dfs(words, visited, i+1, words[i], cnt, target);
        }
        return visited;
    }
    static int answer;
    static boolean[] visited;
    public static int solution2(String begin, String target, String[] words){
        answer = 51;
        visited = new boolean[words.length];
        // target Arrays에 미존재시 return 0;
        dfs(begin, target, words, 0);
        // 맨 끝에 타겟과 동일한게 안 위치할수 잇음
//        if(!words[words.length-1].equals(target)) return 0;
        if(answer == 51) return 0;
        return answer;
    }

    private static void dfs(String begin, String target, String[] words, int depth) {
        // 타겟과 동일할때
        if(target.equals(begin)){
            answer = Math.min(answer, depth);
            return;
        }

        for(int j=0; j < words.length; j++){
            if(!visited[j] && check(begin,words[j])){
                visited[j] = true;
                dfs(words[j], target, words, depth + 1);
                visited[j] = false;
            }
        }
    }

    private static boolean check(String begin, String target) {
        int cnt = 0;
        for(int i=0; i < begin.length();i++){
            if(begin.charAt(i) == target.charAt(i)){
                cnt++;
            }
        }
        if(cnt == begin.length()-1){
            return true;
        }
        return false;
    }
}
