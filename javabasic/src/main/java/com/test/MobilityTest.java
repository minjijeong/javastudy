package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class MobilityTest {
    public static void main(String[] args) {
//        test01();
        test02();
//        test03();
    }

    private static void test03() {
        int[] A = {1};
        int result = solution03(A);
        System.out.println(result);
    }
    public static int solution03(int[] A) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if(A.length == 1){
            return 1;
        }

        int before = 0;
        for(int i=0; i<A.length-2;i++){
            boolean isSame = A[i] == A[i+2];
            if(!queue.isEmpty()){
                if(isSame){
                    queue.add(A[i]);
                }
                list.add(queue.poll());
            }
            if(isSame){
                queue.add(A[i]);
                list.add(A[i]);
            }
        }
        return list.size();
    }

    private static void test02() {
        int[] T = {0,0,1,1};
        int[] A = {2};
        int result = solution02(T,A);
        System.out.println(result);
    }
    public static class Node{
        int n;
        int dist;
        List<Node> links = new LinkedList<>();
        Node(int n){this.n = n;}

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return n == node.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n);
        }
    }

    static Queue<Integer> used;

    public static int solution02(int[] T, int[] A) {
        int answer = 0;
        List<Node> list = new ArrayList<>();
        used = new LinkedList<>();

        for(int i=0; i < T.length;i++){ list.add(new Node(i));}
        for(int j=0; j<T.length;j++){
            int idx = -1;
            idx = list.indexOf(new Node(T[j]));
            Node node = list.get(j);
            node.links.add(list.get(idx));
        }

        for(int target : A){
            Queue<Integer> temp = new LinkedList<>();
            temp.add(target);
            while(!temp.isEmpty()){
                int current = temp.poll();
                Node tmpNode = list.get(current);
                if(!used.contains(current)) {
                    used.add(current);
                    int curIdx = -1;
                    current = tmpNode.links.get(0).n;
                    curIdx = list.indexOf(new Node(current));
                    if(curIdx != -1){
                        temp.add(current);
                    }

                }
            }

        }

        return used.size();
    }

    private static void test01() {
        String S = "Jhone Doe, Peter Parker, Mary Jane Watson-Parker, Jane Doe";
        String C = "Company";
        String result = solution01(S,C);
        System.out.println(result);
    }

    // Name <Email>
    public static String solution01(String S, String C) {
        String[] names = S.split(", ");
        Map<String, Integer> emails = new HashMap<>();
        List<String> emailNames = new ArrayList<>();
        String emailBack = "@"+C.toLowerCase()+".com";
        StringBuffer emailTot = new StringBuffer();


//        System.out.println(Arrays.toString(names));
        for(String name : names){
            StringBuffer email = new StringBuffer();
            String[] sName = name.split(" ");

            String nameEmail = "";

            // First Name - 첫글자
            email.append(sName[0].substring(0,1).toLowerCase());
            // Middle Name - 첫글자
            if(sName.length > 2){
                email.append(sName[1].substring(0,1).toLowerCase());
            }
            // Last Name - 하이픈이 있다면 하이픈제거, 최대 8글자로 자르기
            String lastName = sName[sName.length-1].replace("-","").toLowerCase();
            if(lastName.length() > 8) lastName = lastName.substring(0,8);
            email.append(lastName);

            String emailAddr = email.toString()+emailBack;
            // 메일 있는지 확인 후 있으면 seq
            int seq = 1;
            if(emails.containsKey(emailAddr)) {
                seq = emails.get(emailAddr) + 1;
                if (seq > 1) {
                    email.append(seq);
                }
            }
            emails.put(emailAddr,seq);
            nameEmail = name + " " + "<"+email.toString()+emailBack+">";
            emailNames.add(nameEmail);
        }
        for(int i=0; i < emailNames.size(); i++){
            emailTot.append(emailNames.get(i));
            if(i < emailNames.size() -1){
                emailTot.append(", ");
            }
        }
        return emailTot.toString();
    }
}
