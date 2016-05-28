package com.company.flipkart;

/**
 * Created by v-dsindhi on 7/11/15.
 */
public class PerformAddSubstractOnHugeNumberOfElementsInArray {

    int tree[]= new int[Integer.MAX_VALUE], N; // indices 1..N

    void Update(int x, int value) {
        for (; x <= N; x += (x & -x))
            tree[x] += value;
    }
    int GetSum(int x) {
        int sum = 0;
        for (; x > 0; x -= (x & -x))
            sum += tree[x];
        return sum;
    }
}
