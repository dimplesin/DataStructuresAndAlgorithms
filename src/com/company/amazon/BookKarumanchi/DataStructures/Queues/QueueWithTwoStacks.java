package com.company.amazon.BookKarumanchi.DataStructures.Queues;

import com.company.amazon.BookKarumanchi.DataStructures.Stacks.LLStack;

/**
 * Created by v-dsindhi on 3/16/15.
 */
public class QueueWithTwoStacks {
    LLStack stack1;
    LLStack stack2;
    public QueueWithTwoStacks(){
        stack1 = new LLStack();
        stack2 = new LLStack();
    }
    //default Implementation
    public boolean isEmpty(){
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty();
    }

    public void enQueue(int data){
        stack1.push(data);
    }

    public Object deQueue(){
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
