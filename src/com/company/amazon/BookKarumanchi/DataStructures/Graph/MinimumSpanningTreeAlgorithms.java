package com.company.amazon.BookKarumanchi.DataStructures.Graph;

import com.company.amazon.BookKarumanchi.Algorithms.PriorityQueuesAndHeaps.Heap;

/**
 * Created by v-dsindhi on 3/28/15.
 */
public class MinimumSpanningTreeAlgorithms {

    private int[] Distance;
    int[][] weight = new int[0][];
    int d;
    private int[] Path;

    //Prims Algorithm
    void Prims(GraphTS G, int s){
        Heap PQ = new Heap(0,0);
        int v, w = 0;
        PQ.Insert(s);

        //assume the Distance table is filled with -1
        Distance[s]=0;while(!PQ.isEmpty()){
            v=PQ.DeleteMax(); //DeleteMin
            //for all adjacent vertices w of v{
            //Compute new Distance 
            d = Distance[v] + weight[v][w];
            if(Distance[w] == -1){
                Distance[w] = weight[v][w];
                //Insert w in the priority queue with priority d
                Path[w] = v;
            }
            if(Distance[w] > d){
                Distance[w] = weight[v][w];
            }
            //Update the priority of vertex w to be d
            Path[w] = v;
        }
        
    }
}

