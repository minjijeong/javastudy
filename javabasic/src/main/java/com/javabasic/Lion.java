package com.javabasic;

public class Lion extends Predator implements Barkable {
        // Animal을 상속받은 추상클래스 Predator를 상속 받고
        // 짖는 기능은 Barkable 인터페이스를 통해 정의한다.
        public String getFood(){
            return "banana";
        }

        public String barkPredator(){
            return "Bark Bark!!";
        }

    @Override
    public void bark() {
        System.out.println("Barkable's bark()");
    }
}
