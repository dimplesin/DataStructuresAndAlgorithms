package com.company.amazon.BookKarumanchi.DataStructures.Hashing;

/**
 * Created by v-dsindhi on 4/2/15.
 */
    //Implement separate chaining collision resolution technique.
    class ListNode{
        private int key;
        private int data;
        private ListNode next;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

class HashTableNode{
   private int blockCount;
    private ListNode startNode;
    public int getBlockCount(){
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public ListNode getStartNode() {
        return startNode;
    }

    public void setStartNode(ListNode startNode) {
        this.startNode = startNode;
    }
}

class HashTable{
    private int tSize;
    private int count;
    private HashTableNode[] table;

    public int gettSize() {
        return tSize;
    }

    public void settSize(int tSize) {
        this.tSize = tSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HashTableNode[] getTable() {
        return table;
    }

    public void setTable(HashTableNode[] table) {
        this.table = table;
    }
}

public class HashTableOperations{
    public final static int LOADFACTOR = 20;
    public static HashTable createHashTable(int size){
        HashTable h = new HashTable();
        //count is set to zero by default
        h.settSize(size/LOADFACTOR);
        for(int i = 0; i < h.gettSize();i++){
            h.getTable()[i].setStartNode(null);
        }
        return h;
    }
    public static int hashSearch(HashTable h, int data){
        ListNode temp;
        temp = h.getTable()[Hash(data, h.gettSize())].getStartNode();
        while (temp != null){
            if(temp.getData() == data){
                return 1;
            }
            temp = temp.getNext();
        }
        return 0;
    }

    public static void hashInsert(HashTable h, int data){
        int index;
        ListNode temp, newNode;
        if(hashSearch(h, data) == 1){
            return;
        }
        index = Hash(data, h.gettSize());
        temp = (h.getTable()[index]).getStartNode().getNext();
        newNode = new ListNode();
        if(newNode == null){
            System.out.println("Memory Error");
            return;
        }
        newNode.setKey(index);
        newNode.setData(data);
        newNode.setNext((h.getTable()[index]).getStartNode().getNext());
        (h.getTable()[index]).getStartNode().setNext(newNode);
        h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount()+1);
        h.setCount(h.getCount()+1);
        if(h.getCount()/h.gettSize() > LOADFACTOR){
            Rehash(h);
        }
        return;
    }

    public static boolean hashDelete(HashTable h, int data){
        ListNode temp, prev;
        int index = Hash(data, h.gettSize());
        for(temp = h.getTable()[index].getStartNode().getNext(), prev = null; temp != null; prev = temp,temp = temp.getNext()){
            if(temp.getData() == data){
                if(prev != null){
                    prev.setNext(temp.getNext());
                }
                temp = null;
                h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount() - 1);
                h.setCount(h.getCount() - 1);
                return true;
            }
        }
        return false;
    }

    public static void Rehash(HashTable h){
        int oldsize, i, index;
        ListNode p, temp, temp2;
        HashTableNode[] oldTable;
        oldsize = h.gettSize();
        oldTable = h.getTable();
        h.settSize(h.gettSize() * 2);
        h = new HashTable();
        if(h.getTable() == null){
            System.out.println("Memory Error");
            return;
        }
        for(i =0;i < oldsize;i++){
            for(temp = oldTable[i].getStartNode().getNext(); temp != null; temp=temp.getNext()){
                index = Hash(temp.getData(), h.gettSize());
                temp2 = temp;
                temp = temp.getNext();
                temp2.setNext(h.getTable()[i].getStartNode().getNext());
                h.getTable()[index].getStartNode().setNext(temp2);
            }
        }
    }

    private static int Hash(int data, int i) {
        return 0;
    }
}
