package com.hayaku.tree.heap;

import com.hayaku.base.sort.Sort;
import com.hayaku.base.sort.SortUtil;

public class MinPQ<K extends Comparable<K>> implements PriorityQueue<K>{
    private K[] pq;
    private int idx = 0;

    public MinPQ(int size) {
        pq = (K[]) new Comparable[size];
    }

    public MinPQ() {}

    public MinPQ(K[] arr) {
        pq = (K[]) new Comparable[arr.length + 1];
        for (K comparable : arr) {
            push(comparable);
        }
    }

    @Override
    public void push(K element) {
        pq[++idx] = element;
        swim(idx);
    }

    private void swim(int k) {
        while (k > 1 && SortUtil.less(pq[k], pq[k / 2])) { // 晋升
            SortUtil.exch(pq, k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= idx) {
            int j = 2 * k;
            if (j < idx && SortUtil.less(pq[j + 1], pq[j])) j++;
            if (!SortUtil.less(pq[j], pq[k])) break;
            SortUtil.exch(pq, j, k);
            k = j;
        }
    }

    @Override
    public K top() {
        if (isEmpty()) return null;
        return pq[1];
    }

    @Override
    public K pop() {
        K element = pq[1];
        pq[1] = pq[idx];
        pq[idx--] = null;
        sink(1);
        return element;
    }

    @Override
    public int size() {
        return idx;
    }

    @Override
    public boolean isEmpty() {
        return idx == 0;
    }
}
