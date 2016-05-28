package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Give an algorithm for finding maximum element in binary tree without recursion.
 */
public class BinaryTreeFindMaxWithoutRecursion {

    int FindMaxUsingLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        int max = Integer.MIN_VALUE;
        LLQueue queue = new LLQueue();
        queue.enQueue(root);
        while(!queue.isEmpty()){
            temp = (BinaryTreeNode) queue.deQueue();
            if(max < temp.getData()){
                max = temp.getData();
            }
            if(temp.getLeft() != null){
                queue.enQueue(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.enQueue(temp.getRight());
            }
        }
        queue.deleteQueue(queue);
        return max;
    }
}
