package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;
import com.company.amazon.BookKarumanchi.DataStructures.Stacks.LLStack;

/**
 * Give an algorithm for printing the level order data in reverse order
 */
public class BinaryTreeLevelOrderTraversalInReverse {
    void LevelOrderTraversalInReverse(BinaryTreeNode root){
        LLQueue Q = new LLQueue();
        LLStack S = new LLStack();
        BinaryTreeNode temp;
        if(root == null) return;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            if(temp.getRight() != null){
                Q.enQueue(temp.getRight());
            }if(temp.getLeft() != null){
                Q.enQueue(temp.getLeft());
            }
            S.push(temp);
        }
        System.out.println(((BinaryTreeNode)S.pop()).getData());
    }
}
