package com.datastructure.datastructureandalgorithm;

/**
 * 동적 원형 배열에 기초한 구현
 * 메모리가 찾을 때 resize 로직을 추가하여 기존 용량보다 2배 더 할당하여 처리
 */
public class DynArrayQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] array;
    private DynArrayQueue(){
        capacity = -1;
        front = -1;
        rear = -1;
        array = new int[1];
    }

    public static DynArrayQueue createDynArrayQueue(){
        return new DynArrayQueue();
    }
    public boolean isEmpty(){
        return (front == -1);
    }
    // front = 0 , rear = 7, capacity = 8 이면 모두 차있는 것이므로 full
    public boolean isFull(){
        return ((rear+1) % capacity == front);
    }
    public int getQueueSize(){
        if(front == -1) return 0;
        int size = (capacity - front + rear + 1) % capacity;
        if(size == 0) return capacity;
        else return size;
    }
    private void resizeQueue(){
        // 초기 용량 고정
        int initCapacity = capacity;
        // 2배로 공간 할당
        capacity *= 2;
        int[] oldArray = array;
        // 기존 array에 새롭게 2배 크기의 빈 배열 할당
        array = new int[this.capacity];
        // oldArray에 넣어 놓은 값을 copy
        for(int i=0;i<oldArray.length;i++){
            array[i] = oldArray[i];
        }
        if(rear < front){
            for(int i=0;i<front;i++){
                array[i+initCapacity] = this.array[i];
                array[i] = 0;
            }
            rear = rear + initCapacity;
        }
    }

    public void enQueue(int data){
        if(isFull()) resizeQueue();
        rear = (rear + 1) % capacity;
        array[rear] = data;
        if(front == -1) front = rear;
    }
    public int deQueue() throws EmptyQueueException {
        int data;
        if(isEmpty()){
            throw new EmptyQueueException("Queue Empty");
        }
        else{
            data = array[front];
            if(front == rear) front = rear - 1;
            else front = (front + 1) % capacity;
        }
        return data;
    }

    private class EmptyQueueException extends Throwable {
        public EmptyQueueException(String queue_empty) {
            System.out.println(queue_empty);
        }
    }
}
