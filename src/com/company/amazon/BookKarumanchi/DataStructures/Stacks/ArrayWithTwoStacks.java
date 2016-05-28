package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

import java.util.EmptyStackException;

/**
 * Created by v-dsindhi on 4/4/15.
 */
public class ArrayWithTwoStacks {

    private int[] dataArray;
    private int size;
    private int topOne;
    private int topTwo;
    public ArrayWithTwoStacks(int size){
        if(size<2){ throw new IllegalStateException("size < 2 is no permissible");}
        dataArray = new int[size];
        this.size = size;
        topOne = -1;
        topTwo = size;
    }
    public void push(int stackId, int data){
        if(topTwo == topOne+1) throw new StackOverflowError();
        if(stackId == 1){
            dataArray[++topOne]= data;
        }else if(stackId == 2){
            dataArray[--topTwo]=data;
        }else return;
    }

    public int pop(int stackId){
        if(stackId ==1){
            if(topOne == -1) throw new EmptyStackException();
            int toPop = dataArray[topOne];
            dataArray[topOne--] = -1;
            return toPop;
        }else if(stackId == topTwo){
            if(topTwo == this.size) throw new EmptyStackException();
            int toPop = dataArray[topTwo];
            dataArray[topTwo++] = -1;
            return toPop;
        }else{
            return -1;
        }
    }
    public int top(int stackId){
        if(stackId ==1){
            if(topOne == -1) throw new EmptyStackException();
            return dataArray[topOne] = -1;
        }else if(stackId == topTwo){
            if(topTwo == this.size) throw new EmptyStackException();
            return dataArray[topTwo];
        }else{
            return -1;
        }
    }

    public boolean isEmpty(int stackId){
        if(stackId == 1){
            return topOne == -1;
        }else if(stackId == 2){
            return topTwo==this.size;
        }else return true;
    }

}
