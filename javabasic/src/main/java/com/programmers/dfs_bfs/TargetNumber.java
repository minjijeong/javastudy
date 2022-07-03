package com.programmers.dfs_bfs;

public class TargetNumber {
    public static void main(String[] args){
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(nums, target);
        System.out.println(result);
    }

    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        // +, - 타겟 넘버 만들기
        int current = 0;
        int sum = 0;
        // 숫자조합, 현재 depth, 이전까지의 합, 최종 sum 타겟
        calculate(numbers, 0, 0, target);
        return answer;
    }

    public static void calculate(int[] numbers, int current,int sum ,int target){
        // depth 체크
        if(current >= numbers.length){
            // 목표 달성여부 확인
            if(sum == target){
                answer++;
            }
            return;
        }
        // 부호 - 인 경우
        calculate(numbers, current+1,sum + numbers[current] * (-1), target);
        // 부호 + 인 경우
        calculate(numbers, current+1,sum + numbers[current], target);
    }
}
