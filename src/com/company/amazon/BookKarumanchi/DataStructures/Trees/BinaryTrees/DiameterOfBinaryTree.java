package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Give an algorithm for finding the diameter of the binary tree. The diameter of a tree (sometimes called the width) is the number of nodes
 * on the longest path between two leaves.
 */
public class DiameterOfBinaryTree {
    static int diameter;
    //Assume diameter is a static variable in class
    int DiameterOfTree(BinaryTreeNode root, int diameter){
        int left, right;
        if(root == null) return 0;
        left = DiameterOfTree(root.getLeft(), diameter);
        right = DiameterOfTree(root.getRight(), diameter);
        if(left + right > diameter){
            diameter = left + right;
        }
        return Math.max(left, right)+1;
    }
}


