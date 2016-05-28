package com.company.amazon.MoreProgramsForAmazon;//The main function is maxSumPath() that uses above two functions to get the complete solution.

/* A tree node structure */
class MaxPathNode
{
    int data;
    MaxPathNode left;
    MaxPathNode right;
}
 
public class MaximumPathSumInBT{
// A utility function that prints all nodes on the path from root to target_leaf
static boolean printPath (MaxPathNode root, MaxPathNode target_leaf)
{
    // base case
    if (root == null)
        return false;
 
    // return true if this node is the target_leaf or target leaf is present in
    // one of its descendants
    if (root == target_leaf || printPath(root.left, target_leaf) ||
            printPath(root.right, target_leaf) )
    {
        System.out.println(root.data);
        return true;
    }
 
    return false;
}
 
// This function Sets the target_leaf_ref to refer the leaf node of the maximum 
// path sum.  Also, returns the max_sum using max_sum_ref
static void getTargetLeaf (MaxPathNode node, int max_sum_ref, int curr_sum,
		MaxPathNode target_leaf_ref)
{
    if (node == null)
        return;
 
    // Update current sum to hold sum of nodes on path from root to this node
    curr_sum = curr_sum + node.data;
 
    // If this is a leaf node and path to this node has maximum sum so far,
    // then make this node target_leaf
    if (node.left == null && node.right == null)
    {
        if (curr_sum > max_sum_ref)
        {
            max_sum_ref = curr_sum;
            target_leaf_ref = node;
        }
    }
 
    // If this is not a leaf node, then recur down to find the target_leaf
    getTargetLeaf (node.left, max_sum_ref, curr_sum, target_leaf_ref);
    getTargetLeaf (node.right, max_sum_ref, curr_sum, target_leaf_ref);
}
 
// Returns the maximum sum and prints the nodes on max sum path
static int maxSumPath (MaxPathNode node)
{
    // base case
    if (node == null)
        return 0;
    MaxPathNode target_leaf = null;
    int max_sum = Integer.MIN_VALUE;
 
    // find the target leaf and maximum sum
    getTargetLeaf (node, max_sum, 0, target_leaf);
 
    // print the path from root to the target leaf
    printPath (node, target_leaf);
 
    return max_sum;  // return maximum sum
}
 
static /* Utility function to create a new Binary Tree node */
MaxPathNode newNode (int data)
{
	MaxPathNode temp = new MaxPathNode();
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
}
 
/* Driver function to test above functions */
public static void main(String args[])
{
	MaxPathNode root = null;
 
    /* Constructing tree given in the above figure */
    root = newNode(10);
    root.left = newNode(-2);
    root.right = newNode(7);
    root.left.left = newNode(8);
    root.left.right = newNode(-4);
 
    System.out.println ("Following are the nodes on the maximum sum path \n");
    int sum = maxSumPath(root);
    System.out.println ("\nSum of the nodes is %d "+ sum);
}
}