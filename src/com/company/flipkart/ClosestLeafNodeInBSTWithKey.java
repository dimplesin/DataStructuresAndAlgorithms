package com.company.flipkart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by v-dsindhi on 7/9/15.
 */
public class ClosestLeafNodeInBSTWithKey {
}

class Node {

    String data;
    Node left;
    Node right;

    Node(String data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public String getData(){
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}

class BinaryTree
{
    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    void inOrderTraversal(Node root)
    {
        if(root == null)
            return;
        inOrderTraversal(root.getLeft());
        System.out.println(root.getData()+" ");
        inOrderTraversal(root.getRight());

    }
    Node search(Node root,String s)
    {
        Node r = null;
        if(root == null || root.getData().equalsIgnoreCase(s))
            return root;

        if(root.getLeft()!=null)
            r = search(root.getLeft(),s);

        if(r!=null)
            return r;
        else if(root.getRight()!=null)
            return search(root.getRight(),s);

        return null;
    }
    Node getNearestLeafNode(Node root)
    {
        if(root==null || (root.left ==null && root.right==null))
            return root;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node n = queue.remove();
            if(n.left == null && n.right == null)
                return n;
            else
            {
                if(n.left!=null)
                    queue.add(n.left);
                if(n.right!=null)
                    queue.add(n.right);
            }
        }
        return null;
    }
}

/**
 *  Find the nearest leaf node from given node in binary tree.
 */

 class NearestLeaf
{
    public static void main(String a[]) throws IOException
    {
        String data=null;
        BinaryTree btree = new BinaryTree();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> queue = new LinkedList<Node>();
        System.out.println("Root Node : " );

        btree.setRoot(new Node(br.readLine(),null,null));
        queue.add(btree.getRoot());


        /*
         * Loop to create the binary tree.
         */
        while(!queue.isEmpty())
        {
            Node n = queue.remove();
            Node newnode = null;

            System.out.println("Enter the left and right child for "+n.getData());

            data = br.readLine();
            if (data.length() == 0 )
                newnode = null;
            else
                newnode = new Node(data,null,null);

            n.setLeft(newnode);

            data = br.readLine();
            if (data.length() == 0)
                newnode = null;
            else
                newnode = new Node(data,null,null);

            n.setRight(newnode);

            if(n.getLeft()!=null)
                queue.add(n.getLeft());
            if(n.getRight()!=null)
                queue.add(n.getRight());
        }

        //Display the inorder traversal of the tree.
        btree.inOrderTraversal(btree.getRoot());

        System.out.println("Enter the node for which to find the nearest node : ");
        String search = br.readLine();

        Node result = btree.search(btree.getRoot(), search);
        if(result == null)
            System.out.println("No such node exists in the tree.");

        Node nearestLeaf=btree.getNearestLeafNode(result);
        if(nearestLeaf == null)
            System.out.println("Nearest node not found.");
        else
            System.out.println("Nearest node is : "+nearestLeaf.getData());
    }

}