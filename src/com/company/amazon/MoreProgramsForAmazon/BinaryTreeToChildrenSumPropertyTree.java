package com.company.amazon.MoreProgramsForAmazon;/* Program to convert an aribitary binary tree to
   a tree that holds children sum property */
 
class ChildSumNode
{
  int data;
  ChildSumNode left;
  ChildSumNode right;
}
 
public class BinaryTreeToChildrenSumPropertyTree{
/* This function is used to increment left subtree */
 
/* Helper function that allocates a new node
 with the given data and NULL left and right
 pointers. */

/* This function changes a tree to to hold children sum
   property */
static void convertTree(ChildSumNode node)
{
  int left_data = 0,  right_data = 0, diff;
 
  /* If tree is empty or it's a leaf node then
     return true */
  if (node == null ||
     (node.left == null && node.right == null))
    return;
  else
  {
    /* convert left and right subtrees  */
    convertTree(node.left);
    convertTree(node.right);
 
    /* If left child is not present then 0 is used
       as data of left child */
    if (node.left != null)
      left_data = node.left.data;
 
    /* If right child is not present then 0 is used
      as data of right child */
    if (node.right != null)
      right_data = node.right.data;
 
    /* get the diff of node's data and children sum */
    diff = left_data + right_data - node.data;
 
    /* If node's children sum is greater than the node's data */
    if (diff > 0)
       node.data = node.data + diff;
 
    /* THIS IS TRICKY -. If node's data is greater than children sum,
      then increment subtree by diff */
    if (diff < 0)
      increment(node, -diff);  // -diff is used to make diff positive
  }
}
 
/* This function is used to increment subtree by diff */
static void increment(ChildSumNode node, int diff)
{
  /* IF left child is not NULL then increment it */
  if(node.left != null)
  {
    node.left.data = node.left.data + diff;
 
    // Recursively call to fix the descendants of node.left
    increment(node.left, diff);  
  }
  else if (node.right != null) // Else increment right child
  {
    node.right.data = node.right.data + diff;
 
    // Recursively call to fix the descendants of node.right
    increment(node.right, diff);
  }
}
 
/* Given a binary tree, printInorder() prints out its
   inorder traversal*/
static void printInorder(ChildSumNode node)
{
  if (node == null)
    return;
 
  /* first recur on left child */
  printInorder(node.left);
 
  /* then print the data of node */
  System.out.println( node.data);
 
  /* now recur on right child */
  printInorder(node.right);
}
 
static /* Helper function that allocates a new node
 with the given data and NULL left and right
 pointers. */
ChildSumNode newNode(int data)
{
	ChildSumNode node =new ChildSumNode();
	node.data = data;
  node.left = null;
  node.right = null;
  return(node);
}
 
/* Driver program to test above functions */
public static void main(String args[])
{
	ChildSumNode root = newNode(50);
  root.left        = newNode(7);
  root.right       = newNode(2);
  root.left.left  = newNode(3);
  root.left.right = newNode(5);
  root.right.left  = newNode(1);
  root.right.right = newNode(30);
 
  System.out.println("\n Inorder traversal before conversion ");
  printInorder(root);
 
  convertTree(root);
 
  System.out.println("\n Inorder traversal after conversion ");
  printInorder(root);
 
}
}