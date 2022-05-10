package com.datastructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import sun.awt.image.ImageWatched.Link;

/**
 *  search는 indexOf, contains, remove 같은 곳에서 이미 구현되어 있다. : 완전탐색
 *  equals가 제공될 필요가 있다. 객체 비교 등으로 인해
 *
 *  이진탐색 : Collections.binarySearch
 *  Comparable 인터페이스가 구현디어 있어야 한다.
 *  순서대로 정렬되어 있어야 한다.
 */
public class LinearSearchPractice {
    public static void main(String[] args) {
//        linearSearchConception();
//        phoneBook();
//        countChars();
        skillTree();
    }

    private static void skillTree() {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int result = solution03(skill, skill_trees);
        System.out.println(result);

    }

    private static int solution03(String skill, String[] skill_trees) {
        int answer = 0;
        // skill queue에 적재
        // CBD
        Queue<String> queue = new LinkedList<>();
        // n-1
        for(int i=0;i<skill.length();i++){
            queue.offer(skill.substring(i,i+1));
        }
        int skillSize= skill.length();
        // n
        for(String node : skill_trees){
//            Queue<String> skills = new LinkedList<>();
//            skills.addAll(queue);
            char[] chars = node.toCharArray();
            System.out.println(Arrays.toString(chars));
            int idx = 0;
            for(int i=0;i<chars.length;i++){
                if(idx > skillSize -1){
                    break;
                }
                if(skill.substring(idx,idx+1).equals(String.valueOf(chars[i]))){
                    idx++;
                }
            }
            if(idx > 1){
                answer++;
            }
        }
        return answer;
    }

    private static int solution03_1(String skill, String[] skill_trees) {
//        int answer = 0;
//        for(String s: skill_trees){
//            String s2 = s.replaceAll("[^"+skill+"]","");
//            // s2는 sklls의 접두사 인지
//            if(skill.startsWith(s2)){
//                answer++;
//            }
//        }
//        return answer;
        return (int)Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^"+skill+"]",""))
                .filter(s-> skill.startsWith(s))
                .count();
    }

    private static void countChars() {
        String s = "Pyy";
        boolean result = solution02(s);
        System.out.println(result);
    }

    private static boolean solution02(String s) {
        boolean answer = true;
        // p == y -> true
        // p != y -> false
        // p = 0 && y = 0 -> true
//        char[] str = s.toUpperCase().toCharArray();
//        int pCount = 0;
//        int yCount = 0;
//        for(int i=0; i < str.length; i++){
//            if(str[i] == 'P'){
//                pCount++;
//                continue;
//            }
//            else if(str[i] == 'Y'){
//                yCount++;
//            }
//        }
//        return pCount-yCount == 0;
        int p = s.replaceAll("[^pP]", "").length();
        int y = s.replaceAll("[^yY]", "").length();
        return p == y;
    }

    private static void phoneBook() {
        String[] phone_book = {"12","123","1235","567","88"};
        boolean result = solution01(phone_book);
        System.out.println(result);
    }

    private static boolean solution01(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1;i++){
            int size = phone_book[i].length();
            if(phone_book[i+1].length() > size){
                System.out.printf("i : %s, j : %s \n",phone_book[i], phone_book[i+1].substring(0,size));
                if(phone_book[i+1].startsWith(phone_book[i])){
                    return false;
                }
                continue;
            }
        }
        return true;
    }

    public static class MyData implements Comparable<MyData>{
        int v;
        public MyData(int v){
            this.v = v;
        }

        @Override
        public String toString(){
            return "" + v;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyData myData = (MyData) o;
            System.out.println("this :: "+this.v);
            System.out.println("myData :: "+myData.v);
            return this.v == myData.v;
        }

        @Override
        public int hashCode(){
            return Objects.hash(v);
        }

        @Override
        public int compareTo(MyData o) {
            // 1 == 1 : 1-1 = 0 : 같다
            // 1 ? 2 : 1-2 ? 0 : 0과 비교하여 대소관계 연산
            return v - o.v;
        }
    }
    private static void linearSearchConception() {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i <100;i++) list.add(i);
//        System.out.println(list);
        int index = list.indexOf(63); // 이미 List에는 선형탐색 개념이 들어 있음

        List<MyData> listMy = new LinkedList<>();
        for(int i=0;i <100;i++) listMy.add(new MyData(i));
        System.out.println(listMy);
        int index2 = listMy.indexOf(new MyData(2)); // 이미 List에는 선형탐색 개념이 들어 있음
        System.out.println(index2);

        int index3 = Collections.binarySearch(listMy, new MyData(3));
        System.out.println(index3);

    }
}
