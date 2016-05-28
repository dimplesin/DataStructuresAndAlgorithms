package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

/**
 * Created by v-dsindhi on 4/4/15.
 */
public class DynArrayStack {

    private int top;
    private int capacity;
    private int[] array;
    public DynArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }
    public boolean isEmpty(){
        return (top==-1);
    }

    public int isStackFull(){
        if (top==capacity-1){
            return 1;
        }
        return 0;
    }
    public void push(int data){
        if(isStackFull() == 1){
            doubleStack();
        }else{
            array[++top] = data;
        }
    }

    private void doubleStack(){
        int newArr[] = new int[capacity*2];
        System.arraycopy(array,0,newArr,0,capacity);
        capacity = capacity*2;
        array = newArr;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return 0;
        }else{
            return (array[top--]);
        }
    }
    public void DeleteStack(){
        top = -1;
    }
}
