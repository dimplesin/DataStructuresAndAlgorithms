package com.company.amazon.BookKarumanchi.DataStructures.LinkedLists;

public class LLNode {
    private Object data;
    private LLNode next;

    public LLNode(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
