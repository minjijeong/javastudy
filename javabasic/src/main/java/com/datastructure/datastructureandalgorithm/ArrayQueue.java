package com.datastructure.datastructureandalgorithm;

/**
 * 원형배열을 기초한 큐 구현
 * 가장 처음에, 앞과 뒤 포인터 모두 -1을 가리키게 하여 큐가 비었다는 것을 알린다.
 */
public class ArrayQueue {
    private int front; // 앞
    private int rear; // 뒤쪽
    private int capacity; // 배열의 사이즈
    private int[] array;
    private ArrayQueue(int size){
        capacity = size;
        front = -1;
        rear = -1;
        array = new int [size];
    }

    public static ArrayQueue createQueue(int size){
        return new ArrayQueue(size);
    }


    public boolean isEmpty(){
        return (front == -1);
    }

    public boolean isFull(){
        return ((rear+1) % capacity == front);
    }

    public int getQueueSize(){
        return ((capacity - front + rear +1) % capacity);
    }

    // 큐의 가장 끝에 항목에 삽입한다.
    public void enQueue(int data) throws EmptyQueueException{
        if(isFull()){
            throw new EmptyQueueException("Queue Empty");
        }else {
            rear = (rear+1) % capacity;
            array[rear] = data;
            if (front == -1) {
                front = rear;
            }
        }
    }
    // 큐의 가장 앞의 항목을 제거하고 리턴한다.
    public int deQueue() throws EmptyQueueException {
        int data = -1;
        if(isEmpty()){
            throw new EmptyQueueException("Queue Empty");
        }else{
            data = array[front];
            if(front == rear){
                front = rear -1;
            }else{
                front = (front + 1) % capacity;
            }
        }
        return data;
    }

    private class EmptyQueueException extends Throwable {
        public EmptyQueueException(String queue_empty) {
            System.out.println(queue_empty);
        }
    }
}
