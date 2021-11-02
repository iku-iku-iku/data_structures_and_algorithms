package com.hayaku.tree.other;

import org.junit.Test;

import java.util.HashMap;

public class HuffmanTest {
    @Test
    public void test() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a',10);
        map.put('b',20);
        map.put('c',30);
        map.put('d',40);
        map.put('e',50);
        Huffman huffman = new Huffman(map);
        huffman.encode();
        map.forEach((k, v) -> {
            System.out.print(k + ":");
            System.out.println(huffman.getCode(k));
        });
    }
}
