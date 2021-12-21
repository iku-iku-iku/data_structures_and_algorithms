package com.hayaku.graph;

import java.util.ArrayList;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(4, new ArrayList<Graph.Edge>() {{
            add(new Graph.Edge(1, 2, 1));
            add(new Graph.Edge(1, 3, 3));
            add(new Graph.Edge(2, 4, 4));
            add(new Graph.Edge(3, 4, 1));
        }});
        int minDist = graph.dijkstra(1, 4);
        System.out.println(minDist);
    }
}
