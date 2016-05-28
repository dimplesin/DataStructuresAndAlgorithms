package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Created by v-dsindhi on 3/18/15.
 */
public class SizeOfBinaryTreeWithoutRecursion {
    int SizeOfBTUsingLevelOrder(BinaryTreeNode root) {

        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int count = 0;
        if (root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            count ++;
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
