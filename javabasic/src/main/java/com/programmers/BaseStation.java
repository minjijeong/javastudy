package com.programmers;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 프로그래머스 - 기지국 문제
 * https://programmers.co.kr/learn/courses/30/lessons/12979
 */
class BaseStation {
    static int baseCnt = 0;
    public static int solution(int n, int[] stations, int w) {
        int answer = 0; // 기지국 수

        Queue<Integer> sq = new LinkedList<>();
        for(int s : stations) {
            sq.offer(s); // 현재 기지국이 설치된 아파트 추가
        }

        int position = 1; // 아파트 1동부터 끝까지
        while(position <= n){ // 동 전체 돌면서
            // 기존에 설치된 기지국이 있으면, 현재 위치가 기지국 범위안에 들어오는지
            // 들어간다면 기존 기준 기지국 다음 기지국을 비교해야하므로 poll 하여 제거
            // 위치는 기존 기지국 + w 만큼 이동
            if(!sq.isEmpty() && position >= sq.peek() - w){
                position = sq.poll() + w + 1;
            }
            else{
                // 기지국 범위에 안에 없기때문에 기지국 설치
                // 새로 위치 이동 2w + 1
                answer += 1;
                position += (w*2) + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(solution(16,arr,2));
    }
}