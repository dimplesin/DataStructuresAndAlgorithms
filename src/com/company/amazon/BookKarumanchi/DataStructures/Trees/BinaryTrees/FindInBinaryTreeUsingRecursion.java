package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Give an algorithm for searching an element in binary tree
 */
public class FindInBinaryTreeUsingRecursion {

    Boolean FindInBinaryTreeUsingRecursion(BinaryTreeNode root, int data){
        Boolean temp;
        if(root == null){
            return false;
        }else {
            if (data == root.getData()) {
                return true;
            } else {
                temp = FindInBinaryTreeUsingRecursion(root.getLeft(), data);
                if (temp != true) {
                    return temp;
                } else {
                    return (FindInBinaryTreeUsingRecursion(root.getRight(), data));
                }
            }
        }
    }
}

//How many queues are needed to implement PriorityQueue
//Binary Search Tree to LinkedList.
