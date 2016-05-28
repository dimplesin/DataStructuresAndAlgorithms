package com.company.amazon.MoreProgramsForAmazon;

public class SiblingPointersInATree {

	void connect(SibNode parent)
	{
	    if (parent == null)
	        return;
	 
	    // Sibling for the right child will lie in children
	    // of current parent's sibling
	    // We need to find this distant cousin, even if current
	    // parent's right child is null
	 
	    SibNode siblingOfRightChild = null;
	    SibNode uncle = parent.sibling;
	    while (uncle != null)
	    {
	        if (uncle.left != null) // Give preference to left child
	        {
	            siblingOfRightChild = uncle.left;
	            break;
	        }
	        if (uncle.right != null) // Consider right child, if left is null
	        {
	            siblingOfRightChild = uncle.right;
	            break;
	        }
	        // Uncle does not have any children, move to next uncle
	        uncle = uncle.sibling;
	    }
	    
	    if (parent.left != null)
	    {
	        if (parent.right != null)
	            parent.left.sibling = parent.right;
	        else
	            parent.left.sibling = siblingOfRightChild;
	    }
	 
	    if (parent.right != null)
	        parent.right.sibling = siblingOfRightChild;
	 
	    connect(parent.left);
	    connect(parent.right);
	}
}
class SibNode{
    SibNode sibling;
	int data;
	SibNode right;
	SibNode left;
}