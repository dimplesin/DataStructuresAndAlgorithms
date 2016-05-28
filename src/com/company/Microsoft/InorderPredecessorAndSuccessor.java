package com.company.Microsoft;

/**
 * Created by v-dsindhi on 8/15/15.
 */
public class InorderPredecessorAndSuccessor {

    /*
    Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree
     */


   static Node pre = null, suc = null;

   static class Node
    {
        int key;
         Node left, right;
    };
// A utility function to create a new BST node
static Node newNode(int item)
    {
        Node temp =  new Node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

/* A utility function to insert a new node with given key in BST */
static Node insert(Node node, int key)
    {
        if (node == null) return newNode(key);
        if (key < node.key)
            node.left  = insert(node.left, key);
        else
            node.right = insert(node.right, key);
        return node;
    }

    // Driver program to test above function
    public static void main(String args[])
    {
   /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        Node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);

        Node temp = root.right.left;
        suc = inOrderSuccessor(root, temp);
        pre = inOrderPredecessor(root, temp);
        //findPreSuc(root, pre, suc, key);
       if (pre != null)
            System.out.println("Predecessor is "  + pre.key);
        else
            System.out.println("No Predecessor");

        if (suc != null)
            System.out.println("Successor is " + suc.key);
        else
            System.out.println("No Successor");

    }

    static Node inOrderPredecessor(Node root, Node x)
    {
        if( x.left != null )
            return maxValue(x.left);

        Node predecessor = null;

        while (root != null)
        {
            if (x.key > root.key)
            {
                predecessor = root;
                root = root.right;
            }
            else if (x.key < root.key)
                root = root.left;
            else
                break;
        }
        return predecessor;
    }


    static Node inOrderSuccessor(Node root, Node n)
    {
        // step 1 of the above algorithm
        if( n.right != null )
            return minValue(n.right);

        Node succ = null;

        // Start from root and search for successor down the tree
        while (root != null)
        {
            if (n.key < root.key)
            {
                succ = root;
                root = root.left;
            }
            else if (n.key > root.key)
                root = root.right;
            else
                break;
        }

        return succ;
    }

    static Node minValue( Node node) {
        Node current = node;

  /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    static Node maxValue(Node node)
    {
        Node n = node;
        while(n.right!=null)
            n=n.right;
        return n;
    }

}

