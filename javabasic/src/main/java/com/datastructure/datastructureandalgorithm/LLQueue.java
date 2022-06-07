package com.datastructure.datastructureandalgorithm;

import com.datastructure.datastructureandalgorithm.LLStack.LLNode;

public class LLQueue {
    private LLNode<Integer> frontNode;
    private LLNode<Integer> rearNode;
    private LLQueue(){
        frontNode = null;
        rearNode = null;
    }
    public static LLQueue createQueue(){
        return new LLQueue();
    }
    public boolean isEmpty(){
        return (frontNode == null);
    }

    public void enQueue(Integer data){
        LLNode newNode = new LLNode<Integer>(data);
        if(rearNode != null){
            rearNode.setNext(newNode);
        }
        rearNode = newNode;
        if(frontNode == null){
            frontNode = rearNode;
        }
    }
    public int deQueue() throws EmptyQueueException {
        int data;
        if(isEmpty()){
            throw new EmptyQueueException("Queue Empty");
        }else{
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }

    private class EmptyQueueException extends Throwable {
        public EmptyQueueException(String queue_empty) {
            System.out.println(queue_empty);
        }
    }
}
