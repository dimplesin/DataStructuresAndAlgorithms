package com.company.amazon.BookKarumanchi.DataStructures.LinkedLists;

/**
 * Created by v-dsindhi on 3/23/15.
 */
public class DLLNode {

    private Object data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    int ListLength(DLLNode headNode){
        int length = 0;
        DLLNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    //Time Complexity O(n) Space Complexity O(1)
    DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position){
        if(headNode == null){
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if(size+1 < position || position < 1 ){
            System.out.println("Position of nodetoinsert is invalid. Valid inputs are 1 to "+ (size+1));
            return headNode;
        }
        if(position == 1){
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        }else{
            DLLNode previousNode = headNode;
            int count = 1;
            while(count<position-1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if(currentNode != null){
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    //Time Complexity O(n) Space Complexity O(1)
    DLLNode DLLDelete(DLLNode headNode, int position){
        int size = ListLength(headNode);
        if(position > size || position < 1){
            System.out.println("Position of nodetoinsert is invalid. Valid inputs are 1 to "+ (size+1));
            return headNode;
        }
        if(position == 1){
            DLLNode currentNode = headNode.getNext();
            headNode = null;
            currentNode.setPrevious(null);
            return currentNode;
        }else{
            DLLNode previousNode = headNode;
            int count = 1;
            while(count < position -1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            previousNode.setNext(laterNode);
            if(laterNode != null){
                laterNode.setPrevious(previousNode);
            }
            currentNode = null;
        }
        return headNode;
    }


}
