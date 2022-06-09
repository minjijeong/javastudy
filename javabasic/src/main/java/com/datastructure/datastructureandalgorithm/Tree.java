package com.datastructure.datastructureandalgorithm;

public class Tree {

    void preOrderNonRecurisive(BinaryTreeNode root){
        if(root == null) return;
        LLStack s = new LLStack();
        while(true){
            while(root != null){
                System.out.println(root.getData());
                s.push(root.getData());
                root = root.getLeft();
            }
            if(s.isEmpty()) break;
            root = new BinaryTreeNode(s.pop());
            root = root.getRight();
        }
    }
}
