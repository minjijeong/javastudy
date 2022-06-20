package com.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class KthNumber {
    public static void main(String[] args){
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solution(arr, commands);
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands){
            int[] arr = new int[command[1] - command[0] + 1];
            int cidx = 0;
            for(int i=command[0]-1; i < command[1]; i++){
                arr[cidx] = array[i];
                cidx++;
            }
            Arrays.sort(arr);
            answer[idx] = arr[command[2]-1];
            idx++;
        }
        return answer;
    }
}
