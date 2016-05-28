package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinarySearchTrees;

/**
 * Created by v-dsindhi on 3/21/15.
 */
public class BinarySearchTreeNode {
    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    /* Finding an element in Binary Search Trees */
    BinarySearchTreeNode Find(BinarySearchTreeNode root, int data){
        if(root == null){
            return null;
        }
        if(data < root.getData()){
            return Find(root.getLeft(), data);
        }else if(data > root.getData()){
            return Find(root.getRight(), data);
        }
        return root;
    }

    //Non Recursive Version of the above algorithm
    BinarySearchTreeNode FindInBinaryTree(BinarySearchTreeNode root, int data){
        if(root == null) return null;
        while(root != null){
            if(data == root.getData()){return root;}
            else if(data > root.getData()){
                root = root.getRight();
            }else{root = root.getLeft();}
        }
        return null;
    }

    /* Finding minimum element in Binary Search Trees. */
    BinarySearchTreeNode FindMin(BinarySearchTreeNode root){
        if(root == null) return null;
        else{
            if(root.getLeft() == null) return root;
            else return FindMin(root.getLeft());
        }
    }

    /* Non recursive version */
    BinarySearchTreeNode FindMinNonRecursive(BinarySearchTreeNode root) {
        if (root == null) return null;
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }

    /* Finding Maximum element in BinarySEarchTree */
    BinarySearchTreeNode FindMax(BinarySearchTreeNode root){
        if(root == null) return null;
        else{
            if(root.getRight() == null) return root;
            else return FindMax(root.getRight());
        }
    }

    /* Non Recursive Version */
    BinarySearchTreeNode FindMaxNonRecursive(BinarySearchTreeNode root){
        if(root == null) return null;
        while(root.getRight() != null) root = root.getRight();
        return root;
    }

    /* Inserting an element in Binary Search Tree */
    BinarySearchTreeNode Insert(BinarySearchTreeNode root, int data){
        if(root == null){
            root = new BinarySearchTreeNode();
            if(root == null){
                System.out.println("Memory Error");
                return null;
            }else{
                root.setData(data);
                root.setLeft(null); root.setRight(null);
            }
        }else{
            if(data > root.getData()){
                root.setLeft(Insert(root.getLeft(), data));
            }else if(data > root.getData()){
                root.setRight(Insert(root.getRight(), data));
            }
        }
        return root;
    }

    /* Deleting an Element from Binary Search Tree. */
    BinarySearchTreeNode Delete(BinarySearchTreeNode root, int data){
        BinarySearchTreeNode temp;
        if(root == null) System.out.println("Element not there in tree.");
        else if (data <root.getData()) { root.left = Delete(root.getLeft(), data); }
        else if(data > root.getData()) { root.right = Delete(root.getRight(), data); }
        else{//Found Element
            if(root.getLeft() != null && root.getRight() != null){
                /* Replace with largest in left subtree */
                temp = FindMax(root.getLeft());
                root.data = temp.data;
                root.left = Delete(root.getLeft(), root.getData());
            }else{  /* One child */
                temp = root;
                if(root.getLeft() == null) root = root.getRight();
                if(root.getRight() == null) root = root.getLeft();
                temp = null;
            }
        }
        return root;
    }
}
