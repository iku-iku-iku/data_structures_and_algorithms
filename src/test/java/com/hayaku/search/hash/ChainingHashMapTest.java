package com.hayaku.search.hash;

import org.junit.Test;

public class ChainingHashMapTest {
    @Test
    public void test() {
        ChainingHashMap<Integer, String> map = new ChainingHashMap<>();
        map.put(1, "dasfa");
        map.put(1, "aaaa");
        map.delete(1);
        map.put(1, "dffa");
        map.put(2, "dasd");
        System.out.println(map.get(2));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.delete(2);
        map.delete(1);
        System.out.println(map.isEmpty());
    }
}
