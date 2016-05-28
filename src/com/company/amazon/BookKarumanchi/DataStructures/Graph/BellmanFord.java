package com.company.amazon.BookKarumanchi.DataStructures.Graph;

/**
 * Created by v-dsindhi on 6/21/15.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    public Integer[][] singleSourceShortestPath(Integer[][] weight,
                                                int source) throws Exception {

        //auxiliary constants
        final int SIZE = weight.length;
        final int EVE = -1;//to indicate no predecessor
        final int INFINITY = Integer.MAX_VALUE;

        //declare and initialize pred to EVE and minDist to INFINITY
        Integer[] pred = new Integer[SIZE];
        Integer[] minDist = new Integer[SIZE];
        Arrays.fill(pred, EVE);
        Arrays.fill(minDist, INFINITY);

        //set minDist[source] = 0 because source is 0 distance from itself.
        minDist[source] = 0;

        //relax the edge set V-1 times to find all shortest paths
        for (int i = 1; i < minDist.length - 1; i++) {
            for (int v = 0; v < SIZE; v++) {
                for (int x : adjacency(weight, v)) {
                    if (minDist[x] > minDist[v] + weight[v][x]) {
                        minDist[x] = minDist[v] + weight[v][x];
                        pred[x] = v;
                    }
                }
            }
        }

        //detect cycles if any
        for (int v = 0; v < SIZE; v++) {
            for (int x : adjacency(weight, v)) {
                if (minDist[x] > minDist[v] + weight[v][x]) {
                    throw new Exception("Negative cycle found");
                }
            }
        }

        Integer[][] result = {pred, minDist};
        return result;
    }

    /**
     * ***************************************************************
     * Retrieve all the neighbors of vertex v.
     * ***************************************************************
     */
    private List<Integer> adjacency(Integer[][] G, int v) {
        List<Integer> result = new ArrayList<Integer>();
        for (int x = 0; x < G.length; x++) {
            if (G[v][x] != null) {
                result.add(x);
            }
        }
        return result;
    }

    /*@Test
    public void testBellmanFordWithPositiveEdges() throws Exception {
        System.out.println("singleSourceShortestPath");
        Integer[][] weight = {
                {null, 10, null, null, 3},
                {null, null, 2, null, 1},
                {null, null, null, 7, null},
                {null, null, 9, null, null},
                {null, 4, 8, 2, null}
        };
        int source = 0;
        BellmanFord instance = new BellmanFord();
        Integer[][] expResult = {{-1, 4, 1, 4, 0}, {0, 7, 9, 5, 3}};
        Integer[][] result = instance.singleSourceShortestPath(weight, source);
        assertArrayEquals(expResult, result);
    }*/

    public static void main(String args[]) throws Exception {
        System.out.println("singleSourceShortestPath");
        Integer[][] weight = {
                {null, -1, 4, null, null},
                {null, null, 3, 2, 2},
                {null, null, null, null, null},
                {null, 1, 5, null, null},
                {null, null, null, -3, null}
        };
        int source = 0;
        BellmanFord instance = new BellmanFord();
       // Integer[][] expResult = {{-1, 0, 1, 4, 1}, {0, -1, 2, -2, 1}};
        Integer[][] result = instance.singleSourceShortestPath(weight, source);

    }
}
   /* @Test
    public void testBellmanFordWithNegativeCycle() {
        System.out.println("singleSourceShortestPath");
        Integer[][] weight = {
                {null, -1, 4, null, null},
                {null, null, 3, 2, 2},
                {null, -6, null, null, null},
                {null, 1, 5, null, null},
                {null, null, null, -3, null}
        };
        int source = 0;
        BellmanFord instance = new BellmanFord();
        try {
            instance.singleSourceShortestPath(weight, source);
            fail("Should have thrown an exception: Negative weight cycle");
        } catch (Exception ex) {
            assertTrue(true);
        }
    }*/

