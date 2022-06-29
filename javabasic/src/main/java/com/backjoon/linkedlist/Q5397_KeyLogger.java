package com.backjoon.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q5397_KeyLogger {
//public class Main {
    // 알파벳 대문자, 소문자, 숫자, 백스페이스('-'), 화살표
    // 테스트 케이스
    // 백스페이스 입력시 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다
    // 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // test 케이스 개수
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        for(int i=0; i <N;i++) {
            strs[i] = br.readLine();
        }
        br.close();

        for(String str : strs){
            List<Character> chars  = new LinkedList<>();

            int curIdx = 0;
            for(char c : str.toCharArray()) {
                // 백스페이스('-')
                if (c == '-') {
                    if (curIdx > 0)
                        chars.remove(--curIdx);
                } else if (c == '<') {
                    if (curIdx > 0) {
                        curIdx--;
                    }
                } else if (c == '>') {
                    if (chars.size() > curIdx) {
                        curIdx++;
                    }
                } else {
                    chars.add(curIdx, c);
                    curIdx++;
                }
                // 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.
            }
            // char -> String을 합치기
            System.out.println(chars.stream().map(String::valueOf).collect(Collectors.joining()));
        }
    }
}
