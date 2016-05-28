package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Created by v-dsindhi on 3/18/15.
 */
public class HeightOfBinaryTree {

    //With Recursion
    int HeightOfBinaryTree(BinaryTreeNode root){
        int leftHeight, rightHeight;
        if(root == null) return 0;
        else{
            leftHeight = HeightOfBinaryTree(root.getLeft());
            rightHeight = HeightOfBinaryTree(root.getRight());
            if(leftHeight > rightHeight){
                return leftHeight + 1;
            }else{
                return  rightHeight + 1;
            }
        }
    }

    //Without Recursion
    int FindHeightofBinaryTreeWithoutRecursion(BinaryTreeNode root){
        int level = 1;
        LLQueue Q = new LLQueue();
        if(root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            root = (BinaryTreeNode) Q.deQueue();
            //Compeletion of current level
            if(root == null){
                //Put another marker for next level
                if(!Q.isEmpty()) Q.enQueue(null);
                level ++;
            }
            else{
                if(root.getLeft() != null){
                    Q.enQueue(root.getLeft());
                }
                if(root.getRight() != null){
                    Q.enQueue(root.getRight());
                }
            }
        }
        return level;
    }
}
