package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Created by v-dsindhi on 3/18/15.
 */
public class FindingSizeOfBinaryTree {

    int SizeOfBinaryTree(BinaryTreeNode root){
        if(root == null) return 0;
        else return (SizeOfBinaryTree(root.getLeft()) +1 + SizeOfBinaryTree(root.getRight()));
    }
}
