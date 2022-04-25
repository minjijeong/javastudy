package com.programmers;

public class BaseStationHan {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0; // 기지국 수
        int start = 1;
        int end;
        double cntNewStation;
        for (int station : stations) {
            end = station - w - 1;
            if (end < 1 || end < start) {
                start = station + w + 1;
                continue;
            }
            cntNewStation = (double) (end - start + 1) / (double) (2 * w + 1);
            start = station + w + 1;
            answer += Math.ceil(cntNewStation);
        }

        if (start <= n) {
            end = n;
            cntNewStation = (double) (end - start + 1) / (double) (2 * w + 1);
            answer += Math.ceil(cntNewStation);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(solution(16,arr,2));
    }
}
