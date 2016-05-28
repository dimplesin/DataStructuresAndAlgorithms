package com.company.amazon.BookKarumanchi.DataStructures.Trees.TreeTraversals;

import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by v-dsindhi on 12/15/15.
 */
public class PostOrderIterativeUsingTwoStacks {
    // An iterative function to do post order traversal of a given binary tree
    static void postOrderIterative(BinaryTreeNode root)
    {
        // Create two stacks
        Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();

        // push root to first stack
        s1.push(root);
        BinaryTreeNode node;

        // Run while first stack is not empty
        while(!s1.isEmpty()){
            // Pop an item from s1 and push it to s2
            node = s1.pop();
            s2.push(node);

            // Push left and right children of removed item to s1
            if(node.getLeft()!=null){
                s1.push(node.getLeft());
            }
            if(node.getRight() != null){
                s1.push(node.getRight());
            }
        }


        // Print all elements of second stack
        while (!s2.isEmpty()) {
            node = s2.pop();
            System.out.print(node.getData() + "->");
        }
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


        postOrderIterative(root);

    }
}
