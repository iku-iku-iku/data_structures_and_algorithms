package com.hayaku.graph;

import org.junit.Test;

import java.util.ArrayList;

public class GraphTest {
    @Test
    public void testDijkstra() {
        Graph graph = new Graph(true, 4, new ArrayList<>() {{
            add(new Graph.Edge(1, 2, 1));
            add(new Graph.Edge(1, 3, 3));
            add(new Graph.Edge(2, 4, 4));
            add(new Graph.Edge(3, 4, 1));
        }});
        int minDist = graph.dijkstra(1, 4);
        System.out.println(minDist);
    }

    @Test
    public void testMinimalSpanningTree() {
        Graph graph = new Graph(false, 5, new ArrayList<>() {{
            add(new Graph.Edge(1, 2, 100));
            add(new Graph.Edge(1, 3, 2));
            add(new Graph.Edge(1, 4, 3));
            add(new Graph.Edge(1, 5, 4));
            add(new Graph.Edge(2, 3, 5));
            add(new Graph.Edge(2, 4, 6));
            add(new Graph.Edge(2, 5, 7));
            add(new Graph.Edge(3, 4, 8));
            add(new Graph.Edge(3, 5, 9));
            add(new Graph.Edge(4, 5, 10));
        }});
        System.out.println(graph.kruskal());
        System.out.println(graph.prim());
    }
}
