package com.company.amazon.BookKarumanchi.DataStructures.Graph;

/**
 * Created by v-dsindhi on 3/27/15.
 */
public class GraphAdjacencyMatrix {

    private boolean adjMatrix[][];
    public int vertexCount;
    public GraphAdjacencyMatrix(int vertexCount){
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];
    }
    public void addEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j){
        if( i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
            adjMatrix[i][j]=false;
            adjMatrix[j][i]=false;
        }
    }

    public boolean isEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
            return adjMatrix[i][j];
        }else{
            return false;
        }
    }
}
