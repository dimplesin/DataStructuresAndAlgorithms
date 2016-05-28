package com.company.amazon.BookKarumanchi.DataStructures.Trees.AVLTrees;

/**
 * Created by v-dsindhi on 3/24/15.
 */
public class AVLTreeNode {
    private int data;
    private int height;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }

    /* finding the height of an AVL Tree */
    int Height(AVLTreeNode root){
        if(root == null) return -1;
        else return root.getHeight();
    }

    /* Single Rotations Left Left Rotation Case 1 */
    AVLTreeNode SingleRotateLeft(AVLTreeNode X){
        AVLTreeNode W = X.getLeft();

        X.setLeft(W.getRight());
        W.setRight(X);

        X.setHeight(Math.max(Height(X.getLeft()), Height(X.getRight())+1));
        W.setHeight(Math.max(Height(W.getLeft()), X.getHeight())+1);

        return W; /* New Root */
    }

    /* Right Right Rotation Case 4 */
    AVLTreeNode SingleRotateRight(AVLTreeNode W){
        AVLTreeNode X = W.getRight();

        W.setRight(X.getLeft());
        X.setLeft(W);

        W.setHeight(Math.max(Height(W.getLeft()), Height(W.getRight()))+1);
        X.setHeight(Math.max(Height(X.getRight()), W.getHeight())+1);

        return X;
    }

    /* Left Right Rotation (LR Rotation) */
    AVLTreeNode DoubleRotatewithLeft(AVLTreeNode Z){
        Z.setLeft(SingleRotateRight(Z.getLeft()));
        return SingleRotateLeft(Z);
    }

    /* Insertion into an AVL Tree */
    AVLTreeNode Insert(AVLTreeNode root, AVLTreeNode parent, int data){
        if(root == null) {
            root = new AVLTreeNode();
            root.setData(data);
            root.setHeight(0);
            root.setLeft(null);
            root.setRight(null);
        }else if(data < root.getData()){
            root.setLeft(Insert(root.getLeft(), root, data));
            if(Height(root.getLeft()) - Height(root.getRight()) == 2){
                if(data< root.getLeft().getData()){
                    root = SingleRotateLeft(root);
                }else{
                    root = SingleRotateRight(root);
                }
            }
        }else if( data > root.getData()){
            root.setRight(Insert(root.getRight(), root, data));
            if(Height(root.getRight()) - Height(root.getLeft()) == 2) {
                if (data < root.getRight().getData()) {
                    root = SingleRotateRight(root);
                } else {
                    root = SingleRotateLeft(root);
                }
            }
        }
        /* Else data is in the tree already. We'll do nothing */
        root.setHeight(Math.max(Height(root.getLeft()), Height(root.getRight()))+1);
        return root;
    }
}
