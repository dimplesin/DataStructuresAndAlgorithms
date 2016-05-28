package com.company.flipkart;

import java.io.File;

/**
 * Created by v-dsindhi on 7/11/15.
 */
public class SavingBinaryTreeToFiles {

    // A C++ program to demonstrate serialization and deserialiation of
// Binary Tree

    /* A binary tree Node has key, pointer to left and right children */
    class Node
    {
        int key;
        Node left, right;
    };

/* Helper function that allocates a new Node with the
   given key and NULL left and right pointers. */
    Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return (temp);
    }

    // This function stores a tree in a file pointed by fp
    void serialize(Node root, File fp)
    {
        // If current node is NULL, store marker
        if (root == null)
        {
            System.out.println(fp);
            return;
        }

        // Else, store current node and recur for its children
        System.out.println(fp);
        serialize(root.left, fp);
        serialize(root.right, fp);
    }

    // This function constructs a tree from a file pointed by 'fp'
    void deSerialize(Node root, File fp)
    {
        // Read next item from file. If theere are no more items or next
        // item is marker, then return
        int val = 0;
        if ( fp!=null || val == -1)
        return;

        // Else create node with this item and recur for children
        root = newNode(val);
        deSerialize(root.left, fp);
        deSerialize(root.right, fp);
    }

    // A simple inorder traversal used for testing the constructed tree
    void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }

    /* Driver program to test above functions*/
    int main()
    {
        // Let us construct a tree shown in the above figure
         Node root        = newNode(20);
        root.left               = newNode(8);
        root.right              = newNode(22);
        root.left.left         = newNode(4);
        root.left.right        = newNode(12);
        root.left.right.left  = newNode(10);
        root.left.right.right = newNode(14);

        // Let us open a file and serialize the tree into the file
       // FILE fp = fopen("tree.txt", "w");
        File fp = new File("tree.txt");
        if (fp == null)
        {
            //puts("Could not open file");
            return 0;
        }
        serialize(root, fp);
        //fclose(fp);

        // Let us deserialize the storeed tree into root1
        Node root1 = null;
        //fp = fopen("tree.txt", "r");
        deSerialize(root1, fp);

        //printf("Inorder Traversal of the tree constructed from file:\n");
        inorder(root1);

        return 0;
    }
    /*Run on IDE
    Output:

    Inorder Traversal of the tree constructed from file:
            4 8 10 12 14 20 22
    How much extra space is required in above solution?
    If there are n keys, then the above solution requires n+1 markers which may be better than simple solution (storing keys twice) in situations where keys are big or keys have big data items associated with them.

    Can we optimize it further?
    The above solution can be optimized in many ways. If we take a closer look at above serialized trees, we can observer that all leaf nodes require two markers. One simple optimization is to store a separate bit with every node to indicate that the node is internal or external. This way we don’t have to store two markers with every leaf node as leaves can be identified by extra bit. We still need marker for internal nodes with one child. For example in the following diagram ‘ is used to indicate an internal node set bit, and ‘/’ is used as NULL marker. The diagram is taken from here.
    optimizedSerial
    Please note that there are always more leaf nodes than internal nodes in a Binary Tree (Number of leaf nodes is number of internal nodes plus 1, so this optimization makes sense.*/
}
