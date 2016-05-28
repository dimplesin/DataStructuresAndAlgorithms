package com.company.amazon.BookKarumanchi.DataStructures.Graph;

import com.company.amazon.BookKarumanchi.DataStructures.LinkedLists.ListNode;

import java.util.ArrayList;

/**
 * Created by v-dsindhi on 3/27/15.
 */
public class GraphAdjacencyList {
    private ArrayList<Integer> vertices;
    private ListNode[] edges;
    private int vertexCount;

    public GraphAdjacencyList(int vertexCount){
        this.vertexCount = vertexCount;
        vertices = new ArrayList<Integer>();
        edges = new ListNode[vertexCount];
        for(int i =0;i<vertexCount;i++){
            vertices.add(i);
            edges[i] = new ListNode(i);
        }
    }
    public void addEdge(int source, int destination){
        int i = vertices.indexOf(source);
        int j = vertices.indexOf(destination);
        if(i != -1 || j != -1){
            //edges[i].insertAtBegining(destination);
            //edges[j].insertAtBegining(source);
        }
    }
}
