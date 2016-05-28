package com.company.amazon.MoreProgramsForAmazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class ListNode
{
	public int data;
	public ListNode Next;

	public ListNode(){

	}

	public ListNode(int data) {
		this.data = data;
		this.Next = null;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return Next;
	}
	public void setNext(ListNode next) {
		Next = next;
	}
	
}

class TreeNewNode
{
	public int Data ;
	public TreeNewNode Left;
	public TreeNewNode Right;
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	public TreeNewNode getLeft() {
		return Left;
	}
	public void setLeft(TreeNewNode left) {
		Left = left;
	}
	public TreeNewNode getRight() {
		return Right;
	}
	public void setRight(TreeNewNode right) {
		Right = right;
	}
}

public class CreateLevelWiseList {
public static List<ListNode> CreateLevelList(TreeNewNode root)
{
	
	List<ListNode> result = new ArrayList<ListNode>();

	if(root == null) 
	{
		return result;
	}

	Queue<TreeNewNode> queue = new ArrayDeque<>();//   (Queue<TreeNewNode>) new ArrayList<TreeNewNode>();
	
	// Using null as the marker of a new level
	queue.add(root);
	queue.add(null);

	
	ListNode head = new ListNode();
	ListNode tail = head;

	while(queue.size() > 0)
	{
		TreeNewNode node = queue.remove();
		
		if(node == null)
		{
			result.add(head);
			head = new ListNode();
			tail = head;

			queue.add(null);
		}
		else
		{
			int Data = node.Data;
			tail.Next = new ListNode(Data);
			tail = tail.Next;

			if(node.Left != null) 
				queue.add(node.Left);

			if(node.Right != null)
				queue.add(node.Right);
		}

		
	}

	return result;
}
}