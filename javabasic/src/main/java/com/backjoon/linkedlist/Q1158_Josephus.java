package com.backjoon.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Q1158_Josephus {
//public class Main {
    // (N,K)
    // N 명의 사람이 원을 이루고 앉고, K번째 사람을 제거하여 1명이 남을때 까지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rules = (br.readLine()).split(" ");
        br.close();

        int N = Integer.parseInt(rules[0]);
        int K = Integer.parseInt(rules[1]);

        List<Integer> ppl = new LinkedList<>();
        List<Integer> removePpl = new LinkedList<>();
        for (int i = 0; i < N; i++) ppl.add(i);

        int target = 0;
        while (ppl.size() >= 1) {
            target = (target+ K -1) % ppl.size();
            int current = ppl.remove(target);
            removePpl.add(current+1);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        int idx = 0;
        for(int people : removePpl){
            if(idx != 0) builder.append(", ");
            builder.append(people);
            idx++;
        }
        builder.append(">");
        System.out.println(builder.toString());
    }
}