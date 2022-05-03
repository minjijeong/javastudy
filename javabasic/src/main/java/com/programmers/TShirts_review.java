package com.programmers;

/**
 * 한 사람당 티셔츠를 최대 하나씩 줍니다.
 * 모든 참가자는 자신의 상의 크기와 같거나 큰 티셔츠를 받습니다.
 */
public class TShirts_review {

    public static int solution(int[] people, int[] tshirts) {

        int answer = 0;

        int[] tCounting = new int[1000]; // 티셔츠 크기 1~ 1000
        int[] pCounting = new int[1000];

        // 셔츠 크기에 따라 사람 수
        for(int i = 0 ; i < people.length ; i++){
            pCounting[people[i] - 1] ++;
        }

        // 셔츠 크기에 따라 티셔츠 카운팅 추가
        for(int i = 0 ; i < tshirts.length; i++){
            tCounting[tshirts[i] - 1] ++;
        }

        for(int i = 0 ; i < tCounting.length ; i++) {

            if(tCounting[i] >= pCounting[i]){
                answer += pCounting[i];
            }
            else{
                answer += tCounting[i];

                if( i < tCounting.length - 1){
                    pCounting[i + 1] += pCounting[i] - tCounting[i];
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
//       int[] people = {2,3};
//       int[] tshirts = {1,2,3};
        int[] people = {1,2,3};
        int[] tshirts = {1,1};
       System.out.println(solution(people, tshirts));
    }
}
