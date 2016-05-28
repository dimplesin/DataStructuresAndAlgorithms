package com.company.amazon.BookKarumanchi.DataStructures.Trees.TreeTraversals;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

/**
 * Created by v-dsindhi on 3/17/15.
 */
public class LevelOrderIterativeVerion {
    static void LevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        LLQueue Q =  new LLQueue();
        if(root == null){ return ; }
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            System.out.print(temp.getData());
            if(temp.getLeft() != null){Q.enQueue(temp.getLeft());}
            if(temp.getRight() != null){Q.enQueue(temp.getRight());}
        }
        Q.deleteQueue(Q);
    }

    public static void main(String args[]){

  /* Constructed binary tree is
            1
          /   \
        2      3
      /  \
    4     5
  */
        BinaryTreeNode root = new BinaryTreeNode();
        root.setData(1);

        BinaryTreeNode left = new BinaryTreeNode();
        left.setData(2);

        BinaryTreeNode right = new BinaryTreeNode();
        right.setData(3);

        BinaryTreeNode leftleft = new BinaryTreeNode();
        leftleft.setData(4);

        BinaryTreeNode leftright = new BinaryTreeNode();
        leftright.setData(5);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftleft);
        left.setRight(leftright);


        LevelOrder(root);

    }
}
