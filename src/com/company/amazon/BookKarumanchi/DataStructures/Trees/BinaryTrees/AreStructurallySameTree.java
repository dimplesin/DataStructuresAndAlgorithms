package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Given two binary trees, return true if they are structually identical.
 */
public class AreStructurallySameTree {
    Boolean AreStructurallySameTrees(BinaryTreeNode root1, BinaryTreeNode root2){
        // both empty -> 1
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return(root1.getData() == root2.getData()
                && AreStructurallySameTrees(root1.getLeft(), root2.getLeft())
                && AreStructurallySameTrees(root1.getRight(), root2.getRight()));
    }
}
