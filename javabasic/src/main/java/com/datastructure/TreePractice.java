package com.datastructure;

import java.util.Scanner;

public class TreePractice {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 3;
        TreePractice t = new TreePractice();
        int[] arr = {2,31,55,31,22,98,22,99,100};
        for(int i = 0; i < arr.length; i=i+3){
            int a =  arr[i];
            int b =  arr[i+1];
            int c =  arr[i+2];
            t.createNode(a,b,c);
        }

        System.out.println("전위 순회");
        t.preOrder(t.root);

        System.out.println("\n중위 순회");
        t.inOrder(t.root);

        System.out.println("\n후위 순회");
        t.postOrder(t.root, 0);
    }
    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public Node root;

    /**
     * 노드생성(값 추가)
     * @param data
     * @param leftData
     * @param rightData
     */
    public void createNode(int data, int leftData, int rightData){
        if(root == null){ // 초기상태
            root = new Node(data);

            // 좌, 우 노드 존재 시 생성
            if(leftData != -1){
                root.left = new Node(leftData);
            }
            if(rightData != -1){
                root.right = new Node(rightData);
            }
        }else{ // 루트노드를 시작으로 생성할 위치의 상위 노드를 찾아야함.
            searchNode(root,data,leftData,rightData);
        }
        System.out.println(data);
        System.out.println(leftData + "  " + rightData);
    }

    /**
     * 노드검색(값을 추가할 곳 찾기)
     * @param node
     * @param data
     * @param leftData
     * @param rightData
     */
    public void searchNode(Node node, int data, int leftData, int rightData){
        // node를 못찾는 경우
        if(node == null){ // 도착한 노드가 null이면 재귀 종료
            return;
        } else if (node.data == data) { // 들어갈 위치를 찾았다면,
            if(leftData != -1) {
                node.left = new Node(leftData);
            }
            if(rightData != -1){
                node.right = new Node(rightData);
            }
        }else {
            searchNode(node.left, data, leftData, rightData); // 왼쪽 재귀 탐색
            searchNode(node.right,data,leftData,rightData); // 오른쪽 재귀 탐색
        }
    }

    /**
     * 전위순회
     * Root -> Left -> Right
     * @param node
     */
    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.data + " ");
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    /**
     * 중위 순회
     * Left -> Root -> Right
     * @param node
     */
    public void inOrder(Node node){
        if(node != null){
            if(node.left != null) inOrder(node.left);
            System.out.println(node.data + " ");
            if(node.right != null) inOrder(node.right);
        }

    }

    /**
     * 후위 순회
     * Left -> Right -> Root
     * @param node
     */
    public void postOrder(Node node, int now){
        if(node != null){
            System.out.printf("postOrder.root :: %d, now :: %d \n",node.data, now);
            if(node.left != null){
                System.out.printf("postOrder.left :: %d, now :: %d \n",node.left.data, now);
                postOrder(node.left, now--);
            }
            if(node.right != null){
                System.out.printf("postOrder.right :: %d, now :: %d \n",node.right.data, now);
                postOrder(node.right,now++);
            }
            System.out.println(node.data + " ");
        }
    }
}
