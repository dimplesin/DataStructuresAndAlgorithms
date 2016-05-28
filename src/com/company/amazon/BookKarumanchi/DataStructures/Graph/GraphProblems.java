package com.company.amazon.BookKarumanchi.DataStructures.Graph;

import com.company.amazon.BookKarumanchi.DataStructures.Queues.DynArrayQueue;

import java.util.Vector;

/**
 * Created by v-dsindhi on 3/28/15.
 */
public class GraphProblems {

    int Visited[] = new int[0];
    private int[] Predecessor;

    /*Give an algorithm for checking whether a given graph G has simple path from source s to destination d.
     Assume the graph G is represented using adjacency matrix */
    int HasSimplePath(GraphAdjacencyMatrix G, int s, int d) {

        Visited[s] = 1;
        if (s == d) return s;
        for (int t = 0; t < G.vertexCount; t++) {
            if (G.isEdge(s, t) && Visited[t] != 1) {
                //if(DFS(G,t,d)) return 1;
            }
        }
        return 0;
    }

    //Alternative way
    void CountSimplePaths(GraphAdjacencyMatrix G, int s, int d) {
        Visited[s] = 1;
        int count = 0;
        if (s == d) {
            count++;
            Visited[s] = 0;
            return;
        }
        for (int t = 0; t < G.vertexCount; t++) {
            if (G.isEdge(s, t) && Visited[t] != 1) {
                //if(DFS(G,t,d));
                Visited[t] = 0;
            }
        }
    }

    //DFS Application : Cut Vertex or Articulation Points
    int adjMatrix[][] = new int[256][256];
    int[] dfsnum = new int[256];
    int num = 0;
    int low[] = new int[256];

    void CutVertices(int u) {
        low[u] = dfsnum[u] = num++;
        for (int v = 0; v < 256; v++) {
            if (adjMatrix[u][v] == -1 && dfsnum[v] == -1) {
                CutVertices(v);
                if (low[v] > dfsnum[v]) {
                    System.out.println("Cut Vertex : " + u);
                }
                low[u] = Math.min(low[u], low[v]);
            } else {
                //(u,v) is a back edge
                low[u] = Math.min(low[u], dfsnum[v]);
            }
        }
    }

    //DFS Application : Cut Bridges or CutEdges
    void Bridges(GraphAdjacencyMatrix G, int u) {
        low[u] = dfsnum[u] = num++;
        for (int v = 0; v < G.vertexCount; ++v) {
            if (adjMatrix[u][v] == -1 && dfsnum[v] == -1) {
                CutVertices(v);
                if (low[v] > dfsnum[u]) {
                    System.out.println(u + v + "as a bridge");
                }
                low[u] = Math.min(low[u], low[v]);
            } else {
                //(u,v) is a back edge
                low[u] = Math.min(low[u], dfsnum[v]);
            }
        }
    }

    //DFS Application : Finding Strongly Connected Components
    int table[] = new int[256];
    Vector<Integer> st;
    int counter = 0;

    void StronglyConnectedComponents(int u) {
        low[u] = dfsnum[u] = num++;
        st.add(u);
        for (int v = 0; v < 256; v++) {
            if (adjMatrix[u][v] == -1 && table[v] == -1) {
                if (dfsnum[v] == -1) {
                    StronglyConnectedComponents(v);
                }
                low[u] = Math.min(low[u], low[v]);
            }
        }
        if (low[u] == dfsnum[u]) {
            while (table[u] != counter) {
                table[st.get(u)] = counter;
                st.add(u);
            }
            ++counter;
        }
    }

    //Count the number of connected components of Graph G which is represented in adjacent matrix
    void DFS(GraphAdjacencyMatrix G, int u) {
        Visited[u] = 1;
        for (int v = 0; v < G.vertexCount; v++) {
            /* For example, if the adjacency matrix is used for representing the graph, then the condition
             to be used for finding unvisited adjacent vertex of u is : if(!Visited[v] && G->Adj[u][v])
              */
            //for each unvisited adjacent node v of u{
            DFS(G, v);
            //}
        }
    }

    int DFSTraversal(GraphAdjacencyMatrix G) {
        int count = 0;
        for (int i = 0; i < G.vertexCount; i++) {
            Visited[i] = 0;
        }
        for (int i = 0; i < G.vertexCount; i++) {
            if (Visited[i] == -1) {
                DFS(G, i);
                count++;
            }
        }
        return count;
    }

    //Count the number of connected components of Graph G which is represented in adjacent matrix using BFS
    void BFS(GraphAdjacencyMatrix G, int u) {
        int v =0;
        DynArrayQueue Q = new DynArrayQueue();
        Q.enQueue(u);
        while (!Q.isEmpty()) {
            u = Q.deQueue();
            Visited[u] = 1;
            //for each unvisited adjacent node v of u{
            Q.enQueue(v);
        }
    }
    void BFSTraversal(GraphAdjacencyMatrix G){
        for(int i=0;i<G.vertexCount;i++){
            Visited[i] = 0;
        }
        //This loop is required if the graph has more than one component
        for(int i =0;i<G.vertexCount;i++){
            if(Visited[i] != -1){
                BFS(G, i);
            }
        }
    }

    //Detecting a Cycle in DAG
    int DetectCycle(GraphAdjacencyMatrix G){
        for(int i=0;i<G.vertexCount;i++){
            Visited[i] = 0;
            Predecessor[i] = 0;
        }
        for(int i =0; i <G.vertexCount;i++){
            if(Visited[i] != -1 && HasCycle(G,i) != 0){
                return 1;
            }
        }
        return -1;
    }
    int HasCycle(GraphAdjacencyMatrix G, int u){
        Visited[u] = 1;
        for(int i=0;i<G.vertexCount;i++){
            if(adjMatrix[u][i] != -1){
                if(Predecessor[i] != u && Visited[i] != 0){
                    return 1;
                }else{
                    Predecessor[i] = u;
                    return HasCycle(G, i);
                }
            }
        }
        return 0;
    }

    //Given a directed acyclic graph, give an algorithm for finding its depth
    //Assuming the given graph is a DAG
    int DepthInDAG(GraphAdjacencyMatrix G){
        int[] indegree = new int[10];
        DynArrayQueue Q = new DynArrayQueue();
        int counter;
        int v, w = 0;
        counter =0;
        for(v=0;v<G.vertexCount;v++){
            if(indegree[v] == 0){
                Q.enQueue(v);
            }
            Q.enQueue('$');
            while(!Q.isEmpty()){
                v = Q.deQueue();
                if(v == '$'){
                    counter++;
                    if(!Q.isEmpty()){
                        Q.enQueue('$');
                    }
                }
                //for each w adjacent to v
                    if(--indegree[w] == 0){
                        Q.enQueue(w);
                    }
            }
        }
        //Q.deleteQueue();
        return counter;
    }

    //Hamiltonian paths in DAG
    boolean seenTable[] = new boolean[32];
    void HamiltonianPath(GraphAdjacencyMatrix G, int u){
        for(int v = 0; v<G.vertexCount;v++){
            if(!seenTable[v] && adjMatrix[u][v] != 0){
                seenTable[v] = true;
                HamiltonianPath(G, v);
                seenTable[v] = false;
            }
        }
    }

    //Reversing Graph
    //Bipartite Matching
    //Planar Graphs
    //Graph Coloring

}
