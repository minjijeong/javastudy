package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class SocarTest {
    public static void main (String[] args){
//        test01();
        test02();
    }

    private static void test02() {
        // 중복없음
        int[] numbers = {10, 40, 30, 20};
        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k = 20;
        int k2 = 3;
        int result = solution02_1(numbers, k);
        System.out.println(result);
        result = solution02_1(numbers2,k2);
        System.out.println(result);
    }
    public static int solution02(int[] numbers, int k){
        int answer = 0;
        // 서로 인접한 차가 K이하, swap의 횟수
        List<Integer> list = new LinkedList<>();
        PriorityQueue<int[]> issues = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
            if(Math.abs(numbers[i]-numbers[i+1]) > k){
                issues.add(new int[]{i,numbers[i]});
            }
        }

        int idx = 0;
        while(!issues.isEmpty()){
            int[] current = issues.poll();
            // 값 변경 가능한 곳 찾기
            for(int i=numbers.length-1;i >= 0;i--){
                if(i!= current[0]){
                    int temp = numbers[i];
                    numbers[i] = current[1];
                    numbers[current[0]] = temp;
                    int chkCnt = 0;
                    if(i==numbers.length-1){

                    }
                    else {
                        if (Math.abs(numbers[i] - numbers[i + 1]) > k) {

                        }
                    }
                }
            }
        }
        return  answer;
    }

    static Queue<int[]> issues = new LinkedList<>();
    int minCnt = Integer.MIN_VALUE;
    static int[] temp;
    static int diff;
    public static int solution02_1(int[] numbers, int k){
        int cnt = 0;
        int idx = 0;
        temp = numbers.clone();
        diff = k;

        // 1번 부터 시작
        // 뒤에꺼 비교 차이가 나
        // 둘이 바꾸면 나머지 차이 나는 애 있어?
        // 남은거 바꿔봐 차이나는애 있어?
        // 없으면 cnt return

        // 그중에 min 을 찾자
        for(int i=1; i< numbers.length; i++) {
            if(Math.abs(numbers[i-1] - numbers[i]) > k) {
                issues.add(new int[]{i,numbers[i]});
            }
        }
        while(!issues.isEmpty()){
            int[] issue = issues.poll();
            idx = (issue[0] != 0 ? 0 : 1);
            if(searchError(temp,issue[0],issue[0])){
                continue;
            }
            int upper = issue[0]+2;
            int down = issue[0]-2;
            while(upper < temp.length || down >= 0) {
                boolean noError = false;
                if (upper < temp.length) {
                    if(searchError(temp,issue[0],upper) && searchError(temp,upper,issue[0])){
                        noError = true;
                    }
                    else{
                        noError = false;
                    }
                    if(noError){
                        swap(temp, issue[0], upper);
                        cnt++;
                    }
                }
                if (down >= 0) {
                    if(searchError(temp,issue[0],down) && searchError(temp,down,issue[0])){
                        noError = true;
                        idx = down;
                    }
                    else{
                        noError = false;
                    }
                    if(noError){
                        swap(temp, issue[0], down);
                        cnt++;
                    }
                }
                down--;
                upper++;
            }
        }

        return cnt;
    }
    public static void swap (int[] temp,int idx, int target){
        int tmp = temp[idx];
        temp[idx] = temp[target];
        temp[target] = tmp;
    }

    public static boolean searchError(int[] temp, int idx, int target){
        boolean NoError = true;
        if(target < temp.length-1) {
            if (Math.abs(temp[idx] - temp[target + 1]) > diff) {
                NoError = false;
            }
            else{
                NoError = true;
            }
        }
        if(target > 0) {
            if (Math.abs(temp[idx] - temp[target - 1]) > diff) {
                NoError = false;
            }
            else {
                NoError = true;
            }
        }
        return NoError;
    }

    private static void test01() {
        String s1 = "[]([[]){}";
        String s2 = "{([()]))}";
        String s3 = "(()()()";
        int result = solution01(s1);
        System.out.println(result);
        result = solution01(s2);
        System.out.println(result);
        result = solution01(s3);
        System.out.println(result);
    }
    public static int solution01(String s){
        int answer = 0;
        Queue<Character> error = new LinkedList<>();
        List<Character> chars = new LinkedList<>();
        String typeL = "[({";
        String typeR = "])}";

        char[] types = {'[', ']', '(', ')', '{', '}'};
        Map<Character,Character> map = new TreeMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        int x = 0;
        int y = 0;
        int z = 0;
        for(char c: s.toCharArray()){
            chars.add(c);
            switch (c){
                case '[' : x++;
                break;
                case ']' : x--;
                    break;
                case '(' : y++;
                    break;
                case ')' : y--;
                    break;
                case '{' : z++;
                    break;
                case '}' : z--;
                    break;
            }
        }
        if(x != 0){
            error.offer(x < 0 ? '[' : ']');
        }
        if(y != 0){
            error.offer(y < 0 ? '(' : ')');
        }
        if(z != 0){
            error.offer(z < 0 ? '{' : '}');
        }
        int cnt = 0;

        Stack<Character> total = new Stack<>();
        while(!error.isEmpty()){
            char err = error.poll();
            char target = map.get(err);
            int idx = 1;
            total.push(chars.get(0));
            while(!total.isEmpty() && idx < chars.size()){
                char current = chars.get(idx);
                if(total.isEmpty()){
                    total.push(current);
                    idx++;
                    continue;
                }
                if(typeL.contains(String.valueOf(current))){
                    total.push(current);
                }else{
                    char popChar = total.lastElement();
                    if(map.get(current) == popChar){
                        total.pop();
                    }
                    else if(popChar == target){
                        cnt++;
                        break;
                    }
                    else{
                        total.push(current);
                    }
                    if(total.size() == 1 && total.peek() == err){
                        cnt++;
                    }
                    if(total.size() == 0 && idx < chars.size()){
                        total.push(chars.get(idx+1));
                    }
                }
                idx++;
            }
        }
        return  cnt;
    }
}
