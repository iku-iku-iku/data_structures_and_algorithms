package com.hayaku.linearlist.base;

public interface LinearList<T> {
    void add(int idx, T val);
    void delete(int idx);
    void set(int idx, T val);
    T get(int idx);
}
