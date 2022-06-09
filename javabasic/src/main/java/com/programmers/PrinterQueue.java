package com.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class PrinterQueue {
    static class Print implements Comparable<Print>{
        private int id;
        private int priority;

        private boolean isMaxAfter;
        public Print(int id, int priority, Boolean isMaxAfter){
            this.id = id;
            this.priority = priority;
            this.isMaxAfter = isMaxAfter;
        }
        @Override
        public int compareTo(Print o) {
            if(o.priority == this.priority) {
                return Boolean.compare(o.isMaxAfter, this.isMaxAfter);
            }
            else{
                return o.priority - this.priority;
            }
        }
    }
    public static void main (String[] args){
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int result = solution(priorities, location);
        System.out.println(result);
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int p : priorities){
            pq.offer(p);
        }
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return  -1;

    }
}
