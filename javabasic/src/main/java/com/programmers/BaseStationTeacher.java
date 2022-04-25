package com.programmers;

/**
 * 프로그래머스 - 기지국 문제
 * https://programmers.co.kr/learn/courses/30/lessons/12979
 */
class BaseStationTeacher {
    static int baseCnt = 0;
    public static int solution(int n, int[] stations, int w) {
        int answer = 0; // 기지국 수

        // Primitive 타입을 사용하는 것이 Object 보다 빠르다.
        /*
        Queue<Integer> sq = new LinkedList<>();
        for(int s: stations) {
            sq.offer(s); // Queue에서 offset 사용시 오류가 납니다.
        }
         */
        // primitive 타입을 위해 idx 선언
        int stationIdx = 0;
        int position = 1;
        // 루프 부분 다 안돌고 처리 할 수 있는지 확인
        while(position <= n) {
            //if( position >= sq.peek() - w ){
            if(stationIdx < stations.length && stations[stationIdx] - w <= position){
                // 전파범위 왼쪽 끝
                //position = sq.poll() + w + 1; // 전파범위의 오른쪽으로 이동
                position = stations[stationIdx] + w + 1;
            } else{
                answer += 1;
                position += w * 2 + 1;  // 전체 전파범위
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(solution(16,arr,2));
    }
}