package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTrucks {
    public static void main(String[] args){
        int bridge_length= 100;
        int weight = 100;
        int[] truck_weights = {10};
        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucks = new LinkedList<>();
        for(int w : truck_weights){
            trucks.offer(w);
        }
        int timer = 1;
        while(!trucks.isEmpty()){
            int onBrige = bridge_length;
            while(onBrige >= 0){
                if(!trucks.isEmpty()) {
                    int current = trucks.poll();
                    onBrige--;
                    timer++;
                    if (!trucks.isEmpty()) {
                        if (trucks.peek() + current > weight) {
                            onBrige--;
                            timer++;
                            continue;
                        }
                    }
                }else {
                    onBrige--;
                    timer++;
                }
            }
        }
        return timer;
    }
}
