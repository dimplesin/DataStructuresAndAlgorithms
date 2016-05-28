package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Give an algorithm for inserting an element into binary tree.
 */
public class InsertInBinaryTree {

    void InsertInBinaryTree(BinaryTreeNode root, int data){
        LLQueue Q = new LLQueue();
        BinaryTreeNode temp;
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setLeft(null);
        newNode.setRight(null);
        if(newNode == null){
            System.out.println("Memmory Error");
            return;
        }
        if(root == null){
            root = newNode;
            return;
        }
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            if(temp.getLeft() != null)
                Q.enQueue(temp.getLeft());
            else{
                temp.setLeft(newNode);
                Q.deleteQueue(Q);
                return;
            }
            if(temp.getRight() != null){
                Q.enQueue(temp.getRight());
            }else{
                temp.setRight(newNode);
                Q.deleteQueue(Q);
                return;
            }
        }
        Q.deleteQueue(Q);
    }
}
