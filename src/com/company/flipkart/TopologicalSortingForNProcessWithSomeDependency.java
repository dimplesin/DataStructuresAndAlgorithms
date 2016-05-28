package com.company.flipkart;

import java.util.Stack;

/**
 * Created by v-dsindhi on 7/9/15.
 */
public class TopologicalSortingForNProcessWithSomeDependency {


    // A C++ program to print topological sorting of a DAG
    // Class to represent a graph
    static class Graph {
        int V;    // No. of vertices'

        // Pointer to an array containing adjacency listsList
        int adj[];

        Graph(int V)
        {
            this.V = V;
            adj = new int[V];
        }

        // Add w to v’s list.
        void addEdge(int v, int w) {
            adj[v] = w;
        }
            // A function used by topologicalSort
            // A recursive function used by topologicalSort
            void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
            {
                // Mark the current node as visited.
                visited[v] = true;

                // Recur for all the vertices adjacent to this vertex
                for(int i : adj){
                    if(!visited[i]){
                        topologicalSortUtil(i, visited, stack);
                    }
                }

                // Push current vertex to stack which stores result
                stack.push(v);
            }

        // function to add an edge to graph

        // prints a Topological Sort of the complete graph
        // The function to do Topological Sort. It uses recursive topologicalSortUtil()
        void topologicalSort()
        {
            Stack<Integer> stack = new Stack<>();

            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to store Topological Sort
            // starting from all vertices one by one
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            // Print contents of stack
            while (stack.empty() == false)
            {
                System.out.println(stack.peek());
                stack.pop();
            }
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological Sort of the given graph ");
        g.topologicalSort();


    }
    /*Run on IDE
    Output:

    Following is a Topological Sort of the given graph
    5 4 2 3 1 0
   // Time Complexity: The above algorithm is simply DFS with an extra stack. So time complexity is same as DFS which is O(V+E).*/
}
