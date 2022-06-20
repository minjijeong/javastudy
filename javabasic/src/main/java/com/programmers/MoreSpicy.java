package com.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MoreSpicy {
    public static void main(String[] args){
        int[] scoville = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1, 2, 3, 9, 10, 12,1000000000};
        int k = 10000000;
        int result = solution(scoville,k);
        System.out.println(result);
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) queue.offer(s);

        while (queue.peek() <= K){
            if(queue.size() == 1){
                return -1;
            }
            // mix
            int s1 = queue.poll();
            int s2 = queue.poll();
            queue.offer(s1 + (2 * s2));
            answer++;
        }
        return answer;
    }
}
