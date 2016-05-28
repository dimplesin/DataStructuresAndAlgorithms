package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinarySearchTrees;

import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.DLLNode;
import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.LinkedListProblems;
import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.ListNode;
import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeFindMax;
import com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees.BinaryTreeNode;

/**
 * Created by v-dsindhi on 3/23/15.
 */
public class BinarySearchTreeProblems {

    /* Given pointers to two nodes in a binary search tree, find lowest common ancestor. Assume that both values exists in tree. */
    BinarySearchTreeNode FindLCA(BinarySearchTreeNode root, BinarySearchTreeNode alpha, BinarySearchTreeNode beta){
        while(true){
            if((alpha.getData() < root.getData() && beta.getData() > root.getData()) ||
            (alpha.getData() > root.getData() && beta.getData() < root.getData())){
                return root;
            }
            if(alpha.getData() < root.getData())  root = root.getLeft();
            else root = root.getRight();
        }
    }

    /* Give an algorithm to check whether the given binary tree is a BST or not. */
    int isBST(BinaryTreeNode root){
        int left, right;
        if(root == null){
            return 1;
        }
        /* false if left is > root */
        if(root.getLeft() != null && root.getLeft().getData() > root.getData()){
            return 0;
        }
        /* false if right is < root */
        if(root.getRight() != null && root.getRight().getData() < root.getData()){
            return 0;
        }
        /* false if recursively, the left or right is not a BST */
        if((isBST((BinaryTreeNode) root.getLeft()) != 1) || (isBST((BinaryTreeNode) root.getRight()) != 1)){
            return 0;
        }
        /* passing all that is a BST */
        return 1;
    }  // this approach is wrong as this will return true for binary tree 1->2->9-->6->8

    /* Correct Algorithm for checking Binary Search Tree. */
    int isBSTCorrectAlgo(BinaryTreeNode root){
        BinaryTreeFindMax binaryTreeFindMax = new BinaryTreeFindMax();
        if(root == null) return 1;

        if(root.getLeft() != null && binaryTreeFindMax.FindMax(root.getLeft()) > root.getData()){
            return 0;
        }
        if(root.getRight() != null && binaryTreeFindMax.FindMin(root.getLeft()) > root.getData()){
            return 0;
        }
        if(isBSTCorrectAlgo(root.getLeft()) != 1 || isBSTCorrectAlgo(root.getRight()) != 1){
            return 0;
        }
        return 1;
    }

    //Give an algorithm for converting BST to circular DLL with space complexity O(1)
    BinarySearchTreeNode BST2DLL(BinarySearchTreeNode root, BinarySearchTreeNode Ltail){
        BinarySearchTreeNode left, ltail = null, right, rtail = null;
        if(root == null){
            ltail = null;
            return null;
        }
        left = BST2DLL(root.getLeft(), ltail);
        right = BST2DLL(root.getRight(), rtail);
        root.setLeft(ltail);
        root.setRight(rtail);
        if(right == null) ltail = root;
        else{
            right.setLeft(root);
            ltail = rtail;
        }
        if(left == null) return root;
        else{
            left.setRight(root);
            return left;
        }
    }

    /* Given a sorted doubly linked list, give an algorithm for converting it into balanced binary search Tree. */
    /* Find the middle node and adjust the pointers */
    DLLNode DLLToBalancedBST(DLLNode head){
        DLLNode temp;
        DLLNode p;
        DLLNode q;
        LinkedListProblems linkedListProblems= new LinkedListProblems();
        if(head == null || head.getNext() == null){return head;}
        temp = linkedListProblems.FindMiddle(head);
        p = head;
        while(p.getNext() != temp){
            p=p.getNext();
        }
        p.setNext(null);
        q = temp.getNext();
        temp.setNext(null);
        temp.setPrevious(DLLToBalancedBST(head));
        temp.setNext(DLLToBalancedBST(q));
        return temp;
    }

    /* Given a sorted array, give an algorithm for converting the array to BST */
    BinaryTreeNode BuildBST(int A[], int left, int right){
        BinaryTreeNode newNode;
        if(left > right) return null;
        newNode = new BinaryTreeNode();
        if(newNode == null) {
            System.out.println("Memory Error.");
            return null;
        }
        if(left == right){
            newNode.setData(A[left]);
            newNode.setLeft(null);
            newNode.setRight(null);
        }else{
            int mid = left + (right - left)/2;
            newNode.setData(A[mid]);
            newNode.setLeft(BuildBST(A, left, mid -1));
            newNode.setRight(BuildBST(A, mid+1, right));
        }
        return newNode;
    }

    /* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST. */
    BinaryTreeNode SortedListToBST(ListNode list, int start, int end) {
        if (start > end) return null;
        //same as (start+end)/2, avoids overflow
        int mid = start + (end - start) / 2;
        BinaryTreeNode leftChild = SortedListToBST(list, start, mid - 1);
        BinaryTreeNode parent = new BinaryTreeNode();
        if (parent == null) {
            System.out.println("Memory Error");
            return null;
        }
        parent.setData(list.getData());
        parent.setLeft(leftChild);
        list = list.getNext();
        parent.setRight(SortedListToBST(list, mid + 1, end));
        return parent;
    }

    /* Give an algorithm for finding the kth smallest element in BST */
    BinarySearchTreeNode kthSmallestInBST(BinarySearchTreeNode root, int k, int count){
        if(root == null)
            return null;
        BinarySearchTreeNode left = kthSmallestInBST(root.getLeft(), k, count);
        if(left != null)
            return left;
        if(++count == k)
            return root;
        return kthSmallestInBST(root.getRight(), k, count);
    }

    /* Floor */

    BinaryTreeNode FloorInBST(BinaryTreeNode root, int data){
        BinaryTreeNode prev = null;
        return FloorInBSTUtil(root, prev, data);
    }

    BinaryTreeNode FloorInBSTUtil(BinaryTreeNode root, BinaryTreeNode prev, int data){
        if(root == null) return null;
        if(FloorInBSTUtil(root.getLeft(), prev, data) == null)
            return null;
        if(root.getData() == data) return root;
        if(root.getData() > data) return prev;
        prev = root;
        return FloorInBSTUtil(root.getRight(), prev, data);
    }
    /* Ceiling : For ceiling we just need to call the right subtree first and then followed by left subtree. */
    BinaryTreeNode CeilingInBST(BinaryTreeNode root, int data){
        BinaryTreeNode prev = null;
        return CeilingInBSTUtil(root, prev, data);
    }

    BinaryTreeNode CeilingInBSTUtil(BinaryTreeNode root, BinaryTreeNode prev, int data){
        if(root == null) return null;
        if(CeilingInBSTUtil(root.getRight(), prev, data) == null) return null;
        if(root.getData() == data) return root;
        if(root.getData() < data) return prev;
        prev = root;
        return CeilingInBSTUtil(root.getLeft(), prev, data);
    }

    /* Given a BST and two numbers K1 and K2, give an algorithm for printing all the elements of BST in the range K1 and K2. */
    void RangePrinter(BinarySearchTreeNode root, int k1, int k2){
        if(root == null) return;
        if(root.getData() >= k1)
            RangePrinter(root.getLeft(), k1, k2);
        if(root.getData() >= k1 && root.getData() <= k2) System.out.println(root.getData());
        if(root.getData() <= k2) RangePrinter(root.getRight(), k1, k2);
    }

    void RangeSearchLevelOrder(BinarySearchTreeNode root, int k1, int k2){
        BinarySearchTreeNode temp;
        LLQueue Q = new LLQueue();
        if(root == null) return;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinarySearchTreeNode)Q.deQueue();
            if(temp.getData() >= k1 && temp.getData() <= k2){
                System.out.println(temp.getData());
            }
            if(temp.getLeft() != null && temp.getData() >= k1){
                Q.enQueue(temp.getLeft());
            }
            if(temp.getRight() != null && temp.getData() <= k2){
                Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue(Q);
        return;
    }


}
