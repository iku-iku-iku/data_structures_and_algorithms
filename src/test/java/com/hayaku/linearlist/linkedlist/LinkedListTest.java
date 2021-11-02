package com.hayaku.linearlist.linkedlist;

import org.junit.Test;

public class LinkedListTest {
    @Test
    public void test() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0, 312);
        list.push(999);
        System.out.println(list.get(1));
        list.add(2, 3122);
        list.delete(0);
        System.out.println(list.get(1));
        list.set(1, 111);
        System.out.println(list.get(1));
    }
}
