package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Created by v-dsindhi on 3/17/15.
 */
public class FindInBinaryTreeWithoutUsingRecursion {

    Boolean SearchUsingLevelOrder(BinaryTreeNode root, int data){
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        if(root == null){return false;}
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            if(data == root.getData()){
                return true;
            }
            if(temp.getLeft() != null){
                Q.enQueue(temp.getLeft());
            }
            if(temp.getRight() != null){
                Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue(Q);
        return false;
    }
}
