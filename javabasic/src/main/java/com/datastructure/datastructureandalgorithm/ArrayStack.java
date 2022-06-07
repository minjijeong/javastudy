package com.datastructure.datastructureandalgorithm;

/**
 * 배열로 스택 구현
 * * 문제점
 *  - 동적 배열 구현이 어렵다.
 *   1) 스택이 가득찰때마다 배열 크기 증가 -  배열의 사이즈가 변경될 때 마다 모든 항목을 복사한 후 맨뒤에 새항목을 추가해야 한다.
 *   2) 반복적인 두배 확장 - 배열이 가득차면 크기가 2배인 새별을 만들어 항목을 복사한다.
 *      ** 두 배 확장을 너무 많이 하면 메모리 오버플로우 예외가 발생할 수 있다.
 */
public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack(){
        capacity = -1;
        array = new int[capacity];
        top  = -1;
    }

    public boolean isEmpty(){
        /**
         * 이 조건이 참이면 1이 리턴되고, 아니면 0이 리턴된다.
         */
        return (top == -1);
    }

    public boolean isStackFull(){
        /**
         * 이 조건이 참이면 1이 리턴되고 아니면 0이 리턴된다.
         */
        return (top == capacity -1);
    }

    public void push(int data){
        if (isStackFull()) {
            System.out.println("Stack is Overflow");
        }
        else{ // top을 1씩 증가시키고 데이터를 top 위치에 저장한다.
            array[++top] = data;
        }
    }

    public int pop (){
        if(isEmpty()){ // top == -1은 스택이 비었음을 뜻한다.
            System.out.println("Stack is Empty");
            return 0;
        }
        else{
            return array[top--];
        }
    }

    public  void deleteStack(){
        top = -1;
    }

    /**
     * 배열이 full로 찾을 때, 반복적인 두배 확장을 통해 동적 배열을 구현
     */
    public void doubleStack(){
        int newArray[] = new int[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = capacity * 2;
        array = newArray;
    }
}
