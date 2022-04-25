package com.javabasic;

public class WikidocsExam02 {
    /**
     * 04장 제어문 - 연습문제
     * https://wikidocs.net/157996
     */
    public static void main(String [] args) {
        // 01.
        String a = "write once, run anywhere";
        if (a.contains("wife")) {
            System.out.println("wife");
        } else if (a.contains("once") && !a.contains("run")) {
            System.out.println("once");
        } else if (!a.contains("everywhere")) {
            System.out.println("everywhere");
        } else if (a.contains("anywhere")) {
            System.out.println("anywhere");
        } else {
            System.out.println("none");
        }
        // 출력 everywhere

        //02.while문을 사용해 1부터 1000까지의 자연수 중 3의 배수의 합을 구해 보자.
        int num = 0;
        int sum = 0;
        while(num < 1000){
            num++;
            if(num % 3 == 0){
                sum += num;
            }
        }
        System.out.println(" sum :: "+sum);

        //03. while문 또는 for 문을 사용하여 다음과 같이 별(*)을 표시하는 프로그램을 작성해 보자.
        int cnt = 0;
        while(cnt < 5){
            cnt++;
            for(int i=0;i<cnt;i++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

        //04.for문을 사용해 1부터 100까지의 숫자를 출력해 보자.
        for(int i = 1; i<=100;i++){
            System.out.println(i);
        }

        //05.for each 문을 사용하여 A 학급의 평균 점수를 구해 보자.
        int[] marks = {70, 60, 55, 75, 95, 90, 80, 80, 85, 100};
        int tot = 0;
        for(int mark : marks){
            tot += mark;
        }
        System.out.println(" averge :: "+tot/marks.length);
    }
}
