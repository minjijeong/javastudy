package com.javabasic;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "abc";
        String str4 = new String("abc");

        /**
         * str1, str3 는 같은 문자열을 선언하여 Heap 내의 constant poll 동일한 데이타를 가르킨다.
         * str2, str4 각각 객체를 선언하였기 때문에 서로 다른 객체이다.
         */
        System.out.println(System.identityHashCode(str1)); // 1078694789
        System.out.println(System.identityHashCode(str2)); // 1831932724
        System.out.println(System.identityHashCode(str3)); // 1078694789
        System.out.println(System.identityHashCode(str4)); // 1747585824
        System.out.println("-----------------------");
        String str5 = "abcdef";
        String str6 = str1 + "def";
        str1 = str1 + "def"; // str1의 "abc"는 GC 대상이 되고 "abc"+"def" 된 새로운 값을 가르킨다.
        /**
         * str1에 "def"를 추가하여도 str5와 같은 메모리를 가르키지 않는다.
         */
        System.out.println(System.identityHashCode(str1)); // 1023892928
        System.out.println(System.identityHashCode(str5)); // 558638686
        System.out.println(System.identityHashCode(str6)); // 1149319664

        System.out.println("-----------------------");
        /**
         * String - immutable, 객체 수정 안됨, 멀티쓰레드 safe
         * StringBuffer - mutable, 객체 수정 가능, 멀티쓰레드 safe, 동기화가능
         * StringBuilder - mutable, 객체 수정 가능, 단일쓰레드만 가능
         *
         * 연산이 많은 성능 측면 String Builder >> StringBuffer >> String
         */
        StringBuffer buffer = new StringBuffer();
        buffer.append("adc");
        System.out.println(System.identityHashCode(buffer)); // 2093631819
        buffer.append("def");
        System.out.println(System.identityHashCode(buffer)); // 2093631819

        StringBuilder builder = new StringBuilder();
        builder.append("adc");
        System.out.println(System.identityHashCode(builder)); // 2074407503
        builder.append("def");
        System.out.println(System.identityHashCode(builder)); // 2074407503
    }
}
