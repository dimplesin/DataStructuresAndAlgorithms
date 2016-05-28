package com.company.amazon.BookKarumanchi.DataStructures.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class VertexDij implements Comparable<VertexDij>
{
    public final String name;
    public EdgeDij[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public VertexDij previous;
    public VertexDij(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(VertexDij other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class EdgeDij
{
    public final VertexDij target;
    public final double weight;
    public EdgeDij(VertexDij argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(VertexDij source)
    {
        source.minDistance = 0;
        PriorityQueue<VertexDij> vertexQueue = new PriorityQueue<VertexDij>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            VertexDij u = vertexQueue.poll();

            // Visit each EdgeDij exiting u
            for (EdgeDij e : u.adjacencies)
            {
                VertexDij v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<VertexDij> getShortestPathTo(VertexDij target)
    {
        List<VertexDij> path = new ArrayList<VertexDij>();
        for (VertexDij vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        VertexDij v0 = new VertexDij("Redvile");
        VertexDij v1 = new VertexDij("Blueville");
        VertexDij v2 = new VertexDij("Greenville");
        VertexDij v3 = new VertexDij("Orangeville");
        VertexDij v4 = new VertexDij("Purpleville");

        v0.adjacencies = new EdgeDij[]{ new EdgeDij(v1, 5),
                new EdgeDij(v2, 10),
                new EdgeDij(v3, 8) };
        v1.adjacencies = new EdgeDij[]{ new EdgeDij(v0, 5),
                new EdgeDij(v2, 3),
                new EdgeDij(v4, 7) };
        v2.adjacencies = new EdgeDij[]{ new EdgeDij(v0, 10),
                new EdgeDij(v1, 3) };
        v3.adjacencies = new EdgeDij[]{ new EdgeDij(v0, 8),
                new EdgeDij(v4, 2) };
        v4.adjacencies = new EdgeDij[]{ new EdgeDij(v1, 7),
                new EdgeDij(v3, 2) };
        VertexDij[] vertices = { v0, v1, v2, v3, v4 };
        computePaths(v0);
        for (VertexDij v : vertices)
        {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<VertexDij> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }
    }
}
