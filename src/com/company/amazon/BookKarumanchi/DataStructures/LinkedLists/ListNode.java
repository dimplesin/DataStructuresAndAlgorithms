package com.company.amazon.BookKarumanchi.DataStructures.LinkedLists;

/**
 * Created by v-dsindhi on 3/23/15.
 */
public class ListNode {

    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


    //Time Complexity O(n) Space Complexity O(1)
    int ListLength(ListNode headNode){
        int length = 0;
        ListNode currentNode = headNode;
        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    //Time Complexity O(n) Space Complexity O(1)
    ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position){
        if(headNode == null){
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if(position > size+1 || position < 1){
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to "+ (size+1));
            return headNode;
        }
        if(position == 1){
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }else{
            //inserting the node in the middle or end
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position-1){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    //Time Complexity O(n) Space Complexity O(1)
    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
        int size = ListLength(headNode);
        if(position > size || position < 1){
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to "+size);
            return headNode;
        }
        if(position == 1){
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return  currentNode;
        }else{
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    //Time Complexity O(n) Space Complexity O(1)
    void DeleteLinkedList(ListNode head){
        ListNode auxilaryNode, iterator = head;
        while(iterator != null){
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }
    }
}
