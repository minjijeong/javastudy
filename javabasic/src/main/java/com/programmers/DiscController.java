package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiscController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int result = solution(jobs);
        System.out.println(result);
    }
    public static class Task{
        int in;
        int spend;
        private Task task;

        Task(int in, int spend){
            this.in = in;
            this.spend = spend;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Task task1 = (Task) o;
            return in == task1.in && spend == task1.spend && Objects.equals(task, task1.task);
        }

        @Override
        public int hashCode() {
            return Objects.hash(in, spend, task);
        }
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        for(int i=0;i< jobs.length;i++){
            queue.offer(jobs[i]);
        }

        int count = 0;
        int loc = 0;
        while(count >= jobs.length) {
            // 넣고 난다음 것들 추가

        }



        return  answer;
    }
}
