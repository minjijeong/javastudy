package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class BaseStationFail {
    static int baseCnt = 0;
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int empty = n;
        ArrayList<Integer> arrStations = (ArrayList<Integer>) Arrays.stream(stations).boxed().collect(Collectors.toList());
        int[] baseMap = getBasicMap(n,stations,w);
        for (int j = 0; j < arrStations.size(); j++) {
            int maxIdx = arrStations.get(j)+w-1;
            int minIdx = arrStations.get(j)-w-1;
            if(maxIdx >= n){
                maxIdx = n;
            }
            if(minIdx < 0){
                minIdx = 0;
            }
            int markCnt = 0;
            for(int i=minIdx;i <= maxIdx;i++){
                if(baseMap[i] == 0) {
                    baseMap[i] = 1;
                    markCnt++;
                }
            }
            if(markCnt > 0){
                arrStations.add(arrStations.get(j)+w-1);
                arrStations.add(arrStations.get(j)-w-1);
            }

        }
        ArrayList<Integer> arrList = (ArrayList<Integer>) Arrays.stream(baseMap).boxed().collect(Collectors.toList());
        System.out.println(arrList);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static int[] getBasicMap(int n, int[] stations, int w){
        int[] arr = new int[n];
        int empty = n;
        for (int j = 0; j < stations.length; j++) {
            int curIdx = stations[j]-1;
            arr[curIdx] = 2;
            int idx = curIdx;
            for (int i = idx + w; i >= idx - w; i--) {
                System.out.println(" i : "+i);
                if (i >= n || i == curIdx) {
                    continue;
                } else if (i <= 0) {
                    break;
                } else {
                    if(arr[i] == 0) {
                        empty--;
                        arr[i] = 1;
                        System.out.println(" i : " + i);
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(solution(16,arr,2));
    }
}