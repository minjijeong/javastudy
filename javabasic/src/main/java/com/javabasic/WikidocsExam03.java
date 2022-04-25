package com.javabasic;

import java.util.ArrayList;
import java.util.Arrays;

public class WikidocsExam03{

    public static void main(String [] args) {

        // 01. UpgradeCalculator 생성
        UpgradeCalculator cal = new UpgradeCalculator();
        cal.add(10);
        cal.minus(3);
        System.out.println(cal.getValue()); // 7 출력

        // 02. 객체변수 value가 100 이상의 값은 가질 수 없도록 제한하는 MaxLimitCalculator 클래스
        MaxLimitCalculator cal2 = new MaxLimitCalculator();
        cal2.add(50);  // 50 더하기
        cal2.add(60);  // 60 더하기
        System.out.println(cal2.getValue());  // 100 출력

        // 03. 홀수인지 짝수인지 판별해 주는 메서드(isOdd)를 추가
        boolean isOdd = cal2.isOdd();
        System.out.println(" 홀수 true, 짝수 false => "+ cal2.getValue() + " : " + isOdd);

        // 04. 정수 배열 또는 정수의 리스트 입력시 그 평균값을 구해 정수로 리턴하는 avg 메서드를 추가
        int[] data = {1, 3, 5, 7, 9};
        Calculator cal3 = new Calculator();
        int resultArr = cal3.avg(data);
        System.out.println(resultArr);  // 5 출력
        // 오버로딩하여 매개변수만 다르게 하여 동일로직 구현
        ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        int resultList = cal.avg(dataList);
        System.out.println(resultList);

        // 05. 리스트 형태 출력 결과 예측
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = a;
        a.add(4);
        System.out.println(b.size());
        // 4, b에 a에 할당된 객체 주소를 참조시키기 때문에 해당 객체 a에 숫자를 추가하여도 b에도 동일한 결과를 가르킨다.

        // 06. 객체 생성 후 오류 발생하는 이슈 해결
        Calculator calExcption = new Calculator();
        calExcption.addInteger(3);  // 여기서 NullPointerException 이 발생한다.
        System.out.println(calExcption.getValue());
        // Integer valueInteger를 별도로 선언하고 진행하였을 당시, 생성자에서 해당 값이 초기화 되지 않아서 발생한 이슈
        // valueInteger로 초기화 후 add 메소드 실행하였을 때 nullPointerException 발생안함

        // 07. 광물이 추가되더라도 MineralCalculator 클래스를 변경할 필요가 없도록 코드를 수정하시오.
        MineralCalculator calMineral = new MineralCalculator();
        calMineral.add(new Gold());
        calMineral.add(new Silver());
        calMineral.add(new Bronze());
        System.out.println(calMineral.getValue());  // 270 출력

        // 08. 오류나는 것 찾기 & 이유
        Animal aa = new Animal();  // 1번
        Animal bb = new Dog();  // 2번
        Predator cc = new Lion();  // 3번
        // Dog d = new Animal();  // 4번 오류발생 - 자식클래스 자료형은 부모클래스 객체를 가질 수 없다.
        Predator e = new Lion();  // 5번

        // 09. 오류나는 문장을 찾자
        Lion dd = new Lion();

        System.out.println(cc.hello());  // 1번
        System.out.println(cc.barkPredator());   // 2번 오류발생
        System.out.println(dd.hello());  // 3번
        System.out.println(dd.barkPredator());   // 4번
        System.out.println(e.hello());  // 5번 오류발생
        System.out.println(e.barkPredator());   // 6번
    }
}
