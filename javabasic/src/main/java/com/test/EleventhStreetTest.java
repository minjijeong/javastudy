package com.test;

public class EleventhStreetTest {
    public static void main(String[] args){
//        test01(); // bug fix
        test02(); // algorithm
//        test03(); // sql test
    }

    private static void test03() {
/**
 * your task is to write an SQL query that, for each different length of experience, counts the number of candidate with precisely that amount of experince and how many of them got a perfect score in each category in which they were requested to solve tasks(so a NULL score is here treated as a perfect score.)
 */
        String sql = "select a.experience as exp"
                        + ", count (case when (a.sql = 100 or a.sql is null) "
                                        + "and (a.algo = 100 or a.algo is null) "
                                        + "and (a.bug_fixing = 100 or a.bug_fixing is null) "
                                        + "then 1 end) as max "
                        + ", count(a.id) as count "
                    + "from assessments a "
                   + "group by a.experience"
                    + "order by a.experience desc";
    }

    private static void test01() {
        String s = "BAOOLLNNOLOLGBAX";
        System.out.println(solution01(s));
    }

    // BALLOON을 String에서 몇개나 뺄수 있는지 return
    // b : 1, a :1 , L: 2, O : 2, N : 1
    public static int solution01(String S) {
        int[] frequencyCheck = new int[5]; // B,A,L,O,N

        for(char c : S.toCharArray()){
            if(c == 'B') frequencyCheck[0]++;
            if(c == 'A') frequencyCheck[1]++;
            if(c == 'L') frequencyCheck[2]++;
            if(c == 'O') frequencyCheck[3]++;
            if(c == 'N') frequencyCheck[4]++;
        }
        frequencyCheck[2] /= 2;
        frequencyCheck[3] /= 2;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<5;i++){
            min = Math.min(min, frequencyCheck[i]);
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }

    private static void test02() {
//        String s = "hello";
        String s = "lbllllaaabbbab";
        System.out.println(solution(s));
    }

    // incorrect code  - 4 lines less
    // most frequent letter
    static String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 0;

        // orgin - a를 미포함, 그리고 알파벳 순서가 먼저인애 최종 출력
//        for (int i = 1; i < 26; i++) {
        for (int i = 25; i >= 0; i--) {
            if (occurrences[i] >= best_res) {
                best_char = (char) ((int) 'a' + i);
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

}
