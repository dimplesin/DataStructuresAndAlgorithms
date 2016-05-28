package com.company.amazon.ProgramsDoneSoFar;

class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    TreeNode(int data){this.data = data;}
    public int getData(){return data;}
    public void setData(int data){this.data = data;}
    public TreeNode getLeft(){return left;}
    public void setLeft(TreeNode left){this.left = left;}
    public TreeNode getRight(){return right;}
    public void setRight(TreeNode right){this.right = right;}
}
public class BTreeToList {
    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(12);
        TreeNode r = new TreeNode(15);
        TreeNode ll = new TreeNode(25);
        TreeNode lr = new TreeNode(30);
        TreeNode rl = new TreeNode(36);

        root.setLeft(l);
        root.setRight(r);
        l.setLeft(ll);
        l.setRight(lr);
        r.setLeft(rl);
        printLL(btreeToList(root));
    }

    public static void printLL(TreeNode root){
        while(root != null){
            if(root.getRight()!=null) {
                System.out.print(root.getData()+ "->");
            }else{
                System.out.print(root.getData());
            }
            root = root.getRight();
        }
    }

    public static TreeNode btreeToList(TreeNode root){
        TreeNode head = btreeToListUtil(root);
        while(head.getLeft() != null){
            head = head.getLeft();
        }
        return head;
    }

    private static TreeNode btreeToListUtil(TreeNode root){
        if( root == null) {
            return null;
        }
        if(root.getLeft() != null){
            TreeNode leftTreeNode = btreeToListUtil(root.getLeft());
            while(leftTreeNode.getRight() != null){
                leftTreeNode = leftTreeNode.getRight();
            }
            leftTreeNode.setRight(root);
            root.setLeft(leftTreeNode);
        }
        if(root.getRight() != null){
            TreeNode rightTreeNode = btreeToListUtil(root.getRight());
            while(rightTreeNode.getLeft() != null){
                rightTreeNode = rightTreeNode.getLeft();
            }
            rightTreeNode.setLeft(root);
            root.setRight(rightTreeNode);
        }
        return root;
    }
}

