package com.hayaku.base.sort;

import com.hayaku.tree.heap.MinPQ;

public class HeapSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        MinPQ pq = new MinPQ(arr);
        int i = 0;
        while (!pq.isEmpty()) {
            Comparable pop = pq.pop();
            arr[i++] = pop;
        }
    }
}
