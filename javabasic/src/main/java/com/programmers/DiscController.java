package com.programmers;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class DiscController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {0, 3},{3, 2},{1, 9}, {2, 6},{0, 7},{1, 9}};
        int result = solution(jobs);
        System.out.println(result);
    }
    public static class Task{
        int inTime;
        int spendTime;
        public Task(int inTime, int spendTime){
            this.inTime = inTime;
            this.spendTime = spendTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Task task = (Task) o;
            return inTime == task.inTime && spendTime == task.spendTime;
        }

        @Override
        public int hashCode() {
            return Objects.hash(inTime, spendTime);
        }
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count =0; //수행된 요청 갯수

        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> o1[1] - o2[1]);

        // 요청이 모두 수행될 때까지 반복
        while(count < jobs.length){

            // 하나의 작업이 오나료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                pq.add(jobs[jobsIdx++]);
            }

            // 큐가 비어 있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
            if(pq.isEmpty()){
                end = jobs[jobsIdx][0];
            }
            else{ // 작업이 끝나기 전, 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int) Math.floor(answer/jobs.length);
    }
}
