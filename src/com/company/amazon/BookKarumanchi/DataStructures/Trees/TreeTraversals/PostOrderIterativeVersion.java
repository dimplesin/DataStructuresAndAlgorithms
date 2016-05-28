package com.company.amazon.BookKarumanchi.DataStructures.Trees.TreeTraversals;

import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

import java.util.Stack;

/**
 * Created by v-dsindhi on 3/17/15.
 */
public class PostOrderIterativeVersion {

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


     // An iterative function to do postorder traversal of a given binary tree
    static void postOrderIterative(BinaryTreeNode root)
    {
        // Check for empty tree
        if (root == null)
            return;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        do
        {
            // Move to leftmost node
            while (root!=null)
            {
                // Push root's right child and then root to stack.
                if (root.getRight()!= null)
                    stack.push(root.getRight());

                stack.push(root);

                // Set root as root's left child
                root = root.getLeft();
            }

            // Pop an item from stack and set it as root
            root = stack.pop();

            // If the popped item has a right child and the right child is not
            // processed yet, then make sure right child is processed before root
            if (root.getRight()!=null && !stack.isEmpty() && stack.peek() == root.getRight())
            {
                stack.pop();  // remove right child from stack
                stack.push(root);  // push root back to stack
                root = root.getRight(); // change root so that the right
                // child is processed next
            }
            else  // Else print root's data and set root as NULL
            {
                System.out.println(root.getData() + "->");
                root = null;
            }
        } while (!stack.isEmpty());
    }
}
