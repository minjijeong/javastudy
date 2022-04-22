package com.javabasic;

import com.javabasic.others.HousePark;
import java.util.ArrayList;
import java.util.Arrays;

public class WikidocsExam05 {
    public static void main(String[] args) throws InterruptedException {
        /*
        // 01. import 오류 수정 - 패키지명만 변경
        HousePark housePark = new HousePark();
        System.out.println(housePark.getLastname());
        // import com.javabasic.others.HousePark;

        // 02. 다음 코드의 실행 결과를 예측하고 그 이유에 대해 설명하시오.
        // result = 10;
        int result = 0;
        try {
            int[] a = {1, 2, 3};
            int b = a[3]; // ArrayIndexOutOfBoundsException 날것이다.. 배열의 마지막이 a[2] 이므로
            ArrayList c = new ArrayList(Arrays.asList("3"));
            System.out.println(" c :: "+c);
            int d = (int) c.get(0);
            //int e = 4 / 0; // 이건 아예 돌아가질 않네..Fatal Error RuntimeException 먼저 떨어져 버리네...
        } catch (ClassCastException e) {
            result += 1;
        } catch (ArithmeticException e) {
            result += 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            result += 3;
        } finally {
            result += 4;
        }
        System.out.println(result); // result  = 10 - 원래는... ㅠ

        // 03. 스레드를 사용하여 work 메서드를 동시에 수행하면 시간을 단축해 보자
        // 스레드를 사용하여 동시에 시작하게 한 후 모든 쓰레드 종료되는 것을 기다려 로직처리
        // 계산 등에 도움이 될것 같음
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Thread t = new Thread(new HeavyWork("w" + i));
            threads.add(t);
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.printf("elapsed time:%s ms\n", end - start);
        */

        // 04. 함수형 프로그래밍을 사용하여 표현
        int[] numbers = {1, 2, 3, 4, 5};

        //ArrayList<Integer> temp = new ArrayList<>();
        //for (int num : numbers) {
        //    if (num % 2 == 1) {  // 홀수이면
        //        temp.add(num * 2);  // 2를 곱하여 temp에 담는다.
        //    }
        //}

        int[] result = Arrays.stream(numbers) // intStream을 생성
                .filter((a) -> a % 2 == 1) // 홀수인것 filter
                .map((a) -> a * 2) // 로직 처리
                .toArray() // 다시 배열로 변환
                ;

        // 05. 다음의 정수 배열에서 음수를 모두 제거해 보자.
        int[] numbersMinus = {1, -2, 3, -5, 8, -3};
        int[] resultMinus = Arrays.stream(numbersMinus)
                .filter((a) -> a >= 0)
                .toArray();
    }

}
