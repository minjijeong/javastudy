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
        calculate(numbers, 0, 0, target);
        return answer;
    }

    public static void calculate(int[] numbers, int current,int sum ,int target){
        if(current >= numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        // 이번항 sum
        calculate(numbers, current+1,sum + numbers[current] * (-1), target);
        calculate(numbers, current+1,sum + numbers[current], target);
    }
}
