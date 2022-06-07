package com.datastructure.datastructureandalgorithm;

import java.util.List;
import java.util.Stack;

public class SimpleLinkedList {
    public static void main(String[] args) {
    }

    public class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getData(){
            return data;
        }
        public void setNext(ListNode next){
            this.next = next;
        }

        public ListNode getNext(){
            return next;
        }
    }
    int listLength(ListNode headNode){
        int length = 0;
        ListNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    ListNode insertInLinkedList(ListNode headNode, ListNode nodeToinsert, int position){
        if(headNode == null){
            return nodeToinsert;
        }
        int size = listLength(headNode);

        if(position > size+1 || position < 1){
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to "+ (size + 1));
            return headNode;
        }

        // 첫 노드 삽입
        if(position == 1){
            nodeToinsert.setNext(headNode);
            return nodeToinsert;
        } else{ // 중간과 끝에 노드를 삽입한다.
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position-1){
                previousNode = previousNode.next;
                count++;
            }
            ListNode currentNode= previousNode.getNext();
            nodeToinsert.setNext(currentNode);
            previousNode.setNext(nodeToinsert);
        }
        return headNode;
    }

    ListNode deleteNodeFromLinkedList(ListNode headNode, int position){
        int size = listLength(headNode);

        if(position > size || position < 1){
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to "+ size);
            return headNode;
        }

        // 첫번째 노드 삽입
        if(position == 1){
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return  currentNode;
        }else{ // 중간 혹은 맨 끝 삽입
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position -1){ // 삽입직전 위치의 노드 구하기
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }


    /**
     * Node 전체 삭제는 이렇게 하지 않고 head 노드를 null로 선언하면
     * 가비지 콜렉터가 해당 연결 리스트를 정리한다.
     */
    void deleteLinkedList(ListNode head){
//        ListNode auxilaryNode, iterator = head;
//        while (iterator != null){
//            auxilaryNode = iterator.getNext();
//            iterator = null;
//            iterator = auxilaryNode;
//        }
        head = null;
    }
}
