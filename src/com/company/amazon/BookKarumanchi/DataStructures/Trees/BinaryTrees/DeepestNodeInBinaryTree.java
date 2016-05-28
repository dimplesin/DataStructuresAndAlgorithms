package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Created by v-dsindhi on 3/18/15.
 */
public class DeepestNodeInBinaryTree {

    BinaryTreeNode DeepestNodeInBinaryTree(BinaryTreeNode root){
        BinaryTreeNode temp = null;
        LLQueue Q = new LLQueue();
        if(root == null) return null;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            if(temp.getLeft() != null){
                Q.enQueue(temp.getLeft());
            }
            if(temp.getRight() != null){
                Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue(Q);
        return temp;
    }
}
