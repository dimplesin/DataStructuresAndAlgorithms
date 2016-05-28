package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

/**
 * Created by v-dsindhi on 4/4/15.
 */
public class AdvanceStackGetMinimum extends LLStack {
    private LLStack elementStack = new LLStack();
    private LLStack minStack = new LLStack();
    public void push(int data){
        elementStack.push(data);
        if(minStack.isEmpty() || (Integer)minStack.top() >= (Integer)data){
            minStack.push(data);
        }else{
            minStack.push(minStack.top());
        }
    }
    public Object pop(){
        if(elementStack.isEmpty()) return null;
        minStack.pop();
        return elementStack.pop();
    }

    public int getMinimum(){
        return (Integer)minStack.top();
    }

    public Object top(){
        return elementStack.top();
    }

    public boolean isEmpty(){
        return elementStack.isEmpty();
    }

    /* Improve space complexity*/
    public void pushImproved(int data){
        elementStack.push(data);
        if(minStack.isEmpty() || (Integer)minStack.top() >= (Integer)data){
            minStack.push(data);
        }
    }
    public Object popImproves(){
        if(elementStack.isEmpty()) return null;
        Integer minTop = (Integer)minStack.top();
        Integer elementTop = (Integer)elementStack.top();
        if(minTop == elementTop){minStack.pop();}
        return elementStack.pop();
    }
}
