package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Created by v-dsindhi on 3/18/15.
 */
public class NumberOfLeavesInBinaryTree {
    int NumberOfLeavesInBinaryTreeUsingLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int count = 0;
        if(root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            if(temp.getLeft() == null && temp.getRight() == null)
                count ++;
            else{
                if(temp.getLeft() != null){
                    Q.enQueue(temp.getLeft());
                }
                if(temp.getRight() != null){
                    Q.enQueue(temp.getRight());
                }
            }
        }
        Q.deleteQueue(Q);
        return count;
    }

    /* The set of all nodes with both left and right children are called full nodes*/
    int NumberOfFullNodesInBinaryTreeUsingLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int count = 0;
        if(root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            if(temp.getLeft() != null && temp.getRight() != null)
                count ++;
            else{
                if(temp.getLeft() != null){
                    Q.enQueue(temp.getLeft());
                }
                if(temp.getRight() != null){
                    Q.enQueue(temp.getRight());
                }
            }
        }
        Q.deleteQueue(Q);
        return count;
    }

    /* Give an algorithm for finding the number of half nodes in the binary tree (nodes with only one child) without recursion.*/
    int NumberOfHalfNodesInBTUsingLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int count = 0;
        if(root == null){return 0;}
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode)Q.deQueue();
            if((temp.getLeft() == null && temp.getRight() != null) || (temp.getLeft() !=null && temp.getRight() == null)){
                count ++;
            }
            if(temp.getLeft() != null){
                Q.enQueue(temp.getLeft());
            }
            if(temp.getRight() != null){
                Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue(Q);
        return count;
    }
}
