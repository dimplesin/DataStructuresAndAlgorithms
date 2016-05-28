package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
public class PrintLeftViewOfBinaryTree {

    // Recursive function to print left view of a binary tree.
    static void leftViewUtil(Node root, int level, int max_level)
    {
        // Base Case
        if (root==null)  return;

        // If this is the first node of its level
        if (max_level < level)
        {
            System.out.println(root.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(root.left, level+1, max_level);
        leftViewUtil(root.right, level+1, max_level);
    }

    // A wrapper over leftViewUtil()
    static void leftView(Node root)
    {
        int max_level = 0;
        leftViewUtil(root, 1, max_level);
    }

    // Driver Program to test above functions
    public static void  main(String args[])
    {
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        leftView(root);


    }

}
