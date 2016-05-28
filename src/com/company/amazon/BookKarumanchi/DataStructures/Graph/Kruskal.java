package com.company.amazon.BookKarumanchi.DataStructures.Graph;

/**
 * Created by v-dsindhi on 6/21/15.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Kruskal {

    static int path[];
    static int n, m, mincost, i, j;

    public static void main (String args[]) throws Exception {

        InputStreamReader isr;
        isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        // Creating graph of 'n' vertices & 'm' edges
        System.out.print("Enter the number of vertices in the graph: ");
        n = Integer.parseInt(in.readLine());

        System.out.print("Enter the number of edges in the graph: ");
        m = Integer.parseInt(in.readLine());

        path = new int[n+1];

        Edge e[] = new Edge[m];
        Edge t = new Edge();

        for (i=0; i<m; i++) {
            e[i] = new Edge();
            System.out.println("Enter 2 vertices and weight of edge: ");
            System.out.print("First vertex: ");
            e[i].u = Integer.parseInt(in.readLine());
            System.out.print("Second vertex: ");
            e[i].v = Integer.parseInt(in.readLine());
            System.out.print("Weight: ");
            e[i].wt = Integer.parseInt(in.readLine());
        }

        // Sorting the edges in ascending order of weights
        for (i=0; i<=m-1; i++) {
            for (j=0; j<m-i-1; j++) {
                if (e[j].wt > e[j+1].wt) {
                    t = e[j];
                    e[j] = e[j+1];
                    e[j+1] = t;
                }
            }
        }

        // Initializing the path array
        for (i=1; i<=n; i++) {
            path[i] = 0;
        }

        // Counts the number of edges selected in the tree
        i = 0;

        // Counts the number of edges selected or discarded
        j = 0;

        mincost = 0;
        System.out.println();
        while ((i!=n-1) && (j!=m)) {
            System.out.print("Edge ("
                    + e[j].u + ", " + e[j].v + ") "
                    + "with weight " + e[j].wt + " ");
            if (checkCycle(e[j])) {
                mincost = mincost + e[j].wt;
                i++;
                System.out.println("is selected");
            } else {
                System.out.println("is discarded");
            }
            j++;
        }
        if (i!=n-1) {
            System.out.println("Minimum spanning tree cannot be formed ");
        }

    }

    public static boolean checkCycle(Edge e) {
        int u = e.u, v = e.v;

        while (path[u] > 0)
            u = path[u];

        while (path[v] > 0)
            v = path[v];

        if (u != v) {
            path[u] = v;
            return true;
        }
        return false;
    }

    static class Edge {
        int u, v, wt;
    }
}


//What is Kruskal's Algorithm?


//        Kruskal's Algorithm is an algorithm to find a minimum spanning tree for a connected weighted graph. Kruskal's algorithm finds a safe edge to add to the growing forest by finding, of all the edges that connect any two trees in the forest.