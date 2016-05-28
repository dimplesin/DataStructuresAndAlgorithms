package com.company.amazon.BookKarumanchi.DataStructures.Queues;

import java.util.Stack;

/**
 * Created by v-dsindhi on 3/16/15.
 */
public class InterLeavingQueue {

    public void interLeavingQueue(ArrayQueue q){
        if(q.getQueueSize()%2 != 0){
            throw new IllegalArgumentException();
        }

        Stack<Integer> s = new Stack<Integer>();
        int halfSize = q.getQueueSize()/2;
        for(int i=0; i < halfSize; i++){
            s.push(q.deQueue());
        }
        while(!s.isEmpty()){
            q.enQueue(s.pop());
        }
        for(int i =0 ; i <halfSize; i++){
            q.enQueue(q.deQueue());
        }
        for(int i =0 ; i <halfSize; i++){
            s.push(q.deQueue());
        }
        while(!s.isEmpty()){
            q.enQueue(s.pop());
            q.enQueue(q.deQueue());
        }
    }
}
