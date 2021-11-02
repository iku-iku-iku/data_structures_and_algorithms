package com.hayaku.search.sequential;

import com.hayaku.linearlist.linkedlist.MyLinkedList;
import com.hayaku.search.base.ST;

public class SequentialSearchST<K, V> extends MyLinkedList<SequentialSearchST.Entry<K, V>> implements ST<K, V> {
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;

    @Override
    public boolean put(K key, V value) {
        if (head != null) {
            for (Node cur = head.next; cur != null; cur = cur.next) {
                if (key.equals(cur.data.key)) {
                    cur.data.value = value;
                    return false;
                }
            }
        }
        push(new Entry<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        for (Node cur = head.next; cur != null; cur = cur.next) {
            if (key.equals(cur.data.key)) {
                return cur.data.value;
            }
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (key.equals(cur.next.data.key)) {
                cur.next = cur.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
