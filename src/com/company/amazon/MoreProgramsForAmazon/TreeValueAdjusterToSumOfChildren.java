package com.company.amazon.MoreProgramsForAmazon;

/**
 * Created by v-dsindhi on 6/26/15.
 */
import java.util.List;

public class TreeValueAdjusterToSumOfChildren {
    public static interface TreeNode {
        public TreeNode getLeft();
        public TreeNode getRight();
        public int getValue();
        public TreeNode setValue(int value);
    }

    public static interface NodeVisitor {
        public void visit (TreeNode node);
        public void afterAllVisited();
    }

    public static class SumVisitor implements NodeVisitor {
        public void visit (TreeNode visitedNode) {
            if (meetsCondition(visitedNode)) {
                operate(visitedNode);
            }
        }

        public SumVisitor(TreeNode node) {
            this.startingNode = node;
        }

        private boolean meetsCondition (TreeNode visitedNode) {
            return visitedNode.getValue() < startingNode.getValue();
        }
        private void operate (TreeNode visitedNode) {
            sum += visitedNode.getValue();
        }

        public void afterAllVisited() {
            startingNode.setValue(sum);
        }

        private final TreeNode startingNode;
        private int sum = 0;
    }

    public static interface VisitorFactory {
        public NodeVisitor createVisitor (TreeNode node);
    }
    public static class SumVisitorFactory implements VisitorFactory {
        public NodeVisitor createVisitor (TreeNode node) {
            return new SumVisitor(node);
        }
    }

    public List<NodeVisitor> traverseTree (TreeNode node, List<NodeVisitor> visitors, VisitorFactory factory) {
        for (NodeVisitor visitor: visitors) {
            visitor.visit(node);
        }

        NodeVisitor visitor = factory.createVisitor(node);
        visitors.add(visitor);
        if (node.getLeft() != null) {
            traverseTree(node.getLeft(), visitors, factory);
        }
        if (node.getRight() != null) {
            traverseTree(node.getRight(), visitors, factory);
        }

        visitors.remove(visitors.size());
        visitor.afterAllVisited();
        return visitors;
    }

    public int sum(Node root) {
        if (root == null)
            return 0;

        int sum = sum(root.left) + sum(root.right);
        int totalSum = sum + root.data;
        if ( root.data < sum)
            root.data = sum;
        return totalSum;
    }

}


