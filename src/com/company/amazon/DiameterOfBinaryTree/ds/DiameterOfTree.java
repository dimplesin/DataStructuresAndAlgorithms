package com.company.amazon.DiameterOfBinaryTree.ds;

/**
 * Created by v-dsindhi on 6/26/15.
 */
public class DiameterOfTree
{
    public DiameterOfTree()
    {
    }

    public int diameterOfBinaryTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);

        int leftDiameter = diameterOfBinaryTree(node.left);
        int rightDiameter = diameterOfBinaryTree(node.right);

        return Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));
    }

    public int heightOfBinaryTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            return 1 +
                    Math.max(heightOfBinaryTree(node.left),
                            heightOfBinaryTree(node.right));
        }
    }

    public static void main(String[] args)
    {
        /*
        Constructing following tree
                        1
                    2         3
                4       5  6     7
            8       9
                 10     11
                                                        */
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.create(1);

        Node root = binaryTree.search(1);
        binaryTree.add(root, 2, BinaryTree.LEFT);
        binaryTree.add(root, 3, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(2), 4, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(2), 5, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(3), 6, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(3), 7, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(4), 8, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(4), 9, BinaryTree.RIGHT);
        binaryTree.add(binaryTree.search(9), 10, BinaryTree.LEFT);
        binaryTree.add(binaryTree.search(9), 11, BinaryTree.RIGHT);
        System.out.println("Binary Tree in level order is .... ");
        binaryTree.printLevelOrder();

        DiameterOfTree diaTree = new DiameterOfTree();
        System.out.println("Diameter is ....  " +
                diaTree.diameterOfBinaryTree(root));
    }
}
