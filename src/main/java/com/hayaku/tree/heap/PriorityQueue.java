package com.hayaku.tree.heap;


public interface PriorityQueue<K extends Comparable<K>> {
    void push(K element);
    K top();
    K pop();
    int size();
    boolean isEmpty();
}
