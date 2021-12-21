package com.hayaku.search.unionfind;

public class UnionFind { // 并查集
    private int[] p;
    public UnionFind(int size) {
        p = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            p[i] = i;
        }
    }

    public int find(int i) {
        if (p[i] != i) return p[i] = find(p[i]);
        return p[i];
    }

    public void union(int i, int j) {
        p[find(i)] = find(j);
    }
}
