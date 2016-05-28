package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Created by v-dsindhi on 3/16/15.
 */
public class StackWithTwoQueues {
    LLQueue queue1;
    LLQueue queue2;
    public StackWithTwoQueues(){
        queue1 = new LLQueue();
        queue2 = new LLQueue();
    }

    public void push(int data){
        if(queue1.isEmpty())  queue2.enQueue(data);
        else  queue1.enQueue(data);
    }

    public Object Pop(){
        int i, size;
        i = 0;
        if(queue2.isEmpty()){
            size = queue1.getQueueSize();
            while(i<size-1){
                queue2.enQueue(queue1.deQueue());
                i++;
            }
            return queue1.deQueue();
        }else{
            size = queue2.getQueueSize();
            while(i<size+-1){
                queue1.enQueue(queue2.deQueue());
            }
            return queue2.deQueue();
        }
    }

}
