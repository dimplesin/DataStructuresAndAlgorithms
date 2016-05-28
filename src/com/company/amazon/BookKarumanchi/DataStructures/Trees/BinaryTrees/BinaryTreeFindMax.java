package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

/**
 * Give an algorithm for finding maximum element in binary tree
 */
public class BinaryTreeFindMax {

    public int FindMax(BinaryTreeNode root){
        int root_val, left, right, max = Integer.MIN_VALUE;
        if(root != null){
            root_val = root.getData();
            left = FindMax(root.getLeft());
            right = FindMax(root.getRight());
            if(left > right) {
                max = left;
            }else{
                max = right;
            }
            if(root_val > max){
                max = root_val;
            }
        }
        return max;
    }

    public int FindMin(BinaryTreeNode root){
        int root_val, left, right, min = Integer.MIN_VALUE;
        if(root != null){
            root_val = root.getData();
            left = FindMin(root.getLeft());
            right = FindMin(root.getRight());
            if(left < right) {
                min = left;
            }else{
                min = right;
            }
            if(root_val < min){
                min = root_val;
            }
        }
        return min;
    }
}
