package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/24/15.
 */
public class BoundaryTravesalOfBinaryTree {

    // A simple function to print leaf nodes of a binary tree
    static void printLeaves(TreeNode root)
    {
        if ( root != null )
        {
            printLeaves(root.getLeft());

            // Print it if it is a leaf node
            if ( (root.getLeft()==null)  &&  (root.getRight()==null) )
                System.out.println(root.getData());

            printLeaves(root.getRight());
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
// Print the nodes in TOP DOWN manner
    static void printBoundaryLeft(TreeNode root)
    {
        if (root!= null)
        {
            if (root.getLeft() != null)
            {
                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(root.getData());
                printBoundaryLeft(root.getLeft());
            }
            else if( root.getRight()!=null )
            {
                System.out.println(root.getData());
                printBoundaryLeft(root.getRight());
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
// Print the nodes in BOTTOM UP manner
    static void printBoundaryRight(TreeNode root)
    {
        if (root != null)
        {
            if ( root.getRight()!=null )
            {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(root.getRight());
                System.out.println(root.getData());
            }
            else if ( root.getLeft()!=null )
            {
                printBoundaryRight(root.getLeft());
                System.out.println(root.getData());
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }


    // A function to do boundary traversal of a given binary tree
    static void printBoundary(TreeNode root)
    {
        if (root != null)
        {
            System.out.println(root.getData());

            // Print the left boundary in top-down manner.
            printBoundaryLeft(root.getLeft());

            // Print all leaf nodes
            printLeaves(root.getLeft());
            printLeaves(root.getRight());

            // Print the right boundary in bottom-up manner
            printBoundaryRight(root.getRight());
        }
    }



    // Driver program to test above functions
    public static void main(String args[])
    {
        // Let us construct the tree given in the above diagram
        TreeNode root = new TreeNode(20);
        TreeNode left = new TreeNode(8);
       TreeNode leftleft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(12);
        TreeNode leftRightleft = new TreeNode(10);
        TreeNode leftRightright = new TreeNode(14);
        TreeNode right = new TreeNode(22);
        TreeNode rightRight = new TreeNode(25);

        root.setLeft(left);
        root.setRight(right);
        root.getLeft().setLeft(leftleft);
        root.getLeft().setRight(leftRight);
        root.getLeft().getRight().setLeft(leftRightleft);
        root.getLeft().getRight().setRight(leftRightright);

        root.getRight().setRight(rightRight);

        printBoundary( root );

    }
}
