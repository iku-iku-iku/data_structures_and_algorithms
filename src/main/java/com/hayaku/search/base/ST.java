package com.hayaku.search.base;

public interface ST<K, V> {
    boolean put(K key, V value); // 返回true表示增加了一个新key
    V get(K key);
    boolean delete(K key);
    int size();
    default boolean contains(K key) {
        return get(key) != null;
    }
    default boolean isEmpty() {
        return size() == 0;
    }
}
