package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Created by v-dsindhi on 3/16/15.
 */
public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }

    public void setLeft(BinaryTreeNode left){
        this.left = left;
    }

    public BinaryTreeNode getRight(){
        return right;
    }

    public void setRight(BinaryTreeNode right){
        this.right = right;
    }
}
