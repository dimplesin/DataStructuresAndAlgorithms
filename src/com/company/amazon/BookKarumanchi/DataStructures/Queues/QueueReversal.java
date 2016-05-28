package com.company.amazon.BookKarumanchi.DataStructures.Queues;/* Reversal Queue */

import com.company.amazon.BookKarumanchi.DataStructures.Stacks.LLStack;

public class QueueReversal {

    public static ArrayQueue reverseQueue(ArrayQueue queue){
        LLStack stack = new LLStack();
        while(!queue.isEmpty()){
            stack.push(queue.deQueue());
        }
        while(!stack.isEmpty()){
            queue.enQueue((Integer) stack.pop());
        }
        return queue;
    }
}
