package com.company.flipkart;

import java.util.ArrayList;

/**
 * Created by v-dsindhi on 7/11/15.
 */
public class PathSumUpToK {

    /*Given a binary tree print every possible path that sums up to k
    (Not from root to leaf or any node to leaf. But from any node to any node including a node and its left and right branches)*/
    void findSum(Node head, int sum, ArrayList<Integer> buffer,

                 int level) {

        if (head == null) return;

        int tmp = sum;

        buffer.add(Integer.valueOf(head.data));

        for (int i = level;i >- 1; i--){

            tmp -= buffer.get(i);

            if (tmp == 0) print(buffer, i, level);

        }

        ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();

        ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();

        findSum(head.left, sum, c1, level + 1);

        findSum(head.right, sum, c2, level + 1);
    }
    void print(ArrayList<Integer> buffer, int level, int i2) {

        for (int i = level; i <= i2; i++) {

            System.out.print(buffer.get(i) + " ");

        }

        System.out.println();
    }
}
