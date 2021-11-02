package com.hayaku.search.hash;


import com.hayaku.search.sequential.SequentialSearchST;

public class ChainingHashMap<K, V> implements MyHashMap<K, V> {
    private final SequentialSearchST<K, V>[] st;
    private final int M;
    private int size;

    public ChainingHashMap() {
        this(997);
    }

    public ChainingHashMap(int M) {
        this.M = M;
        st = (SequentialSearchST<K, V>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public boolean put(K key, V val) {
        if (st[hash(key)].put(key, val)) {
            size++;
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        return st[hash(key)].get(key);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean delete(K key) {
        if (st[hash(key)].delete(key)) {
            size--;
            return true;
        }
        return false;
    }
}
