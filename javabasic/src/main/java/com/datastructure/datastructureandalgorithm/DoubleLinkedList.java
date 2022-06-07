package com.datastructure.datastructureandalgorithm;

public class DoubleLinkedList {
    public class DLLNode {
        private int data;
        private  DLLNode next;
        private  DLLNode previous;
        public DLLNode(int data){
            this.data = data;
        }

        public DLLNode(){
            this.data = 0;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getData(){
            return data;
        }
        public DLLNode getNext(){
            return next;
        }
        public void setNext(DLLNode next){
            this.next = next;
        }
        public DLLNode getPrevious(){
            return previous;
        }
        public void setPrevious(DLLNode previous){
            this.previous = previous;
        }
    }

    DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position){
        if(headNode == null){
            return nodeToInsert;
        }
        int size = getDLLLength(headNode);
        if( position > size || position < 1){
            System.out.println("Previous of nodeToInsert is invalid. The valid inputs are 1 to "+(size +1));
            return headNode;
        }

        // 첫 노드에 삽입
        if(position == 1){
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        }else{ // 중간 혹은 맨 끝 삽입
            DLLNode previousNode = headNode;
            int count = 1;
            // 직전 노드를 구하기 위해서 처리
            while(count < position -1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if(currentNode != null) currentNode.setPrevious(nodeToInsert);
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    private int getDLLLength(DLLNode headNode) {
        int count = 0;
        DLLNode currentNode = headNode;
        while(currentNode != null){
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }

    DLLNode DLLDelete(DLLNode headNode, int position){
        int size = getDLLLength(headNode);

        if(position > size || position < 1){
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to "+(size +1));
            return headNode;
        }

        // 첫번째 노드 삭제
        if(position == 1){
            DLLNode currentNode = headNode.getNext();
            currentNode.setPrevious(null);
            headNode = null;
            return currentNode;
        } else{ // 중간 또는 맨 끝 노드 삭제
            DLLNode previousNode = headNode;
            int count = 0;
            while(count < position -1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode lasterNode = currentNode.getNext();
            previousNode.setNext(lasterNode);
            if(lasterNode != null) lasterNode.setPrevious(previousNode);
            currentNode = null;
        }
        return headNode;
    }
}
