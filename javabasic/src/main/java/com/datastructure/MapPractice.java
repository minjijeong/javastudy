package com.datastructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapPractice {
    public static class MyData{
        int value;

        public MyData(int value){
            this.value = value;
        }

        /**
         * 객체를 toString 하였을때 출력되는 형태를 변경 할 수 있다.
         */
        @Override
        public String toString(){
//            return "MyDate{" +
//                    "value=" + value +
//                    "}";
            return "[" + value + "]";
        }

        /**
         * 신규 객체로 키가 생성된 경우 해당 객체와 일치하는지 확인 하기 위해 hashCode를 비교하여 동일한 데이터인지 확인할 수 있다.
         */
        @Override
        public int hashCode(){
            return Objects.hash(value);
        }
    }

    public static void main(String[] args) {
//        mapConception();
//        getPocketMon();
//        getUnfinishedMan();
        getCustoms();
    }

    private static void getCustoms() {
        String[][] clothes  = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
        int result = solution03(clothes);
        System.out.println(result);
    }

    private static int solution03(String[][] clothes) {
        // 위장용품 종류별 개수
        // 각 개수의 +1 을 모두 곱한다.
        // -1 해서 리턴한다.
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for(String[] clothe : clothes) {
            if (map.get(clothe[1]) != null) {
                map.get(clothe[1]).add(clothe[0]);
            } else {
                List<String> clotheList = new ArrayList<>();
                clotheList.add(clothe[0]);
                map.put(clothe[1], clotheList);
            }
        }

        for(String key : map.keySet()){
            answer *= map.get(key).size() + 1;
        }
        return answer - 1;
    }

    private static int solution03_1(String[][] clothes){
        Map<String, Integer> map = new HashMap<>();

//        // 위장 용품의 종류별 개수를 구한다.
//        for(String[] clothe : clothes){
//            String type = clothe[1];
//            map.put(type, map.getOrDefault(type,0)+1);
//        }
//
//        // 각 개수의 +1을 모두 곱한다. (= 선택 안하는 경우의 수 추가)
//        int answer = 1;
//        Iterator<Integer> iter = map.values().iterator();
//        while(iter.hasNext()){
//            answer *= iter.next() + 1;
//        }

        int answer = Arrays.stream(clothes)
                .map(c -> c[1]) // 1번 인덱스 종류만 꺼내고
                .distinct() // 중복없이
                .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())// 타입별 count 구하고
                .map(c -> c+1) // 선택안하는 케이스 추가
                .reduce(1, (c,n) -> c*n); // 누적해서 곱한 값 구하기

        // 모두 선택안하는 경우의 1개를 뺀다.
        return answer -1;
    }

    private static void getUnfinishedMan() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result = solution02(participant, completion);
        System.out.println(result);
    }

    /**
     * O(n) = O(n) * 2 + O(1)
     */
    private static String solution02(String[] participant, String[] completion) {
        String answer;
        Map<String,Integer> unFinished = new HashMap<>();

        for(String person : participant){
            unFinished.put(person, unFinished.getOrDefault(person, 0) + 1);
//            if(unFinished.get(person) != null){
//                unFinished.replace(person, unFinished.get(person), unFinished.get(person) + 1);
//            }
//            else {
//                unFinished.put(person, 1);
//            }
        }
        for(String person : completion){
            int nums = unFinished.get(person) - 1;
            if(nums == 0){
                unFinished.remove(person);
            }
            else {
                unFinished.put(person, nums);
            }

        }
        answer = unFinished.keySet().iterator().next();
//        if(unFinished.size() > 0 ){
//            String[] str = unFinished.keySet().toArray(new String[0]);
//            answer = str[0];
//        }
        return answer;
    }

    private static String solution02_1(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);

        String name = "";
        for(int i=0; i < participant.length; i++){
            if(!participant[i].equals(completion[i])){
                name = participant[i];
                break;
            }
        }

        return name;
    }

    private static void getPocketMon() {
//        int[] pcketMons = {3,3,3,2,2,4};
        int[] pcketMons = {3,1,2,3};
        int result = solution01(pcketMons);
        System.out.println(result);
    }

    static int solution01(int[] nums){
        int answer = nums.length /2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
//        if(answer > map.size()){
//            answer = map.size();
//        }

        return Math.min(answer, map.size());
    }

    private static void mapConception() {
    /**
     * Array 장점 + List 장점 => 유연하면서도 빠르게 값을 찾아낼 수 잇는
     * Map : Key -> hash function -> hash -> bucket index -> List -> Data
     *
     * Map<K,Y>
     * HashMap : not synchronized = 쓰레드 safe 하지 않는 경우
     * HashTable : synchronized = 멀티쓰레드 사용하는 경우에 사용 - 병목현상이 일어나면... ConcurrentHashMap 사용추천..
     * ConcurrentHashMap : synchronized + high concurrency
     */
        //Hashtable<String, Integer> map = new Hashtable<>();
        //Map<String, Integer> map = new Hashtable<>();
        Map<String, Integer> map = new HashMap<>();
        // initialCapacity 사용가능
        // putAll
        // getOrDefault - 값이 없는 경우 default 값지정
        // isEmpty
        // put - 오버라이트 가능
        // putIfAbsent - 지정한 키값이 미존재시일때만 입력
        // remove - 결과값 boolean 형태로 노출 가능
        // replace - put으로 하거나 replace할수 있다. oldValue와 같을때 newValue로 바꿀수 있음
        map.put("A",1);
        map.put("B",2);
        map.remove("B",3);
        map.putIfAbsent("A",10);
        method1(map);

        Map<MyData, Integer> myDataMap = new ConcurrentHashMap<>();
        myDataMap.put(new MyData(1),1);
        myDataMap.put(new MyData(2),2);
        myDataMap.replace(new MyData(1), 1, 11 );
        method2(myDataMap);
    }

    static void method1(Map<String, Integer> map){
        System.out.println(map); //{A=1, B=2}
        System.out.println(map.get("A")); // 1
        System.out.println(map.getOrDefault("C",99)); // null
        System.out.println(map.keySet());
        System.out.println(map.values());
    }

    static void method2(Map<MyData, Integer> map){
        System.out.println(map); //{A=1, B=2}
        System.out.println(map.get(new MyData(1))); // 1
        System.out.println(map.getOrDefault(new MyData(3),-1)); // null
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
