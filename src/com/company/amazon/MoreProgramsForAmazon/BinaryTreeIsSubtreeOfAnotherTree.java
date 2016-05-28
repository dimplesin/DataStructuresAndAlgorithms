package com.company.amazon.MoreProgramsForAmazon;

public class BinaryTreeIsSubtreeOfAnotherTree {
	
	 
	/* A utility function to check whether trees with roots as root1 and
	   root2 are identical or not */
	static boolean areIdentical(BTreeNode root1, BTreeNode root2)
	
	{
	    /* base cases */
	    if (root1 == null && root2 == null)
	        return true;
	 
	    if (root1 == null || root2 == null)
	        return false;
	 
	    /* Check if the data of both roots is same and data of left and right
	       subtrees are also same */
	    return (root1.data == root2.data   &&
	            areIdentical(root1.left, root2.left) &&
	            areIdentical(root1.right, root2.right) );
	}
	 
	 
	/* This function returns true if S is a subtree of T, otherwise false */
	static boolean isSubtree(BTreeNode T, BTreeNode S)
	{
	    /* base cases */
	    if (S == null)
	        return true;
	 
	    if (T == null)
	        return false;
	 
	    /* Check the tree with root as current node */
	    if (areIdentical(T, S))
	        return true;
	 
	    /* If the tree with root as current node doesn't match then
	       try left and right subtrees one by one */
	    return isSubtree(T.left, S) ||
	           isSubtree(T.right, S);
	}
	 
	 
	/* Helper function that allocates a new node with the given data
	   and null left and right pointers. */
	static BTreeNode newNode(int data)
	{
	    BTreeNode node = new BTreeNode();
	    node.data  = data;
	    node.left  = null;
	    node.right = null;
	    return(node);
	}
	 
	/* Driver program to test above function */
	public static void main(String args[])
	{
	    /* Construct the following tree
	              26
	            /   \
	          10     3
	        /    \     \
	      4      6      3
	       \
	        30
	    */
		BTreeNode T        = newNode(26);
	    T.right              = newNode(3);
	    T.right.right       = newNode(3);
	    T.left               = newNode(10);
	    T.left.left         = newNode(4);
	    T.left.left.right  = newNode(30);
	    T.left.right        = newNode(6);
	 
	    /* Construct the following tree
	          10
	        /    \
	      4      6
	       \
	        30
	    */
	    BTreeNode S    = newNode(10);
	    S.right          = newNode(6);
	    S.left           = newNode(4);
	    S.left.right    = newNode(30);
	 
	 
	    if (isSubtree(T, S))
	        System.out.println("Tree S is subtree of tree T");
	    else
	    	System.out.println("Tree S is not a subtree of tree T");
	}
}
