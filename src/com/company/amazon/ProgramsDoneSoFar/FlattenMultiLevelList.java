package com.company.amazon.ProgramsDoneSoFar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenMultiLevelList {

    public static List<Integer> flatten (Nodes<Integer> node) {
        final List<Integer> flattenedList = new ArrayList<>();
        final Queue<Nodes<Integer>> nodeHead = new LinkedList<>();
        nodeHead.add(node);
        // travese the all heads
        while (!nodeHead.isEmpty()) {
            Nodes<Integer> currNode = nodeHead.poll();
            // traverse all Linkedlists
            while (currNode != null) {
                if (currNode.down != null) { nodeHead.add(currNode.down);  }
                flattenedList.add(currNode.item);
                currNode = currNode.right;
            }
        }
        return flattenedList;
    }

    public static void main(String[] args) {
	// write your code here

        Nodes<Integer> node1_1_1 = new Nodes<>(10);
        Nodes<Integer> node1_1_2 = new Nodes<>(5);
        Nodes<Integer> node1_1_3 = new Nodes<>(12);
        Nodes<Integer> node14 = new Nodes<>(7);
        Nodes<Integer> node15 = new Nodes<>(11);

        node1_1_1.right = node1_1_2;
        node1_1_2.right = node1_1_3;
        node1_1_3.right = node14;
        node14.right = node15;

        // level 2, first linkedlist, first node
        Nodes<Integer> node2_1_1 = new Nodes<>(4);
        Nodes<Integer> node2_1_2 = new Nodes<>(20);
        Nodes<Integer> node2_1_3 = new Nodes<>(13);

        node2_1_1.right = node2_1_2;
        node2_1_2.right = node2_1_3;
        node1_1_1.down = node2_1_1;

        // level 2, second linkedlist, first node.
        Nodes<Integer> node2_2_1 = new Nodes<>(17);
        Nodes<Integer> node2_2_2 = new Nodes<>(6);
        node2_2_1.right = node2_2_2;
        node1_1_3.down = node2_2_1;

        Nodes<Integer> node3_1_1 = new Nodes<>(2);
        node2_1_2.down = node3_1_1;

        Nodes<Integer> node3_2_1 = new Nodes<>(16);
        node2_1_3.down = node3_2_1;

        Nodes<Integer> node3_3_1 = new Nodes<>(9);
        Nodes<Integer> node3_3_2 = new Nodes<>(8);
        node3_3_1.right = node3_3_2;
        node2_2_1.down = node3_3_1;

        Nodes<Integer> node4_1_1 = new Nodes<>(3);
        node3_2_1.down = node4_1_1;

        Nodes<Integer> node4_2_1 = new Nodes<>(19);
        Nodes<Integer> node4_2_2 = new Nodes<>(15);
        node4_2_1.right = node4_2_2;
        node3_3_1.down = node4_2_1;

        System.out.println(FlattenMultiLevelList.flatten(node1_1_1));
    }
}

class Nodes<Integer> {
    Nodes<Integer> right;
    Integer item;
    Nodes<Integer> down;

    Nodes(Integer item) {
        this.item = item;
    }
}
