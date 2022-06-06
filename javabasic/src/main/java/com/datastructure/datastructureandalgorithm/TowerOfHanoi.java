package com.datastructure.datastructureandalgorithm;

/**
 * 재귀 - 하노이의 탑
 */
public class TowerOfHanoi {
    public static void main(String[] args){
        towerofHanoi(10,'A','C', 'B');
    }


    private static void towerofHanoi(int n, char frompeg, char topeg, char auxpeg){
        /* 원반이 하나이면 옮기고 리턴한다. */
        if(n == 1){
            System.out.println("Move disk 1 from peg - " + frompeg + " - to peg " +topeg );
            return;
        }

        /* 앞의 n-1 개 원반을 C를 보조탑으로 이용해서 A에서 B로 옮긴다. */
        towerofHanoi(n-1, frompeg, auxpeg, topeg);

        /* 나머지 원반을 A에서 C로 옮긴다. */
        System.out.println("Move disk from peg" +frompeg + " to peg "+topeg);

        /* n-1개 원반을 A를 보조탑으로 이용해서 B에서 C로 옮긴다. */
        towerofHanoi(n-1, auxpeg, topeg, frompeg);
    }
}
