package com.company.amazon.BookKarumanchi.DataStructures.Stacks;

import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.LLNode;

import java.util.EmptyStackException;

public class LLStack{

    private LLNode headNode;
    public LLStack(){
        this.headNode = new LLNode(Integer.parseInt(null));
    }

    public void push(Object data){
        if(headNode == null){
            headNode = new LLNode(data);
        }else if(headNode.getData() == null){
            headNode.setData(data);
        }else{
            LLNode llNode = new LLNode(data);
            llNode.setNext(headNode);
            headNode = llNode;
        }
    }

    public Object top(){
        if(headNode == null){return null;}
        else return headNode.getData();
    }

    public Object pop(){
        if(headNode == null){
            throw new EmptyStackException();
        }else{
            Object data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public boolean isEmpty(){
        if(headNode == null) return true;
        else return false;
    }

    public void deleteStack(){
        headNode = null;
    }
}
