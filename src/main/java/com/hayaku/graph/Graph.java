package com.hayaku.graph;

import com.hayaku.search.unionfind.UnionFind;
import com.hayaku.tree.heap.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Graph { // 顶点编号从1开始
    public static class Edge implements Comparable<Edge> {
        int i;
        int j;
        int w;

        public Edge(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
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

    public Graph(boolean directed, int n, ArrayList<Edge> edges) {
        this(n);
        // 加边
        for (Edge edge : edges) {
            adjList.add(edge);
            M++;
        }
        if (!directed) {
            for (Edge edge : edges) {
                adjList.add(new Edge(edge.j, edge.i, edge.w));
            }
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

    public int kruskal() {
        int total = 0;
        ArrayList<Edge> edges = new ArrayList<>(M);
        for (int i = 1; i <= N; i++) {
            edges.addAll(adjList.getAdj(i));
        }
        edges.sort(Edge::compareTo); // 按边权值从小到大排序
        UnionFind p = new UnionFind(N);
        for (int i = 0; i < M; i++) { // 从小到大枚举每条边
            Edge edge = edges.get(i);
            int u = edge.i;
            int v = edge.j;
            if (p.find(u) != p.find(v)) { // 如果该边的两个顶点不在同一连通分量
                p.union(u, v); // 将u和v合并到同一集合
                total += edge.w;
            }
        }
        return total;
    }

    public int prim() { // 初始时：S = {1}，从剩下的点中，每次选出一个到点集S最近的点加到S中
        int total = 0;
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        MinPQ<Edge> pq = new MinPQ<>(N * M);
        pq.push(new Edge(0, 1, 0)); // 这里只用Edge的j和w属性，用w表示点j到点集S的距离
        dist[1] = 0; // 初始时：S = {1}

        while (!pq.isEmpty()) {
            Edge e = pq.pop(); // 每次选出一个到点集S最近的点
            int j = e.j;
            if (visited[j]) continue;
            visited[j] = true;
            total += e.w;
            for (Edge edge : adjList.getAdj(j)) {
                int ej = edge.j; // ej是j能指向的节点
                if (visited[ej]) continue; // 如果ej已经在S中则不用更新
                if (edge.w < dist[ej]) {
                    dist[ej] = edge.w;
                    pq.push(new Edge(0, ej, dist[ej]));
                }
            }
        }

        return total;
    }

}
