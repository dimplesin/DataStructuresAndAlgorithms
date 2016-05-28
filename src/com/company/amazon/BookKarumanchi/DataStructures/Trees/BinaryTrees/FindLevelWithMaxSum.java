package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

/**
 * Give an algorithm for finding the level that has the maximum sum in the binary tree.
 */
public class FindLevelWithMaxSum {
    int FindLevelwithMaxSum(BinaryTreeNode root){
        BinaryTreeNode temp;
        int level=0, maxLevel = 0;
        LLQueue Q = new LLQueue();
        int currentSum = 0, maxSum = 0;
        if(root == null) return 0;
        Q.enQueue(root);
        Q.enQueue(null);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            //If the current level is completed then compare sums
            if(temp == null){
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    maxLevel = level;
                }
                currentSum = 0;
                //place the indicator for end of next level at the end of the queue.
                if(!Q.isEmpty()){
                    Q.enQueue(null);
                }
                level ++;
            }else{
                currentSum += temp.getData();
                if(temp.getLeft() != null){
                    Q.enQueue(temp.getLeft());
                }
                if(temp.getRight() != null){
                    Q.enQueue(temp.getRight());
                }
            }
        }
        return maxLevel;
    }

    int FindLevelWithMaxSum(BinaryTreeNode root){
        BinaryTreeNode temp;
        int level = 0, maxLevel = 0;
        LLQueue Q = new LLQueue();
        int currentSum = 0, maxSum = 0;
        if(root == null) return 0;
        Q.enQueue(root);
        Q.enQueue(null);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode)Q.deQueue();
            if(temp == null){
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    maxLevel = level;
                }
                currentSum = 0;
                if(!Q.isEmpty()){
                    Q.enQueue(null);
                }
                level++;
            }else{
                currentSum += temp.getData();
                if(temp.getLeft() != null){
                    Q.enQueue(temp.getLeft());
                }
                if(temp.getRight()!=null){
                    Q.enQueue(temp.getRight());
                }
            }
        }
        return maxLevel;
    }
}

