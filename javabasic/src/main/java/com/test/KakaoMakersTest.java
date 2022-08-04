package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class KakaoMakersTest {
    public static void main(String[] args){
//        test01();
//        test02();
        test03();
    }

    private static void test03() {
//        String[] queries = {"Friend", "Friend","Total"};
//        int[] s1 = {1,2,1};
//        int[] s2 = {2,3,4};
//        int n = 4;
//        String[] queries = {"Friend", "Total"};
//        int[] s1 = {1,2};
//        int[] s2 = {2,3};
//        int n = 3;
//        String[] queries = {"Friend", "Total"};
//        int[] s1 = {1,2};
//        int[] s2 = {2,3};
//        int n = 5;
        String[] queries = {"Friend", "Friend","Total"};
        int[] s1 = {4,2,2};
        int[] s2 = {1,4,3};
        int n = 5;
//        String[] queries = {"Friend","Total", "Friend","Total", "Friend","Total", "Friend","Total", "Friend","Total"};
//        int[] s1 = {2, 4, 9, 1, 4, 10, 7, 10, 8, 1};
//        int[] s2 = {6, 1, 7, 8, 9, 9, 4, 7, 2, 6};
//        int n = 10;
//        String[] queries = {"Friend","Total", "Friend","Total", "Friend","Total", "Friend","Total", "Friend","Total"};
//        int[] s1 = {9, 6, 7, 1, 8, 1, 2, 3, 2, 1};
//        int[] s2 = {2, 5, 2, 5, 2, 4, 1, 7, 4, 8};
//        int n = 10;

        List<Integer> s1List = new ArrayList<>();
        for (int i : s1) {
            s1List.add(i);
        }
        List<Integer> s2List = new ArrayList<>();
        for (int i : s2) {
            s2List.add(i);
        }
        System.out.println(solution03(n, Arrays.stream(queries).collect(Collectors.toList()), s1List, s2List));
    }

    public static List<Integer> solution03(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1; i<=n;i++){
            List<Integer> set = new ArrayList<>();
            set.add(i);
            map.put(i,set);
        }
        System.out.println(map.keySet());

        for(int i=0;i<queryType.size();i++) {
            int std1 = students1.get(i);
            int std2 = students2.get(i);

            if (queryType.get(i).equals("Friend")) {
                // Set으로 변경
                Set<Integer> combine = new LinkedHashSet<>(map.get(std1));
                combine.addAll(map.get(std2));
                for(int num : combine){
                    map.replace(num, combine.stream().collect(Collectors.toList()));
                }
            } else {
                Set<Integer> set = new LinkedHashSet<>(map.get(std1));
                set.addAll(map.get(std2));
                answer.add(set.size());
            }

        }
        return answer;
    }


    public static List<Integer> solution03_fail(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        int[] numbers = new int[n+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> totalList = new ArrayList<>();
        int grpNo = 1;
        for(int i=0;i<queryType.size();i++) {
            int std1 = students1.get(i);
            int std2 = students2.get(i);

            if (queryType.get(i).equals("Friend")) {
//                Set<Integer> edge = map.getOrDefault(students1.get(i), new HashSet<>());
//                edge.add(students2.get(i));
//                map.put(students1.get(i),edge);
//                Set<Integer> reverseEdge = map.getOrDefault(students2.get(i), new HashSet<>());
//                reverseEdge.add(students1.get(i));
//                map.put(students2.get(i), reverseEdge);

                int targetGrpNo = 0;
                if (numbers[std1] == 0 && numbers[std2] == 0) {
                    numbers[std1] = grpNo;
                    numbers[std2] = grpNo;
                    grpNo++;
                } else {
                    targetGrpNo = numbers[std1] != 0 ? numbers[std1] : numbers[std2];
                    numbers[std1] = targetGrpNo;
                    numbers[std2] = targetGrpNo;
                }
            } else {
                totalList.add(i);
            }

        }

        for(int k=1; k<numbers.length;k++){
            if(numbers[k] == 0){
                numbers[k] = grpNo;
                grpNo++;
            }
        }
        for(int i=0; i< totalList.size();i++){
            int totalIdx = totalList.get(i);
            int std1 = students1.get(totalIdx);
            int std2 = students2.get(totalIdx);
            int target1 = 0;
            for (int j=1; j< numbers.length; j++) {
                if(numbers[j] == numbers[std1]){
                    target1++;
                }
            }
            int target2 = 0;
            for (int j=1; j< numbers.length; j++) {
                if(numbers[j] == numbers[std2]){
                    target2++;
                }
            }

            answer.add(target1 + target2);

        }
        return answer;
    }

    private static void test02() {
        String s = "0011";
        System.out.println(solution02(s));
    }
    public static String solution02(String s) {
        // Write your code here
        return s;
    }

    private static void test01() {
        /**
         * STDIN             Function
         * -----             --------
         * 4             →   ingredients[] size n = 4
         * linguine      →   ingredients = ['linguine', 'pepper', 'ketchup', 'mushroom']
         * pepper
         * ketchup
         * mushroom
         * 1             →   startIndex = 1
         * mushroom      →   target = 'mushroom'
         */
//        String[] strs = {"linguine", "pepper", "ketchup", "mushroom"};
        String[] strs = {"linguine", "pepper", "ketchup", "ketchup"};
        List<String> list = Arrays.stream(strs).collect(Collectors.toList());
        int start = 0;
        String target = "ketchup";
        System.out.println(solution(list, start, target));
    }

    public static int solution(List<String> ingredients, int startIndex, String target) {
        int answer = Integer.MAX_VALUE;
        Set<Integer> targetIdx = new HashSet<>();
        for(int i=0; i < ingredients.size();i++){
            if(target.equals(ingredients.get(i))){
                targetIdx.add(i);
            }
        }

        for(int idx : targetIdx){
            int gap = startIndex - idx;
            int distance2 = gap > 0 ? ingredients.size() - gap : ingredients.size() + gap;
            answer = Math.min(answer, Math.min(Math.abs(gap),distance2 ));
        }

        return answer;
    }
}
