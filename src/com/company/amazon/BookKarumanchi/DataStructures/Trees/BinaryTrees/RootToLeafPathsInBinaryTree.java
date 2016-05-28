package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Given a binary tree, print out all its root-to-leaf paths
 */
public class RootToLeafPathsInBinaryTree {
    public void printPaths(){
        BinaryTreeNode node = null;
        int[] path = new int[256];
        printPaths(node, path, 0);
    }
    private void printPaths(BinaryTreeNode node, int[] path, int pathLen){
        if(node == null) return;
        //append this node to the path array
        path[pathLen] = node.getData();
        pathLen++;
        //it's a leaf so print the path that led to here.
        if(node.getLeft() == null && node.getRight() == null){
            printArray(path, pathLen);
        }else{
            // Otherwise try both subtrees
            printPaths(node.getLeft(), path, pathLen);
            printPaths(node.getRight(), path, pathLen);
        }

    }
    private void printArray(int[] path, int len){
        for(int i=0; i < len; i++){
            System.out.println(path[i] + " ");
        }
        System.out.println();
    }
}
