package com.company.amazon.BookKarumanchi.DataStructures.Trees.AVLTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinarySearchTrees.BinarySearchTreeNode;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

/**
 * Created by v-dsindhi on 3/24/15.
 */
public class AVLTreeProblems {

    /* Given a height h, give an algorithm for generating the HB(0) */
    BinarySearchTreeNode BuildHB0(int h) {
        BinarySearchTreeNode temp;
        if (h == 0) {
            return null;
        }
        temp = new BinarySearchTreeNode();
        temp.setLeft(BuildHB0(h - 1));
        temp.setData(temp.getData() + 1);
        temp.setRight(BuildHB0(h - 1));
        return temp;
    }

    /* Given a Binary Search Tree check whether it is an AVL tree or not? */
    int IsAVL(BinarySearchTreeNode root) {
        int left, right;
        if (root == null) return 0;
        left = IsAVL(root.getLeft());
        if (left == -1) {
            return left;
        }
        right = IsAVL(root.getRight());
        if (right == -1) {
            return right;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /* Given a height h, give an algorithm for generating an AVL ree with minimum number of nodes */
    AVLTreeNode GenerateAVLTree(int h) {
        AVLTreeNode temp;
        if (h == 0) {
            return null;
        }
        temp = new AVLTreeNode();
        temp.setLeft(GenerateAVLTree(h - 1));
        temp.setData(temp.getData() + 1);
        temp.setRight(GenerateAVLTree(h - 2));
        temp.setHeight(temp.getLeft().getHeight() + 1);
        return temp;
    }

    /* Given an AVL tree with n integer items and two integers a and b, where a and b can be any integers with a<=b. Implement an algorithm
    * to count the number of nodes in the range [a, b]*/
    int RangeCount(AVLTreeNode root, int a, int b) {
        if (root == null) return 0;
        else if (root.getData() > b) {
            return RangeCount(root.getLeft(), a, b);
        } else if (root.getData() < a) {
            return RangeCount(root.getRight(), a, b);
        } else if (root.getData() >= a && root.getData() <= b) {
            return RangeCount(root.getLeft(), a, b) + RangeCount(root.getRight(), a, b) + 1;
        }
        return 0;
    }

    /* Given a binary tree, how do you remove all the half nodes (which has only one child)? Note that we should not touch the leaves. */
    BinaryTreeNode removeHalfNodes(BinaryTreeNode root) {
        if (root == null) return null;
        root.setLeft(removeHalfNodes(root.getLeft()));
        root.setRight(removeHalfNodes(root.getRight()));
        if (root.getLeft() == null && root.getRight() == null) return root;
        if (root.getLeft() == null) return root.getRight();
        if (root.getRight() == null) return root.getLeft();
        return root;
    }

    /* Given a binary tree, how do you remove leaves of it. */
    BinaryTreeNode removeLeaves(BinaryTreeNode root) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } else {
                root.setLeft(removeLeaves(root.getLeft()));
                root.setRight(removeLeaves(root.getRight()));
            }
        }
        return root;
    }

    /* Given a BST and two integers (minimum and maximum integers) as parameters,
     how do you remove prune elements from the tree any element that are not within that range, inclusive  */
    BinarySearchTreeNode PruneBST(BinarySearchTreeNode root, int A, int B){
        if(root == null) return null;
        root.setLeft(PruneBST(root.getLeft(), A, B));
        root.setRight(PruneBST(root.getRight(), A, B));
        if(A<= root.getData() && root.getData()<=B){
            return root;
        }
        if(root.getData() < A){
            return root.getRight();
        }
        if(root.getData() > B){
            return root.getLeft();
        }
        return root;
    }

    /* Given a binary tree how do you connect all the adjacent nodes at the same level ?
    Assume that given binary tree has next pointer along with left and right pointers. */


    /* kth smallest operation can be defined as :*/
    BinarySearchTreeNode KthSmallest (BinarySearchTreeNode X, int K){
        int r = X.getLeft().getData() + 1;  //size(X.getLeft()) + 1;
        if(K == r){ return X;}
        if(K < r) return KthSmallest(X.getLeft(), K);
        if( K > r) return KthSmallest(X.getRight(), K);
        return X;
    }
}
