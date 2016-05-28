package com.company.amazon.MoreProgramsForAmazon;

import java.util.Vector;

// A O(n) solution to find LCA of two given values n1 and n2
 
// A Bianry Tree node
class BTNode
{
    int key;
    BTNode left, right;
}
 
public class LCABT{
// Utility function creates a new binary tree node with given key
static BTNode newNode(int k)
{
	BTNode temp = new BTNode();
    temp.key = k;
    temp.left = temp.right = null;
    return temp;
}
 
// Finds the path from root node to given root of the tree, Stores the
// path in a vector path[], returns true if path exists otherwise false
static boolean findPath(BTNode root, int[] path, int k)
{
    // base case
    if (root == null) return false;
 
    // Store this node in path vector. The node will be removed if
    // not in path from root to k
    path[0] = root.key;
 
    // See if the k is same as root's key
    if (root.key == k)
        return true;
 
    // Check if k is found in left or right sub-tree
    if ( (root.left != null && findPath(root.left, path, k)) ||
         (root.right != null && findPath(root.right, path, k)) )
        return true;
 
    // If not present in subtree rooted with root, remove root from
    // path[] and return false
    return false;
}
 
static // Returns LCA if node n1, n2 are present in the given binary tree,
// otherwise return -1
int findLCA(BTNode root, int n1, int n2)
{
    // to store paths to n1 and n2 from the root
    int[] path1 = null, path2 = null;
 
    // Find paths from root to n1 and root to n1. If either n1 or n2
    // is not present, return -1
    if ( !findPath(root, path1, n1) || !findPath(root, path2, n2))
          return -1;
 
    /* Compare the paths to get the first different value */
    int i;
    for (i = 0; i < path1.length && i < path2.length ; i++)
        if (path1[i] != path2[i])
            break;
    return path1[i-1];
}
 
// Driver program to test above functions
public static void main(String args[])
{
    // Let us create the Binary Tree shown in above diagram.
    BTNode root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    System.out.println(findLCA(root, 4, 5));
    System.out.println(findLCA(root, 4, 6));
    System.out.println(findLCA(root, 3, 4));
    System.out.println(findLCA(root, 2, 4));
}
}