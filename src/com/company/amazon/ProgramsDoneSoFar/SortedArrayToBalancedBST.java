package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/23/15.
 */
public class SortedArrayToBalancedBST {

    // Definition for binary tree
        public static TreeSolNode sortedArrayToBST(int[] num) {
            if (num.length == 0)
                return null;

            return sortedArrayToBST(num, 0, num.length - 1);
        }

        public static TreeSolNode sortedArrayToBST(int[] num, int start, int end) {
            if (start > end)
                return null;

            int mid = (start + end) / 2;
            TreeSolNode root = new TreeSolNode(num[mid]);
            root.left = sortedArrayToBST(num, start, mid - 1);
            root.right = sortedArrayToBST(num, mid + 1, end);

            return root;
        }

    /* A utility function to print preorder traversal of BST */
    static void preOrder(TreeSolNode node)
    {
        if (node == null)
            return;
        System.out.print("->"+node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

    /* Convert List to BST */
        TreeSolNode root = sortedArrayToBST(arr);
        System.out.print("\n PreOrder Traversal of constructed BST ");
        preOrder(root);

    }


    }

class TreeSolNode {
    TreeSolNode left;
    TreeSolNode right;
    int data;

    TreeSolNode(int x) {
        data = x;
    }
}
