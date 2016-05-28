package com.company.amazon.MoreProgramsForAmazon;

public class TreeHeightBalanced  
{  
   public static boolean isHeightBalanced(TreeNode root)  
   {  
      return (maxLeafHeight(root) - minLeafHeight(root)) <= 1;  
   }  
     
   public static int maxLeafHeight(TreeNode root)  
   {  
      if (root == null)  
      {  
         return 0;  
      }  
        
      return Math.max(maxLeafHeight(root.left), maxLeafHeight(root.getRight())) + 1;  
   }  
     
   public static int minLeafHeight(TreeNode root)  
   {  
      if (root == null)  
      {  
         return 0;  
      }  
        
      return Math.min(minLeafHeight(root.getLeft()), minLeafHeight(root.getRight())) + 1;  
   }  
} 

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
}