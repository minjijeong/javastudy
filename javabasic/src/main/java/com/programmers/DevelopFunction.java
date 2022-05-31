package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DevelopFunction {
    public static void main(String[] args) {
        int[] progresses = {10,10,10,10};
        int[] speeds = {20,15, 13,17};
//        int[] result = solution(progresses, speeds);
        int[] result = solution2(progresses,speeds);
        System.out.println(Arrays.toString(result)); // 2,1
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> taskSche = new ArrayList<>();

        /**
         * 나눗셈 연산 주의
         * 정확한 연산을 위해서는 int형이 아닌 double 형으로 나누어 주어야 함.
         * 100 / 30.0
         */
        double beforeDay = Math.ceil((100 - progresses[0]) / (double) speeds[0]);
        int taskCnt = 1;
        for (int i = 1; i < progresses.length; i++) {
            double spendDay = Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            if (beforeDay >= spendDay) {
                taskCnt++;
            }
            if (beforeDay < spendDay) {
                beforeDay = spendDay;
                taskSche.add(taskCnt);
                taskCnt = 1;
            }

            if ((i == progresses.length - 1)) {
                taskSche.add(taskCnt);
            }
        }
        return taskSche.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution2(int[] progresses, int[] speeds){
        Queue<Double> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i< progresses.length;i++) queue.add(Math.ceil((100-progresses[i])/(double) speeds[i]));
        int dayCnt = 1;
        double before = queue.poll();
        while(!queue.isEmpty()){
            double now = queue.poll();
            if (before < now) {
                before = now;
                answer.add(dayCnt);
                dayCnt = 1;
            } else {
                dayCnt++;
            }
            if(queue.isEmpty() && dayCnt > 0){
                answer.add(dayCnt);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
