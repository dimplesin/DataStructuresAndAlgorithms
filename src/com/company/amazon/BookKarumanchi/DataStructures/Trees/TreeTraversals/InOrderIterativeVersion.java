package com.company.amazon.BookKarumanchi.DataStructures.Trees.TreeTraversals;

import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by v-dsindhi on 3/17/15.
 */
public class InOrderIterativeVersion {
    static void InOrderNonRecursive(BinaryTreeNode root){
        if(root == null) return;
        Stack S = new Stack();
        while(true){
            while(root != null){
                S.push(root);
                root = root.getLeft();
            }
            if(S.isEmpty()) break;
            root = (BinaryTreeNode) S.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
        return;
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


        InOrderNonRecursive(root);

        }
}
