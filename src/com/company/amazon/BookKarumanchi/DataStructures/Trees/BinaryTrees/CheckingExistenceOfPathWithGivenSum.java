package com.company.amazon.BookKarumanchi.DataStructures.Trees.BinaryTrees;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.LLQueue;

import java.util.Stack;

/**
 * Give an algorithm for checking the existence of path with the given sum. That means, given a sum
 * check whether there exists a path from root to any of the nodes.
 */
public class CheckingExistenceOfPathWithGivenSum {
    public boolean hasPathSum(int sum){
        BinaryTreeNode root = null;
        return (hasPathSum(root, sum));
    }
    boolean hasPathSum(BinaryTreeNode node, int sum){
        //return true if we run out of tree and sum==0
        if(node == null){
            return (sum == 0);
        }else{
            //otherwise check both subtrees
            int subSum = sum - node.getData();
            return (hasPathSum(node.getLeft(), subSum) || hasPathSum(node.getRight(), subSum));
        }
    }

    /* Give an algorithm for finding the sum of all elements in binary tree */
    int Add(BinaryTreeNode root){
        if(root == null) return 0;
        else return (root.getData() +Add(root.getLeft()) + Add(root.getRight()));
    }

    /* Give an algorithm for finding the sum of all elements in binary tree without recursion */
    int SumOfBTusingLevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int sum = 0;
        if(root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()){
            temp = (BinaryTreeNode) Q.deQueue();
            sum += temp.getData();
            if(temp.getLeft() != null){
                Q.enQueue(temp.getLeft());
            }
            if(temp.getRight() != null){
                Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue(Q);
        return sum;
    }

    /* Give an algorithm for converting a tree to its mirror. Mirror of the tree is another tree with
     left and right children of all non-leaf nodes interchanged. */
    BinaryTreeNode MirrorOfBinaryTree(BinaryTreeNode root){
        BinaryTreeNode temp;
        if(root != null){
            MirrorOfBinaryTree(root.getLeft());
            MirrorOfBinaryTree(root.getRight());
            /* swap the pointers int this node */
            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        return root;
    }

    /* Given two trees, give an algorithm for checking whether they are mirrors of each other. */
    int AreMirrors(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null) return 1;
        if(root1 == null || root2 == null) return 0;
        if(root1.getData() != root2.getData()) return 0;
        else {
            if(AreMirrors(root1.getLeft(), root2.getRight()) == 1 && AreMirrors(root1.getRight(), root2.getLeft()) == 1) {
                return 1;
            }
        }
        return 0;
    }

    /* Give an algorithm for constructing binary tree from given Inorder and Preorder travesals.
     * Inorder sequence : D B E A F C
      * Preorder sequence : A B D E C F*/
    BinaryTreeNode BuildBinaryTree(int inOrder[], int preOrder[], int inStrt, int inEnd){
        int preindex=0;
        BinaryTreeNode newNode = new BinaryTreeNode();
        if(inStrt > inEnd) return null;
        if(newNode == null) {
            System.out.println("Memory Error");
            return null;
        }
        //Select current node from preorder traversal using preindex.
        newNode.setData(preOrder[preindex]);
        preindex ++;
        if(inStrt == inEnd){   // if this node has no children then return.
            return newNode;
        }/* else find the index of this node in Inorder traversal */
        int inIndex = Search(inOrder, inStrt, inEnd, newNode.getData());
        /* Using index in inorder travesal, construct left and right sub trees */
        newNode.setLeft(BuildBinaryTree(inOrder, preOrder, inStrt, inIndex-1));
        newNode.setRight(BuildBinaryTree(inOrder, preOrder, inIndex+1, inEnd));
        return newNode;
    }

    private int Search(int[] inOrder, int inStrt, int inEnd, int data) {
        for( inStrt = 0; inStrt < inEnd; inStrt++){
            if(inOrder[inStrt] == data){
                return inStrt;
            }
        }
        return -1;
    }

    /* Give an algorithm for printing all the ancestors of a node in a Binary tree. */
    int PrintAllAncestors(BinaryTreeNode root, BinaryTreeNode node){
        if(root == null) { return 0;}
        if(root.getLeft() == node || root.getRight() == node ||
            PrintAllAncestors(root.getLeft(), node) != 0 || PrintAllAncestors(root.getRight(), node) != 0){
             System.out.println(root.getData());
            return 1;
        }
        return 0;
    }

    /* Give an algorithm for finding LCA (Least Common Ancestor) of two nodes in a binary tree. */
    BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode alpha, BinaryTreeNode beta){
        BinaryTreeNode left, right;
        if(root == null){
            return root;
        }
        if(root == alpha || root == beta){
            return root;
        }
        left = LCA(root.getLeft(), alpha, beta);
        right = LCA(root.getRight(), alpha, beta);
        if(left != null && right != null) return root;
        else {
            if(left != null){
                return left;
            }else {
                return right;
            }
        }
    }

    /* ZigZag Tree Traversal : Give an algorithm to traverse a binary tree in ZigZag order. */
    void ZigZagTraversal (BinaryTreeNode root){
        BinaryTreeNode temp;
        int leftToRight = 1;
        if(root == null) return;
        Stack<BinaryTreeNode> currentLevel = new Stack<BinaryTreeNode>(), nextLevel = new Stack<BinaryTreeNode>();
        currentLevel.push(root);
        while(!currentLevel.empty()){
            temp = currentLevel.pop();
            if(temp != null){
                System.out.println(temp.getData());
                if(leftToRight == 1){
                    if(temp.getLeft() != null){
                        nextLevel.push(temp.getLeft());
                    }
                    if(temp.getRight() != null){
                        nextLevel.push(temp.getRight());
                    }
                }else{
                    if(temp.getRight() != null){
                        nextLevel.push(temp.getRight());
                    }
                    if(temp.getLeft() != null){
                        nextLevel.push(temp.getLeft());
                    }
                }
                if (currentLevel.empty()){
                    leftToRight = 1-leftToRight;
                    swap(currentLevel, nextLevel);
                }
            }
        }
    }

    private void swap(Stack<BinaryTreeNode> currentLevel, Stack<BinaryTreeNode> nextLevel) {
        Stack<BinaryTreeNode> temp = new Stack<BinaryTreeNode>();
        temp = currentLevel;
        currentLevel = nextLevel;
        nextLevel = temp;
    }

    /* Give an algorithm for finding the vertical sum of a binary tree. */
    void VerticalSumInBinaryTree(BinaryTreeNode root, int column){
        int[] Hash = null;
        if(root == null){
            return;
        }
        VerticalSumInBinaryTree(root.getLeft(), column -1);
        Hash[column] += root.getData();
        VerticalSumInBinaryTree(root.getRight(), column + 1);
    }

    /* Given a tree with a special property where leaves are represented with 'L' and internal node with 'I'. Also assume
     * that each node has either 0 or 2 children. Given preorder traversal of this tree, construct the tree. */
    BinaryTreeNode BuildTreeFromPreOrder(char[] A, int i){
        if(A == null) return null;   //Boundary condition
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setData(A[i]);
        newNode.setLeft(null);
        newNode.setRight(null);
        if(A[i] == 'L'){                 //On reaching leaf node, return.
            return newNode;
        }
        i = i + 1;                      // Populate left sub tree
        newNode.setLeft(BuildTreeFromPreOrder(A, i));
        i = i + 1;                     // Populate right sub tree
        newNode.setRight(BuildTreeFromPreOrder(A, i));
        return newNode;
    }

    /* Given a binary tree with three pointers (left, right and nextSibling), give an algorithm for filling
     the nextSibling pointers assuming they are NULL initially. */
    void FillNextSiblings(BinaryTreeNode root){
        LLQueue Q = new LLQueue();
        BinaryTreeNode temp = null;
        if(root == null) return;
        Q.enQueue(root);
        Q.enQueue(null);
        while(!Q.isEmpty()){
            root = (BinaryTreeNode)Q.deQueue();
            //Completion of current level
            if(root == null) { //Put another marker for next level.
                if (!Q.isEmpty())
                    Q.enQueue(null);
            }else {
                //temp.setNextSibling(Q.getFront());
                if(root.getLeft() != null){
                    Q.enQueue(root.getLeft());
                }
                if(root.getRight() != null){
                    Q.enQueue(root.getRight());
                }
            }
        }
    }

    void FillNextSibling(BinaryTreeNode root){
        if(root == null) return;
        if(root.getLeft() != null){
            //root.getLeft().setNextSibling(root.getRight());
        }
        if(root.getRight() != null){
            //if(root.getNextSibling())
                //root.getRight().setNextSibling(root.getNextSibling().getLeft());
            //else root.getRight().setNextSibling(null);
        }
        FillNextSibling(root.getLeft());
        FillNextSibling(root.getRight());
    }
}