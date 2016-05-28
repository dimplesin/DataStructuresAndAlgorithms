package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Created by v-dsindhi on 3/18/15.
 */
public class DeletingBinaryTree {

    void DeleteBinaryTree(BinaryTreeNode root){
        if(root == null) return;
        /* First Delete both subtrees */
        DeleteBinaryTree(root.getLeft());
        DeleteBinaryTree(root.getRight());
        //Delete current node only after deleting subtrees
        root = null;
    }
}
