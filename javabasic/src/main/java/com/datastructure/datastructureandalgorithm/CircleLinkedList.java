package com.datastructure.datastructureandalgorithm;

import com.datastructure.StackQueuePractice.Paper;

public class CircleLinkedList {
    public static void main(String[] args){

    }

    public class CLLNode{
        private int data;
        private CLLNode next;
        public CLLNode(int data){
            this.data = data;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getData(){
            return data;
        }
        public void setNext(CLLNode next){
            this.next = next;
        }
        public CLLNode getNext(){
            return next;
        }
    }

    int CircularListLength(CLLNode headNode){
        int length = 0;
        CLLNode currentNode= headNode;
        while(currentNode != null){
            currentNode = currentNode.getNext();
            length++;
            // 순회했으면 멈춰!
            if(currentNode == headNode){
                break;
            }
        }
        return length;
    }

    void PrintCircularListData(CLLNode headNode){
        CLLNode CLLNode = headNode;
        while (CLLNode != null){
            System.out.print(CLLNode.getData() + " -> ");
            CLLNode = CLLNode.getNext();
            if(CLLNode == headNode) break;
        }
        System.out.println("(" + CLLNode.getData() + ") headNode");
    }

    void InsertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode != headNode){
            currentNode.setNext(currentNode.getNext());
        }
        // 혼자 자기자신을 도는 것을 디폴트로 선언한 것이다.
        nodeToInsert.setNext(nodeToInsert);
        if(headNode == null) headNode = nodeToInsert;
        else{
            // 순회이므로 헤드를 가르켜야 순회할수 있다.
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    void InsertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        // 자기 자신외 다른 노드가 있다면
        while(currentNode.getNext() != headNode){
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode == null) headNode = nodeToInsert;
        else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }
    }

    void deleteLastNodeFromCLL(CLLNode head){
        CLLNode temp = head;
        CLLNode currentNode = head;
        if(head == null){
            System.out.println("List Empty");
            return;
        }
        while(currentNode.getNext() != head){
            temp = currentNode;
            currentNode = currentNode.getNext();
        }

        currentNode = null;
        return;
    }

    void DeleteFrontNodeFromCLL(CLLNode head){
        CLLNode temp = head;
        CLLNode currentNode = head;
        if(head == null) {
            System.out.println("List Empty");
            return;
        }
        while(currentNode.getNext() != head){
            currentNode.setNext(currentNode.getNext());
        }
        currentNode.setNext(head.getNext());
        head = head.getNext();
        temp = null;
        return;
    }
}
