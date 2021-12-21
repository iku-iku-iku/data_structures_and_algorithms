package com.hayaku.graph;

import java.util.ArrayList;
import java.util.Map;

public class Graph { // 顶点编号从1开始
    public static class Edge {
        int i;
        int j;
        int w;

        public Edge(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }
    }

    private static class AdjacencyList {

        private ArrayList<Edge>[] head;

        AdjacencyList(int n) {
            head = (ArrayList<Edge>[]) new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) head[i] = new ArrayList<>();
        }

        void add(Edge edge) { // 加一条从i到j的权值为w边
            head[edge.i].add(edge);
        }

        ArrayList<Edge> getAdj(int i) { // 取得i指向的所有点
            return head[i];
        }
    }

    private final AdjacencyList adjList;

    private int N;
    private int M;

    public Graph(int n) {
        this.N = n;
        adjList = new AdjacencyList(n);
    }

    public Graph(int n, ArrayList<Edge> edges) {
        this(n);
        // 加边
        for (Edge edge : edges) {
            adjList.add(edge);
            M++;
        }
    }


    public int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 1; i < N; i++) {
            int t = -1;
            for (int j = 1; j < N; j++) { // 找到离起点最近的点
                if (!visited[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            visited[t] = true;
            ArrayList<Edge> adj = adjList.getAdj(t);
            for (Edge edge : adj) { // 更新其它点到起点的最短距离
                if (dist[t] + edge.w < dist[edge.j]) {
                    dist[edge.j] = dist[t] + edge.w;
                }
            }
        }
        return dist[end];
    }

}
