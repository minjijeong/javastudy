package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Enrolment {
    static List<Subject> list;
    static Stack<String> subList;
    static Queue<String> noNodeList;
    public static class Subject{
        String beforeSub;
        String targetSub;
        public Subject(String bs, String ts){
            this.beforeSub = bs;
            this.targetSub = ts;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Subject subject = (Subject) o;
            return Objects.equals(this.beforeSub, subject.beforeSub) && Objects.equals(this.targetSub,
                    subject.targetSub);
        }

        @Override
        public int hashCode() {
            return Objects.hash(beforeSub, targetSub);
        }

        @Override
        public String toString() {
            return this.beforeSub+"->"+this.targetSub;
        }

    }
    public static void main(String[] args) {
        String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
//        String[] s1 = {"A", "E", "B", "D", "B", "H", "F", "H", "C"};
        String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
//        String[] s2 = {"G", "C", "G", "F", "J", "E", "B", "F", "B"};
        String k = "B";
//        String k = "G";

        String[] result = solution(s1, s2, k);
        System.out.println(Arrays.toString(result));
    }
    public static String[] solution(String[] s1, String[] s2, String k) {
        subList = new Stack<>();
        list= new LinkedList<>();
        noNodeList = new LinkedList<>();

        for(int i=0; i <s1.length;i++){
            list.add(new Subject(s1[i],s2[i]));
        }
        // k 찾기
        subList.push(k);
        getUpper(k);
//        System.out.println(subList);
//        System.out.println(noNodeList);

        List<String> result = new LinkedList<>();
        result.addAll(noNodeList);
        while(!subList.isEmpty()){
            result.add(subList.pop());
        }
        return result.stream().toArray(String[]::new);
    }
    public static void getUpper(String now){
        List<Subject> tlist =list.stream()
                .filter(o -> o.targetSub.equals(now))
                .collect(Collectors.toList());

        if(tlist.size() < 1) {
            if(!noNodeList.contains(now)) noNodeList.add(now);
        }
        else {
            if (!subList.contains(now) && !noNodeList.contains(now)){
                subList.push(now);
            }
            Stack<Subject> tmp = new Stack<>();
            for (Subject s : tlist) {
                getUpper(s.beforeSub);
            }
        }
    }
}
