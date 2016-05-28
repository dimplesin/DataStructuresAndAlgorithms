package com.company.amazon.ProgramsDoneSoFar;

/**
 * Created by v-dsindhi on 6/23/15.
 */
import java.util.ArrayList;

public class CloneGraph {
    static class Node {
        int data;
        ArrayList<Node> neighbors;
    }

    static void clone(Node sGraph, Node dGraph) {
        if (sGraph != null) {
            dGraph.data = sGraph.data;
        }

        if (sGraph.neighbors != null) {
            if (dGraph.neighbors == null) {
                dGraph.neighbors = new ArrayList<Node>();
            }

            for (Node n : sGraph.neighbors) {
                Node cloneN = new Node();
                dGraph.neighbors.add(cloneN);

                clone(n, cloneN);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 1;
        node1.neighbors = new ArrayList<Node>();

        Node node2 = new Node();
        node2.data = 2;
        node1.neighbors.add(node2);

        Node node3 = new Node();
        node3.data = 3;
        node1.neighbors.add(node3);

        Node clonedGraph = new Node();
        clone(node1, clonedGraph);

    }
}
