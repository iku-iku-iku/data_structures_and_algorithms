package com.hayaku.linearlist.linkedlist;

import com.hayaku.linearlist.base.LinearList;

public class MyLinkedList<T> implements LinearList<T> {
    protected class Node {
        public T data;
        public Node next;
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    protected Node head = new Node(null, null);

    public void push(T val) {
        head.next = new Node(val, head.next);
    }

    @Override
    public void add(int idx, T val) {
        Node cur = head;
        for (int i = 0; i < idx; i++) cur = cur.next;
        cur.next = new Node(val, cur.next);
    }

    @Override
    public void delete(int idx) {
        Node cur = head;
        for (int i = 0; i < idx; i++) cur = cur.next;
        cur.next = cur.next.next;
    }

    @Override
    public void set(int idx, T val) {
        Node cur = head.next;
        for (int i = 0; i < idx; i++) cur = cur.next;
        cur.data = val;
    }

    @Override
    public T get(int idx) {
        Node cur = head.next;
        for (int i = 0; i < idx; i++) cur = cur.next;
        return cur.data;
    }
}
