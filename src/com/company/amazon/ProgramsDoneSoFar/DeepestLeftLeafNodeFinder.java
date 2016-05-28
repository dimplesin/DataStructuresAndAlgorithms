package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/22/15.
 */
public class DeepestLeftLeafNodeFinder {
    Node deepestNode;
    int deepestNodeDepth;

    public Node findDeepestLeftLeafNode(Node root,boolean isLeftNode,
                                        int depth){
        if(isLeftNode){
            if(depth > deepestNodeDepth){
                deepestNode = root;
                deepestNodeDepth = depth;
            }
        }
        if(root.getLeft() != null){
            findDeepestLeftLeafNode(root.getLeft(),true,depth + 1);
        }
        if(root.getRight() != null){
            findDeepestLeftLeafNode(root.getRight(),false,depth+1);
        }
        return deepestNode;
    }
    //- See more at: http://opensourceforgeeks.blogspot.in/2013/12/deepest-left-leaf-node-in-binary-tree.html#sthash.VEaOsOm1.dpuf
    public static void main(String args[]) {

        Node root = new Node(1);

        Node l = new Node(2);
        root.setLeft(l);
        Node r = new Node(3);
        root.setRight(r);

        Node l1 = new Node(4);
        l.setLeft(l1);

        Node r1 = new Node(5);
        r.setLeft(r1);
        Node r2 = new Node(6);
        r.setRight(r2);

        Node r12 = new Node(7);
        r1.setRight(r12);

        Node r121 = new Node(9);
        r12.setLeft(r121);

        Node r22 = new Node(8);
        r2.setRight(r22);

        Node r222 = new Node(10);
        r22.setRight(r222);

        System.out.println("Deepest left node of the tree is : " +
                new DeepestLeftLeafNodeFinder().findDeepestLeftLeafNode(root, false, 0).getData());
    }

}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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
}
