package com.datastructure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
        getPcketMon();
    }

    private static void getPcketMon() {
        int[] pcketMons = {3,1,2,3};
        int result = solution01(pcketMons);
        System.out.println(result);
    }

    static int solution01(int[] nums){
        int answer = 0;
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            idx = i + 1;
            for(int j=idx; j < nums.length; j++){
                if((map.getOrDefault(nums[i], -1) != nums[j] )&& (map.getOrDefault(nums[j], -1) != nums[i])){
                    if(nums[i] != nums[j]) {
                        map.put(nums[i], nums[j]);
                    }
                }
            }
        }
        answer = map.size();
        return answer;
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
