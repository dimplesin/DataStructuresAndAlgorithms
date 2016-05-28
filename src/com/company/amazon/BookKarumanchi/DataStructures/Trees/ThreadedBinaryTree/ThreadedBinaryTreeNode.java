package com.company.amazon.BookKarumanchi.DataStructures.Trees.ThreadedBinaryTree;

import com.company.amazon.BookKarumanchi.DataStructures.Stacks.LLStack;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

/**
 * Created by v-dsindhi on 3/21/15.
 */
public class ThreadedBinaryTreeNode {
    public ThreadedBinaryTreeNode left;
    public int LTag;
    public int data;
    public int RTag;
    public ThreadedBinaryTreeNode right;

    public ThreadedBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTreeNode left) {
        this.left = left;
    }

    public int getLTag() {
        return LTag;
    }

    public void setLTag(int LTag) {
        this.LTag = LTag;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getRTag() {
        return RTag;
    }

    public void setRTag(int RTag) {
        this.RTag = RTag;
    }

    public ThreadedBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTreeNode right) {
        this.right = right;
    }

    ThreadedBinaryTreeNode InOrderSuccessor(ThreadedBinaryTreeNode P){
        ThreadedBinaryTreeNode position;
        if(P.getRTag() == 0){
            return P.getRight();
        }else{
            position = P.getRight();
            while(position.getLTag() == 1){
                position = position.getLeft();
            }
            return position;
        }
    }

    /* In order travesal in inorder Threaded Binary Tree */
    void InOrderTraversal(ThreadedBinaryTreeNode root){
        ThreadedBinaryTreeNode P = InOrderSuccessor(root);
        while (P!= root){
            P=InOrderSuccessor(P);
            System.out.println();
        }
    }

    //Alternate way of coding
    void InorderTraversal(ThreadedBinaryTreeNode root){
        ThreadedBinaryTreeNode P = root;
        while(true){
            P = InOrderSuccessor(P);
            if(P==root) return;
            System.out.println(P.getData());

        }
    }

    //Finding PreOrder Successor in InOrder Threaded Binary Tree
    ThreadedBinaryTreeNode PreorderSuccessor(ThreadedBinaryTreeNode P){
        ThreadedBinaryTreeNode Position;
        if(P.getLTag() == 1) return P.getLeft();
        else{
            Position = P;
            while(Position.getRTag() == 0){
                Position = Position.getRight();
            }
            return Position.getRight();
        }
    }

    //PreOrder traversal of InOrder Threaded Binary Tree
    void PreorderTraversal(ThreadedBinaryTreeNode root){
        ThreadedBinaryTreeNode P;
        P = PreorderSuccessor(root);
        while(P != root){
            P = PreorderSuccessor(P);
            System.out.println(P.getData());
        }
    }

    //Alternative way of coding
    void PreOrderTraversal(ThreadedBinaryTreeNode root){
        ThreadedBinaryTreeNode P = root;
        while(true){
            P = PreorderSuccessor(P);
            if(P == root) return;
            System.out.println(P.getData());
        }
    }

    /* For a binary tree (not threaded) how do we find the preorder successor.*/
    BinaryTreeNode PreorderSuccessor(BinaryTreeNode node){
        BinaryTreeNode P = null;
        LLStack S = new LLStack();
        if(node != null){
            P=node;
        }
        if(P.getLeft() != null){
            S.push(P);
            P=P.getLeft();
        }
        else{
            while(P.getRight() == null){
                P= (BinaryTreeNode) S.pop();
            }
            P=P.getRight();
        }
        return P;
    }

    /* For a binary tree (not threaded) how do we find the inorder successor.*/
    BinaryTreeNode InorderSuccessor (BinaryTreeNode node){
        BinaryTreeNode P = null;
        LLStack S = new LLStack();
        if(node != null) P=node;
        if(P.getRight() != null){
            P = (BinaryTreeNode)S.pop();
        }else{
            P = P.getRight();
            while(P.getLeft() == null){
                S.push(P);
            }
            P=P.getLeft();
        }
        return P;
    }
}
