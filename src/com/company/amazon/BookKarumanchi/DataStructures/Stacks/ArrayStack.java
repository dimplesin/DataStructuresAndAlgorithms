package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

/**
 * Created by v-dsindhi on 4/4/15.
 */
public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack(){
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
            System.out.println("Stack Overflow");
        }else{
            array[++top] = data;
        }
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


    /*
     *
      * */
}
