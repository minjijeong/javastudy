package com.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import sun.awt.image.ImageWatched.Link;

/**
 * Stack :  LIFO (Last In First Out) 제일 늦게 들어간 놈이 제일 먼저 나온다.
 * - List 에서 마지막 index의 데이타를 제거와 동일한 로직
 * - Class 형태로 존재 Vector를 상속받았다.
 * - push, pop
 * - peek 조회
 *
 * Queue : FIFO ( First In First Out) 제일 먼저 들어간 놈이 제일 먼저 나온다.
 * - List 에서 처음 index의 데이터를 제거
 * - Interface로 구현
 * - offer / poll
 * - peek 조회
 *
 * Deque : 앞/뒤로 꺼낼 수 있다. (양방향)
 * - offerFirst, pollFirst 처음추가, 처음꺼내기
 * - offerLast, pollLastt 마지막추가, 마지막꺼내기
 * - Interface로 구현 - LinkedList
 */
public class StackQueuePractice {
    public static void main(String[] args) {
//        stckQueueConception();
//        rightBracket();
//        develop();
//        stockPrice();
        printer();
    }

    /**
     * case 1
     */
    // 2, 1, (3), 2
    // 2 [1, (3), 2]
    // 1 [ (3), 2, 2]
    // (3) [ 2, 2, 1] // 1
    /**
     * case 2
     */
    // (1), 1, 9, 1, 1, 1
    // 1[ 9, 1, 1, 1, (1)]
    // 9 [1,1,1,(1),1] // 9출력
    // 1 [1,1,(1),1] // 1출력
    // 1 [1,(1),1] // 1출력
    // 1 [ (1), 1] // 1출력
    // (1) [1] // 1출력
    private static void printer() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int result = solution04(priorities, location);
        System.out.println(result);
    }

    public static class Paper{
        boolean isMine;
        int priority;
        Paper(int p, boolean m){ priority = p; isMine = m;}
    }
    private static int solution04(int[] priorities, int location) {
        List<Paper> queue = new LinkedList<>();
        for(int i=0; i<priorities.length;i++){
            queue.add(new Paper(priorities[i], i == location));
        }
        int answer = 0;
        while(!queue.isEmpty()) {
            Paper now = queue.remove(0);
            boolean printable = true;
            for (Paper p : queue) {
                if (now.priority < p.priority) {
                    printable = false;
                    break;
                }
            }

            if (!printable) {
                queue.add(now);
                continue;
            }
            answer++;
            if(now.isMine) return answer;
        }
        return answer;
    }

    private static void stockPrice() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution03(prices);
    }

    private static int[] solution03(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
//                System.out.printf("i : %d, j : %d \n",prices[i],prices[j]);
                answer[i]++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static void develop() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = solution02(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution02(int[] progresses, int[] speeds) {
        Queue<Integer> tDays = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            // 배포가능 일자 계산하여 저장
            int days = (int) Math.ceil(((double)100 - progresses[i])/speeds[i]);
            tDays.offer(days);
        }
        Queue<Integer> answer = new LinkedList<>();
        int count = 1;
        int d = tDays.poll();
        while(!tDays.isEmpty()){
            int n = tDays.poll();
            if( d >= n){
                count++;
                continue;
            }
            d = n;
            answer.offer(count);
            count = 1;
        }
        answer.offer(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void rightBracket() {
        String s = "()()";
        String s1 = "(()))(";
        String s2 = "(()(";
        System.out.printf("s : %b, s1 : %b, s2 : %b \n", solution01(s), solution01(s1), solution01(s2));
    }

    static boolean solution01(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> right = new Stack<>();
        for(int i=0; i <chars.length;i++){
            if(chars[i] == '('){
                right.push(chars[i]);
                continue;
            }
            if(right.size() <= 0){
                return false;
            }
            char left = right.pop();
        }

        return right.isEmpty() == true;
    }

    private static void stckQueueConception() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);
        System.out.println(list.remove(0));

        /**
         * Queue (FIFO)
         */
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue); //[1, 2, 3]
        queue.poll();
        System.out.println(queue); //[2, 3]
        queue.poll();
        System.out.println(queue); //[3]
        System.out.println(queue.peek()); //3
        System.out.println(queue); //[3]

        /**
         * Stack (LIFO)
         */
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); //[1, 2, 3]

        stack.pop();
        System.out.println(stack); //[1, 2]
        stack.pop();
        System.out.println(stack); //[1]
        System.out.println(stack.peek()); //1

        /**
         * Deque (양방향 데이터 추출 및 추가)
         */
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerLast(2);
        System.out.println(deque); //[1, 2]
        deque.offerFirst(3);
        deque.offerLast(4);
        System.out.println(deque); //[3, 1, 2, 4]

        deque.pollFirst();
        System.out.println(deque); //[1, 2, 4]
        deque.pollLast();
        System.out.println(deque); //[1, 2]

    }
}
