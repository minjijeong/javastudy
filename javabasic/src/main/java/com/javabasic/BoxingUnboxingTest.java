package com.javabasic;

public class BoxingUnboxingTest {
    public static void main(String[] args) {
        Integer iA = new Integer(123);
        Integer iB = new Integer(123);
        int ia = (int)iA; //(1) 언박싱(unboxing)
        int ib = iB; //(2) 오토언박싱(auto unboxing)
        Integer iC = (Integer)456; //(3)박싱(boxing)
        Integer iD = ia; //(4)오토 박싱(auto boxing)

        /**
         * boxing and unboxing이 중요한 이유
         * 1. 식별성
         * iA == iB => false, ia == ib => true
         * Integer로 박싱이 되면, 각각의 객체는 서로 다르기때문에 비교연산자를 사용하면 두 객체의 값을 비교하는 것이 아니라 객체 자체를 비교
         * equals로 변경하여 비교되어야 한다.
         *
         * 2. reference 타입은 null을 가질수 있다.
         * 연산시 null check 필요할수 있다.
         *
         * 3. 속도, 메모리 효율성
         * 타입별 평균적인 접근시간은 원시타입이 참조타입보다 적게 걸린다.
         */
        if(iA==iB){
            System.out.println("iA와 iB는 산술연산자 기준 같다");
        }else{
            System.out.println("iA와 iB는 산술연산자 기준 다르다");
        }

        if(iA.equals(iB)){
            System.out.println("iA와 iB는 객체의 값 기준 같다");
        }else{
            System.out.println("iA와 iB는 객체의 값 기준 다르다");
        }

        // NullPointerException Test
//        Integer n = null;
//        int b = 10;
//        if(n == b){
//            System.out.println("source is working");
//        }else{
//            System.out.println("n != b");
//        }

        long start = 0;
        long end = 0;

        //primitive type
        start = System.currentTimeMillis();
        fibonacci1(30);
        end = System.currentTimeMillis();
        System.out.println("int를 이용한 피보나치 연산::" + (end - start));
        //Wrapper Class
        start = System.currentTimeMillis();
        fibonacci2(30);
        end = System.currentTimeMillis();
        System.out.println("Integer를 이용한 피보나치 연산::" + (end - start));
    }

        public static int fibonacci1(int value) {
            if (value == 0 || value == 1)
                return 1;
            else
                return fibonacci1(value - 1) + fibonacci1(value - 2);
        }
        public static Integer fibonacci2(int value) {
            if (value == 0 || value == 1)
                return 1;
            else
                return fibonacci2(value - 1) + fibonacci2(value - 2);
        }
}

