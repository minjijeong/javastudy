package com.programmers.greedy;

public class JoyStick {
    public static void main(String[] args){
        String name = "ZZAAABBBB";
        int result = solution(name);
        System.out.println(result);
        result = solution2(name);
        System.out.println(result);
    }

    /**
     * 상 - 다음
     * 하 - 이전
     * 왼쪽 - 첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서
     * 오른쪽 - 마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서
     */
    public static int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length() -1;
        for(int i=0; i < name.length();i++) {
            // n번째 알파벳 찾기
            int ch = name.charAt(i);
            answer += Math.min(ch-'A','Z'-ch +1);

            index = i + 1;
            // A가 연속되는 경우
            while(index < name.length() && name.charAt(index) == 'A'){
                index++;
            }
            move = Math.min(move, i*2 + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);

        }
        return answer + move;
    }

    public static int solution2(String name){
        int answer = 0;
        int start;
        int move = name.length();
        int length = name.length();
        for(int i=0; i < name.length();i++){
            // 문자열 연산
            char c = name.charAt(i);
            answer += Math.min(c-'A', 'Z'-c+1);
            start = i + 1;
            // A연달아 존재
            while(start < length && name.charAt(start) == 'A'){
                start++;
            }
            move = Math.min(move, i*2 + length - start);
            move = Math.min(move, (length - start) * 2 +i);
        }
        return answer + move;
    }
}
