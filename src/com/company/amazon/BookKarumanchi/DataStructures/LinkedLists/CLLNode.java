package com.company.amazon.BookKarumanchi.DataStructures.LinkedLists;

/**
 * Created by v-dsindhi on 4/4/15.
 */
public class CLLNode {

    private int data;
    private CLLNode next;

    public CLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }

    //Time Complexity O(n) Space Complexity O(1)
    int CircularListLegth(CLLNode headNode){
        int length = 0;
        CLLNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
            if(currentNode == headNode){
                break;
            }
        }
        return length;
    }

    //Time Complexity O(n) Space Complexity O(1)
    void PrintCircularListData(CLLNode headNode){
        CLLNode cllNode = headNode;
        while (cllNode != null){
            System.out.println(cllNode.getData()+"->");
            cllNode = cllNode.getNext();
            if(cllNode == headNode){break;}
        }
        System.out.println("("+cllNode.getData()+") headNode");
    }

    //Time Complexity O(n) Space Complexity O(1)
    void InsertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode == null){
            headNode = nodeToInsert;
        }else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    //Time Complexity O(n) Space Complexity O(1)
    void InsertBeginAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode == null){
            headNode = nodeToInsert;
        }else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }
    }

    //Time Complexity O(n) Space Complexity O(1)
    void DeleteLastNodeFromCLL(CLLNode head){
        CLLNode temp = head;
        CLLNode currentNode = head;
        if(head ==  null){
            System.out.println("List Empty");
            return;
        }
        while(currentNode.getNext() != head){
            temp = currentNode;
            currentNode= currentNode.getNext();
        }
        currentNode = null;
        return;
    }

    //Time Complexity O(n) Space Complexity O(1)
    void DeleteFrontNodeFromCLL(CLLNode headNode){
        CLLNode temp = headNode;
        CLLNode currentNode = headNode;
        if(headNode == null){
            System.out.println("List Empty");
            return;
        }
        while(currentNode.getNext() != headNode){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(headNode.getNext());
        headNode = headNode.getNext();
        temp = null;
        return;
    }
}
