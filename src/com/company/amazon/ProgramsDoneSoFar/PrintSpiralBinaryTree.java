package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
import java.util.Stack;

public class PrintSpiralBinaryTree {

    public static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data)
        {
            this.data=data;
        }
    }

    // prints spiral/zigzag level order
    public static void spiralOrZigzagLevelOrder(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> currentLevel=new Stack<TreeNode>();
        currentLevel.push(root);
        Stack<TreeNode> nextLevel=new Stack<TreeNode>();
        boolean directionflag=false;
        while(!currentLevel.isEmpty())
        {
            while(!currentLevel.isEmpty())
            {
                TreeNode tempNode=currentLevel.pop();
                System.out.print(tempNode.data);
                if(!directionflag)
                {
                    if(tempNode.left!=null)
                        nextLevel.push(tempNode.left);
                    if(tempNode.right!=null)
                        nextLevel.push(tempNode.right);
                }else
                {
                    if(tempNode.right!=null)
                        nextLevel.push(tempNode.right);
                    if(tempNode.left!=null)
                        nextLevel.push(tempNode.left);
                }
            }
            // for changing direction
            directionflag=!directionflag;
            currentLevel=nextLevel;
        }
    }
    public static void main(String[] args)
    {
        PrintSpiralBinaryTree bi=new PrintSpiralBinaryTree();
        // Creating a binary tree
        TreeNode rootNode=createBinaryTree();
        System.out.println("Spiral/Zigzag traversal of binary tree :");
        spiralOrZigzagLevelOrder(rootNode);
    }

    public static TreeNode createBinaryTree()
    {

        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);
        TreeNode node5=new TreeNode(5);
        TreeNode node55=new TreeNode(55);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;
        node10.left=node5;
        node50.right=node55;

        return rootNode;
    }
}

//Read more at http://www.java2blog.com/2014/08/spiralzigzag-level-order-traversal-of.html#lL1cZbWcJ5YcBbdt.99