package com.javabasic;

abstract class Predator extends Animal{
        abstract String getFood(); // 추상클래스로 변경되며 메소드도 abstract으로 정의

        void printFood() { // 추상클래스 이므로 default 키워드 삭제
            System.out.printf("my food is %s\n", getFood());
        }

        static int LEG_COUNT = 4; // static 추가 선언

        static int speed(){
            return LEG_COUNT * 30;
        }

    public abstract String barkPredator();
}
