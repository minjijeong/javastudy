package com.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * reference :
 * https://www.freecodecamp.org/news/time-is-complex-but-priceless-f0abd015063c/#.j7h5s1m2p
 * https://programmers.co.kr/learn/courses/13577
 */
public class TimeComplexity {
    public static class Friend{
        String name;
        int age;
        boolean isFriend;
        Friend(String name, int age, boolean isFriend){
            this.name = name;
            this.isFriend = isFriend;
        }
    }
    public static void main(String[] args) {



        // O(1) — Constant Time
        getConstantTime();

        int[] arr = {2,3,4,5,7,8,11,223,23,21,32,44};

        // O(log n) — Logarithmic Time
        int sum = getLogarithmicTime(arr);
        System.out.printf(" O(log n) - sum : %d \n",sum);

        // O(n) — Linear Time
        int tot = getLinearTime(arr);
        System.out.printf(" O(n) - total : %d \n",tot);

        // O(n²) — Quadratic Time
        getQuadraticTime(arr);
        System.out.printf(" O(n²) - arr[] : %s \n", Arrays.toString(arr));
    }

    private static void getQuadraticTime(int[] n) {
        for(int i : n){
            for(int j : n){
                if(i < j){
                    int tmp = j;
                    j = i;
                    i = tmp;
                }
            }
        }
    }

    private static int getLogarithmicTime(int[] n) {
        int sum = 0;
        int max = n.length;

        while( max > 0){
            sum += n[max -1];
            max /= 2;
        }
        return max;
    }

    private static int getLinearTime(int[] n) {
        int s = 0;
        for(int i : n){
            s += i;
        }
        return s;
    }

    private static void getConstantTime() {
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Mark", 22, true));
        friends.add(new Friend("Amy", 24, true));
        friends.add(new Friend("Carl", 27, false));
        friends.add(new Friend("Ray", 29, true));
        friends.add(new Friend("Laura", 31, false));

        int cntFriends = 0;
        for(Friend friend : friends ){
            if(friend.isFriend){
                cntFriends++;
            }
        }

        System.out.printf("friends number : %d \n", cntFriends);
    }
}
