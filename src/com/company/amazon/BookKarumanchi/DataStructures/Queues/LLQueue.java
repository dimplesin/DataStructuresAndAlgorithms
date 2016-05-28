package com.company.amazon.BookKarumanchi.DataStructures.Queues;

import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.LLNode;

import java.util.EmptyStackException;

/* Linked List Implementation */
public class LLQueue {

    private LLNode frontNode;
    private LLNode rearNode;
    public LLQueue(){
        this.frontNode = null;
        this.rearNode = null;
    }

    public static LLQueue createQueue(){
        return  new LLQueue();
    }

    public boolean isEmpty(){
        return (frontNode == null);
    }

    public void enQueue(Object data){
        LLNode newNode = new LLNode(data);
        if(rearNode != null){
            rearNode.setNext(newNode);
        }
        rearNode = newNode;
        if(frontNode == null){
            frontNode = rearNode;
        }
    }

    public Object deQueue(){
        Object data = null;
        if(isEmpty()){
            throw new EmptyStackException(); //EmptyQueueException("Queue Empty");
        }else{
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }

    public void deleteQueue(LLQueue queue){
        while(!queue.isEmpty()){
            queue.deQueue();
        }
    }

    public int getQueueSize() {
        return 0;
    }
}
