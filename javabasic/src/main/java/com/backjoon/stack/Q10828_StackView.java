package com.backjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10828_StackView {
    //public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String[] operands = new String[N];
        for(int i=0; i<N;i++){
            operands[i] =  br.readLine();
        }
        br.close();
        for(int i=0; i<N;i++){
            String[] operand = operands[i].split(" ");
            switch (operand[0]){
                case "push" :
                    stack.push(Integer.valueOf(operand[1]));
                    break;
                case "pop" :
                    if (stack.size() == 0) {
                        System.out.println(-1);
                    }else{
                        System.out.println(stack.pop());
                    }
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    int val = 0;
                    if(stack.isEmpty()) val = 1;
                    System.out.println(val);
                    break;
                case "top" :
                    if (stack.size() == 0) {
                        System.out.println(-1);
                    }else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
