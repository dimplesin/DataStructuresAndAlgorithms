package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
public class BinarySearchTreeInsertFromArray {

    /* Inserting an element in Binary Search Tree */
    static BinarySearchTreeNode Insert(BinarySearchTreeNode root, int data){
        if(root == null){
            root = new BinarySearchTreeNode();
            if(root == null){
                System.out.println("Memory Error");
                return null;
            }else{
                root.setData(data);
                root.setLeft(null); root.setRight(null);
            }
        }else{
            if(data < root.getData()){
                root.setLeft(Insert(root.getLeft(), data));
            }else if(data > root.getData()){
                root.setRight(Insert(root.getRight(), data));
            }
        }
        return root;
    }


    public static void main(String args[]){
        int arr[] = {5,34,43,5,6,7,2,3,5};
        BinarySearchTreeNode newNode = null;
        for(int i=0;i<arr.length;i++) {
            Insert(newNode, arr[i]);
        }
    }
}

class BinarySearchTreeNode {
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }
}