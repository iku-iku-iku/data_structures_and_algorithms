package com.hayaku.search.hash;


import com.hayaku.search.base.ST;

public interface MyHashMap<K, V> extends ST<K, V> {
    interface Entry<K, V> {
        K getKey();
        V getValue();
        void setValue(V value);
    }
}
