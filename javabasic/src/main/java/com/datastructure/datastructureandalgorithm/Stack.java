package com.datastructure.datastructureandalgorithm;

/**
 * 3.10.1 연결리스트를 사용해서 스택을 구현해라.
 */
public class Stack {
    Node head;
    Node tail;
    class Node{
        Integer data;
        Node next;
        Node prev;
        Node(Integer data){
            this.data = data;
        }
    }
    public int getLength(){
        Node current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }
    public Node searchNode(int idx){
        Node currentNode = head;
        return currentNode;
    }

    public void push(Integer data){
        Node currentNode = new Node(data);
        tail.next = currentNode;
        currentNode.prev = tail;
    }

    public Integer pop(){
        Node currentNode = tail;
        currentNode.prev.next = null;
        tail = null;
        return  currentNode.data;
    }

    public Node peek(){
        Node currentNode = head;
        return head;
    }

    public void delete(){

    }

    public void remove(int index){
        Node current = head;
        int idx = 0;
        while(current != null && idx < index ){
            current = current.next;
        }

        current = null;
    }

    /**
     * 스택 특징
     * - LIFO - Last In First Out
     * - pop
     * - push
     * - remove
     * - clear
     * - peek
     */



}
