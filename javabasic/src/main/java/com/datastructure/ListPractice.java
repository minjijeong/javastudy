package com.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

class MyData{
    int value;

    public MyData(int value){
        this.value = value;
    }

    static MyData create(int v){
        return new MyData(v);
    }

    @Override
    public String toString(){
        return ""+value;
    }

    /**
     * list.contains(MyData.create(2))
     * list.indexOf(MyData.create(3))
     * MyDate의 새로운 객체와 list의 기존에 생성된 객체가 동일한 값을 가진것을 비교할때 쓸수 있다.
     */
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return value == myData.value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
}

public class ListPractice {

    public static void main(String[] args) {
//        listConception();
        getIndexofMaxValue();
        getPermutation();
        getReverseNumber();
    }

    private static void getReverseNumber() {
        long n = 12345;
        int[] result = solution03(n);
    }
    public static int[] solution03(long n) {
        int[] answer = {};
        String numbers = String.valueOf(n);
        List<Integer> numberList = new ArrayList<>();
        /*
        for(int i=numbers.length() -1 ; i >= 0 ; i--){
            numberList.add(Integer.valueOf(numbers.substring(i,i+1)));
        }
         */
        while(n > 0){
            numberList.add((int)n%10);
            n /= 10;
        }
        // 문자열이 아닌 숫자 그대로 사용
        /*
         */
        /*
        answer = new int[numberList.size()];
        int idx=0;
        for(int number : numberList){
            answer[idx] = number;
            idx++;
        }
        */
        answer = numberList.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }
    private static void getPermutation() {
        int[] s02 = {1, 3, 5, 4, 5, 2, 1};
        boolean result = solution02(s02);
    }

    // O(n+nlogn) => O(nlogn)
    public static boolean solution02(int[] arr) {
        boolean answer = true;
        Arrays.sort(arr); // O(nlogn)
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i< arr.length ; i++){ //O(n)
            if(arr[i] != (i+1)){
                answer = false;
                break;
            }
        }
        return answer;
    }

    private static void getIndexofMaxValue() {
        int[] s01 = {1, 3, 5, 4, 5, 2, 1};
        int[] maxArray = solution01(s01);
    }
    public static int[] solution01(int[] arr) {
        int[] answer = {};
        int max = 0;
        List<Integer> maxList = new ArrayList<>();

        // max 값 구하기
        max = Arrays.stream(arr).max().getAsInt();

        // max인 값만 list 꺼내오기
        int finalMax = max;
        answer = IntStream.range(0, arr.length)
                .filter(i -> arr[i] == finalMax)
                .toArray();
        /*
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                maxList.clear();
                maxList.add(i);
            } else if(max == arr[i]){
                maxList.add(i);
            }
        }
         */

        // 리스트 -> 배열로 변환
        // answer = maxList.stream().mapToInt(Integer::intValue).toArray();
        /*
        answer = new int[maxList.size()];
        int i=0;
        for(int maxIdx : maxList){
            answer[i] = maxIdx;
            i++;
        }
         */
        return answer;
    }

    public static void listConception(){
        // 선형구조, 순서가 중요함
        List<MyData> list = new ArrayList<>(10);
        // initialCapacity = 10개마다 다시 메모리 재정렬, 중간 인덱스 삭제, 생성된 애들 정리
        // LinkedList<MyData> list = new LinkedList<>();
        // List<MyData> list = new Vector<>() ... 다형성을 가진다. 타입이 많다...
        list.add(MyData.create(1));
        list.add(MyData.create(2));
        list.add(MyData.create(3));
        System.out.println(list); // [1, 2, 3]
        System.out.println(list.contains(MyData.create(2)));

        // 앞에서 부터 뒤지기
        System.out.println(list.indexOf(MyData.create(3)));
        // 뒤에서 부터 뒤지기
        System.out.println(list.lastIndexOf(MyData.create(3)));

        // 리스트가 비어져있는지 확인
        System.out.println(list.isEmpty());
        // 리스트가 null 인경우
        List<MyData> testNull = null;
        System.out.println((testNull == null));
        //System.out.println(testNull.isEmpty()); // NullPointerException 떨어짐

        // Vector - synchronized : 멀티스레드 환경에서 사용할수 있다.
        // ArrayList - 쓰레드 safe 안해도 되거나 멀티스레드에서 사용하지 않는다면 적극 권장
    }
}
