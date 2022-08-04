package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CoupangLiveTest {
    // 1. 정렬된 링크드 리스트 구현 - 중복제거
    // 2. 정방배열 돌아가면서 print
    // 3. 회문 - 1개까지 제거 가능
    // 4. [1,2,3] [4,5,6,7] -> 123 + 4567 = 4790 -> [4,7,9,0]
    //    조건, 문자열-> integer로 바꿔서 연산처리는 하지마
    public static void main(String[] args){
//        Arrays.fill();
//        int[] a = {1,2,3,4};
//        Arrays.sort(new int[][]{a},Collections.reverseOrder());
//        List<Integer> list = new ArrayList<>();
//        LinkedList linkedList = new LinkedList(1, new LinkedList(2,new LinkedList(3, new LinkedList(3, new LinkedList(4, new LinkedList(5, null))))));
//        throw new RuntimeException("test");
        test01();
//        test02();
//        test03();
//        test04();
    }

    private static void test01() {
        // 정렬된 링크드 리스트 구현 - 중복제거
        int[] arr = {1,3,3,3,4,5,6};
//        int[] arr = {1,1,1,1};
        solution01(arr);
    }

    public static class Node{
        int value;
        Node next;
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void solution01(int[] arr){
        // array to 연결리스트 변환
        Node nodeList = new Node(arr[0],null);
        Node current = nodeList;
        for(int i=1;i<arr.length;i++){
            Node now = new Node(arr[i],null);
            current.next = now;
            current = current.next;
        }

        // 연결리스트 값
        int idx = 1;
        int after = -1;

        while(idx < arr.length){
            after = nodeList.next.value;
            idx++;
            if(nodeList.value == after && nodeList.next != null){
                nodeList.next = nodeList.next.next;
                continue;
            }
            System.out.println(nodeList.value);
            nodeList = nodeList.next;
        }

        if (idx == arr.length) {
            System.out.println(nodeList.value);
        }

        System.out.println("finish!!!");
    }

    private static void test02() {
        // 정방배열 돌아가면서 print
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        solution02(arr);
    }

    public static void solution02(int[][] arr) {
        // 정방배열 특징
        // 특정 개수 반복하여 방향 전환
    }

    // 방향전환 메소드
    private static void test03() {

    }

    private static void test04() {
    }





}
