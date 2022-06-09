package com.datastructure.datastructureandalgorithm;

import java.util.EmptyStackException;

public class LLStack{
    private LLNode<Integer> head;
    static class LLNode<T>{
        private T data;
        private LLNode next;
        private LLNode prev;
        public LLNode(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }
        public void setData(T data){
            this.data = data;
        }
        public LLNode getNext(){
            return next;
        }
        public void setNext(LLNode next){
            this.next = next;
        }
        public LLNode getPrev(){
            return prev;
        }
        public void setPrev(LLNode prev){
            this.prev = prev;
        }
    }
    public LLStack(){
        this.head= new LLNode<Integer>(null);
    }

    /**
     * 스택 데이타 push를 헤드에 추가하는 형태로 구현
     */
    public void push(int data){
        if(head == null){
            head = new LLNode<Integer>(data);
        }else if(head.getData() == null){
            head.setData(data);
        }else{
            LLNode<Integer> llNode = new LLNode<Integer>(data);
            llNode.setNext(head);
            head = llNode;
        }
    }

    public Integer top(){
        if(head == null) return null;
        else return head.getData();
    }
    public int pop(){
        if(head == null){
            throw new EmptyStackException();
        }else{
            Integer data = head.getData();
            head= head.getNext();
            return data;
        }
    }
    public boolean isEmpty(){
        if(head == null) return true;
        else return false;
    }

    public void deleteStack(){
        head = null;
    }
}
