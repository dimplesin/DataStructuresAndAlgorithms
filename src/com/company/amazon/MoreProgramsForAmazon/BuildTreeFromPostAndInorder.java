package com.company.amazon.MoreProgramsForAmazon;

class BuildTreeNode{
	int data;
	BuildTreeNode left;
	BuildTreeNode right;
	public BuildTreeNode(int rootValue) {
		this.data=rootValue;
		// TODO Auto-generated constructor stub
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BuildTreeNode getLeft() {
		return left;
	}
	public void setLeft(BuildTreeNode left) {
		this.left = left;
	}
	public BuildTreeNode getRight() {
		return right;
	}
	public void setRight(BuildTreeNode right) {
		this.right = right;
	}
}

public class BuildTreeFromPostAndInorder {
	public BuildTreeNode buildTree(int[] inorder, int[] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;
	 
		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}
	 
	public BuildTreeNode buildTree(int[] inorder, int inStart, int inEnd,
			int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
	 
		int rootValue = postorder[postEnd];
		BuildTreeNode root = new BuildTreeNode(rootValue);
	 
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
	 
		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
				postStart + k - (inStart + 1));
		// Becuase k is not the length, it it need to -(inStart+1) to get the length
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
	 
		return root;
	}
}
