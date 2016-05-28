package com.company.amazon.BookKarumanchi.DataStructures.Graph;

import com.company.amazon.BookKarumanchi.Algorithms.PriorityQueuesAndHeaps.Heap;
import com.company.amazon.BookKarumanchi.DataStructures.Queues.DynArrayQueue;

/**
 * Created by v-dsindhi on 3/28/15.
 */
public class ShortestPathAlgorithms {
    private int[] Distance;
    private int[] Path;
    int[][] weight = new int[0][];

    //Shortest path in unweighted graph
    void UnweightedShortestPath(GraphTS G, int s){
        DynArrayQueue Q = new DynArrayQueue();
        int v,w = -1;
        Q.enQueue(s);
        for(int i=0;i<G.vertexCount;i++){
            Distance[i] = -1;
        }
        Distance[s] = 0;
        while(!Q.isEmpty()){
            v=Q.deQueue();
            //for each w adjacemt to v
                if(Distance[w] == -1){
                    Distance[w] = Distance[v] +1;
                    Path[w] = v;
                    Q.enQueue(w);
                }
        }
        //Q.deleteQueue();
    }

    //Shortest path in weighted graph [Dijkstra's]
    void Dijkstra(GraphTS G, int s){
        Heap PQ = new Heap(0,0);
        int v, w = 0;
        PQ.Insert(s);

        for(int i=0; i<G.vertexCount;i++){
            Distance[i]=-1;
        }
        Distance[s]=0;
        while(!PQ.isEmpty()) {
            v = PQ.DeleteMax();  //Delete Min
            //for all adjacent vertices w of v{
            //Compute new distance
            int d = Distance[v] + weight[v][w];
            if (Distance[w] == -1) {
                Distance[w] = d;
                //Insert w in the priority queue with priority d
                Path[w] = v;
            }
            if (Distance[w] > d) {
                Distance[w] = d;
                //update priority of vertex w to be d
                Path[w] = v;
            }
        }
    }

    //Bellman-Ford Algorithm
    void BellmanFordAlgorithm(GraphTS G, int s){
        DynArrayQueue Q = new DynArrayQueue();
        int v, w = 0;
        Q.enQueue(s);
        //Assume that distance table is filled with INT_MAX
        Distance[s] = 0;
        while(! Q.isEmpty()){
            v = Q.deQueue();
            //for all adjacent vertices w of v{
            //Compute new distance
            int d = Distance[v] + weight[v][w];
            if(w>d){
                Distance[v] = Distance[v] + weight[v][w];
                Path[w] = v;
                Q.enQueue(w);
            }
        }
    }
}
