package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(3)));
        System.out.println(addTwoNumbers(l1, l2));
    }
     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int l1Size = 1;
            int l2Size = 1;
            List<Integer> l1List = new ArrayList<>();
            List<Integer> l2List = new ArrayList<>();
            ListNode compare = l1;
            while(compare != null){
                l1List.add(compare.val);
                compare = compare.next;
                l1Size++;
            }
            compare = l2;
            while(compare != null){
                l2List.add(compare.val);
                compare = compare.next;
                l2Size++;
            }

            int max = Math.max(l1List.size(), l2List.size());
            int[] compareList = new int[max];
            boolean isL1Max = false;
            if(max == l1List.size()) isL1Max = true;
            int gap = Math.abs(l1List.size()-l2List.size());
            int idx = 0;
            int idx1 = 0;
            int idx2 = 0;
            while (max > 0){
                if(isL1Max) idx1 = idx;
                else idx2 = idx;
                compareList[idx] = l1List.get(idx);
                if(gap <= 0){
                    compareList[idx] = l2List.get(idx2);
                }
                idx++;
            }

            System.out.println(compare);
//            while(l1.next != null || l2.next != null){
//                boolean bothNext = true;
//                if(l1.next != null){
//                    l1Size++;
//                }else{
//                    bothNext = false;
//                }
//                if(l2.next != null){
//                    l2Size++;
//                }else{
//                    bothNext = false;
//                }
//
//                if(!bothNext){
//                    compare.next = new ListNode(0);
//                }
//            }
          return compare;
        }
}
