package com.datastructure;

public class DataType {

    public static void main(String[] args) {
//        getPrimitiveDataType();
//        getReferenceDataTypeString();
//        getReferenceDataTypeClass();
//        callbyvalue();
        callbyReference();
    }

    public static void getPrimitiveDataType(){
        // primitive 변수 선언
        short s = 32767; // -32,768 ~ 32,767
        int i = 2147483647; // -2,147,483,648 ~ 2,147,483,647
        long l = 9223372036854775807l; // -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        float f = 20.001f; // 4byte ±(1.40129846432481707e-45 ~ 3.40282346638528860e+38)
        double dl = 300.223f; // 8byte ±(4.94065645841246544e-324d ~ 1.79769313486231570e+308d)
        char ch = 'A'; // 2byte 모든 유니코드
        boolean bl = true; // true, false
        byte b = 5; // -128 ~ 127

        // primitive 메모리 할당
        System.out.println(b);
        System.out.println(System.identityHashCode(b)); //1078694789
        // primitive 변수들은 새로운 값을 넣으면 새롭게 저장한다.
        b = (byte) (b * 2);
        System.out.println(b);
        System.out.println(System.identityHashCode(b)); //1831932724
    }

    public static void getReferenceDataTypeString(){
        // Reference
        // Object를 상속받아 구현되는 모든 클래스
        String str = "Hello";
        System.out.println(str);// Hello
        System.out.println(System.identityHashCode(str)); //1747585824

        // 기존 str 스트링 객체를 참고하기 때문에 메모리 주속 동일
        String str2 = str;
        System.out.println(str2);// Hello
        System.out.println(System.identityHashCode(str2)); //1747585824

        // 새로운 값을 할당하면 새로운 객체를 생성하여 메모리 주소가 변경된다.
        // String 으로 선언할때 값 변경이 많은 경우는 이러한 이유때문에 StringBuilder 또는 StringBuffer를 사용한다.
        str += "World";
        System.out.println(str);// HelloWorld
        System.out.println(System.identityHashCode(str)); //1023892928

        // str2로 할당처리 된 후 변경되었기때문에 이전의 str2는 기존의 str을 가르킨다.
        System.out.println(str2);
        System.out.println(System.identityHashCode(str2)); //1078694789
    }

    public static void getReferenceDataTypeClass(){
        // ex01 객체 생성
        DataTypeEx ex01 = new DataTypeEx();
        System.out.println(ex01);// com.datastructure.DataType$DataTypeEx@404b9385
        System.out.println(System.identityHashCode(ex01)); //1078694789

        // ex01에서 생성된 객체를 참조만 한다.
        // 메모리 주소 동일
        DataTypeEx ex02 = ex01;
        System.out.println(ex02);// com.datastructure.DataType$DataTypeEx@404b9385
        System.out.println(System.identityHashCode(ex02)); //1078694789

        // ex01에 새로운 객체 생성
        // 신규 메모리 주소 할당
        ex01 = new DataTypeEx();
        System.out.println(ex01);// com.datastructure.DataType$DataTypeEx@6d311334
        System.out.println(System.identityHashCode(ex01)); //1831932724

        // ex01이 새로운 객체를 생성하여도 다시 ex02에 부여하지 않았기때문에
        // ex01 이전 객체를 참조한다.
        System.out.println(ex02);// com.datastructure.DataType$DataTypeEx@404b9385
        System.out.println(System.identityHashCode(ex02)); //1078694789

    }

    public static class DataTypeEx{
        String typeName;
        int address;
    }

    public static void callbyReference(){
        // 객체 생성
        DataTypeEx ex = new DataTypeEx();
        ex.typeName = "DataTypeEx";
        ex.address = System.identityHashCode(ex);
        System.out.println(ex.typeName); //DataTypeEx
        System.out.println(System.identityHashCode(ex)); //1078694789

        // 메소드 처리
        method(ex);

        // 객체 불러오기
        // 레퍼런스 주소로 불러오기 때문에 변경사항이 있으면 그대로 불러옴
        System.out.println(ex.typeName); //DataTypeEx2
        System.out.println(System.identityHashCode(ex)); //1078694789
    }
    private static void method(DataTypeEx ex) {
        // 객체 내의 변수 값 변경
        ex.typeName = "DataTypeEx2";
        // 객체 내의 변수 값은 변경되고, 주소는 그대로 유지
        System.out.println(ex.typeName); //DataTypeEx2
        System.out.println(System.identityHashCode(ex)); //1078694789

        // 신규 객체 생성
        ex = new DataTypeEx();
        // 새로운 객체이므로 할당된 값이 없고, 새로운 객체 주소로 변경
        System.out.println(ex.typeName); //null
        System.out.println(System.identityHashCode(ex)); //1831932724
    }

    public static void callbyvalue(){
        // int 변수 신규할당
        int v = 42;
        System.out.println(v); // 42
        System.out.println(System.identityHashCode(v)); //1078694789
        // 메소드 처리
        method(v);
        // 메소드 내에서 처리된 것과 연관성이 없으므로 기존 int 변수 할당된 값 참고
        System.out.println(v); // 42
        System.out.println(System.identityHashCode(v)); //1078694789
    }

    private static void method(int v) {
        // 기존 선언된 int 변수 값
        System.out.println(System.identityHashCode(v)); //1078694789
        v = v * 2;
        // 새로운 값 변경으로 신규 int 변수 할당
        System.out.println(System.identityHashCode(v)); //1831932724
    }
}
