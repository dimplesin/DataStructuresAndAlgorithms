package com.company.amazon.BookKarumanchi.DataStructures.Trees.GenericTreesN_aryTrees;


import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

/**
 * Created by v-dsindhi on 3/21/15.
 */
public class TreeNode {
    public int data;
    public TreeNode firstChild;
    public TreeNode nextSibling;
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }

    public TreeNode getFirstChild(){
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild){
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling(){
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling){
        this.nextSibling = nextSibling;
    }

    /* Given a tree, give an algorithm for finding the sum of all the elements of the tree.  */
    int FindSum(TreeNode root){
        if(root == null) return 0;
        return root.getData() + (int) FindSum(root.getFirstChild()) + (int) FindSum(root.getNextSibling());
    }

    /* Given a parent array P, where P[i] indicates the parent of ith node
     in the tree. Give an algorithm for finding the height or depth of the tree. */
    int FindDepthInGenericTree(int P[], int n){
        int maxDepth = -1, currentDepth = -1,j;
        for (int i = 0; i <n ; i++){
            currentDepth = 0; j=i;
            while(P[j] != -1){
                currentDepth++; j=P[j];
            }
            if(currentDepth > maxDepth){
                maxDepth = currentDepth;
            }
        }
        return maxDepth;
    }

    /* Given a node in the generic tree give an algorithm for counting the number of siblings for that. */
    int SiblingsCount ( TreeNode current ){
        int count = 0;
        while(current != null){
            count ++;
            current = current.getNextSibling();
        }
        return count;
    }

    /* Given two trees how do we check whether the trees are isomorphic to rach other or not. */
    boolean IsIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null) return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        return ((IsIsomorphic(root1.getLeft(), root2.getLeft())) && (IsIsomorphic(root1.getRight(), root2.getRight())));
    }

    /* Given two trees how do we check whether they are quassiIsomorphic to each other or not */
    boolean QuasiIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }
        return (QuasiIsomorphic(root1.getLeft(), root2.getLeft()) &&
                QuasiIsomorphic(root1.getRight(), root2.getRight()) &&
                QuasiIsomorphic(root1.getRight(), root2.getLeft()) &&
                QuasiIsomorphic(root1.getLeft(), root2.getRight()));
    }
    /* Given a node in generic tree, give an algorithm for counting the number of children for that node. */
    int ChildCount(TreeNode current){
        int count = 0;
        current = current.getFirstChild();
        while(current != null){
            count++;
            current = current.getFirstChild();
        }
        return count;
    }
 }

