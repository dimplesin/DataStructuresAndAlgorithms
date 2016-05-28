package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/13/15.
 */
public class FindDepthOfNodeInBinaryTree {

    /* A tree node structure */
    static class node
    {
        int data;
        node left;
        node right;
    }

    /* Helper function for getLevel().  It returns level of the data if data is
       present in tree, otherwise returns 0.*/
    static int getLevelUtil(node node, int data, int level)
    {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        int downlevel = getLevelUtil(node.left, data, level+1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevelUtil(node.right, data, level+1);
        return downlevel;
    }

    /* Returns level of given data value */
    static int getLevel(node node, int data)
    {
        return getLevelUtil(node,data,1);
    }

    /* Utility function to create a new Binary Tree node */
    static node newNode(int data)
    {
        node temp = new node();
        temp.data = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }

    /* Driver function to test above functions */
    public static void main(String args[])
    {
        node root = new node();
        int x;

    /* Constructing tree given in the above figure */
        root = newNode(3);
        root.left = newNode(2);
        root.right = newNode(5);
        root.left.left = newNode(1);
        root.left.right = newNode(4);

        for (x = 1; x <=5; x++)
        {
            int level = getLevel(root, x);
            if (level != -1)
                System.out.println(" Level of %d is %d\n"+ x+" " +getLevel(root, x));
            else
                System.out.println(x + "  is not present in tree \n");

        }
    }
    /*Run on IDE
    Output:

    Level of 1 is 3
    Level of 2 is 2
    Level of 3 is 1
    Level of 4 is 3
    Level of 5 is 2
    Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.*/
}
