package com.company.amazon.MoreProgramsForAmazon;

public class CheckIfTwoNodesAreCousins {
    public boolean areCousins(CouNode root, CouNode x, CouNode y) {
        // get the heights of both the nodes and return false if heights ate not
        // same
 
        if (getHeight(root, x, 1) != getHeight(root, y, 1))
            return false;
        else {
            // Now check if or not parents are same for both the node, if not ,
            // return true
            if (sameParents(root, x, y) == false) {
                return true;
            } else {
                return false;
            }
        }
    }
    public int getHeight(CouNode root, CouNode x, int height) {
        if (root == null)
            return 0;
        if (root == x)
            return height;
 
        int level = getHeight(root.left, x, height + 1);
        if (level != 0)
            return level;
        return getHeight(root.right, x, height + 1);
    }
 
    public boolean sameParents(CouNode root, CouNode x, CouNode y) {
        if (root == null)
            return false;
        return ((root.left == x && root.right == y)
                || (root.left == y && root.right == x)
                || sameParents(root.left, x, y) || sameParents(root.right, x, y));
    }
 
    public static void main(String[] args) throws Exception {
        CouNode root = new CouNode(1);
        CouNode x1 = new CouNode(2);
        CouNode y1 = new CouNode(3);
        root.left = x1;
        root.right = y1;
        root.left.left = new CouNode(4);
        root.right.left = new CouNode(6);
        CouNode x2 = new CouNode(7);
        CouNode y2 = new CouNode(9);
        root.right.left.left = new CouNode(8);
        root.right.left.right = y2;
        root.left.left.left = x2;
 
        CheckIfTwoNodesAreCousins i = new CheckIfTwoNodesAreCousins();
        System.out.println("Node " + x1.data + " and Node " + y1.data + " are cousins??? " + i.areCousins(root, x1, y1));
        System.out.println("Node " + x2.data + " and Node " + y2.data + " are cousins??? " + i.areCousins(root, x2, y2));
    }
}
 
class CouNode {
    int data;
    CouNode left;
    CouNode right;
 
    public CouNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}