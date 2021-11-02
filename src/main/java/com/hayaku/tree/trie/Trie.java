package com.hayaku.tree.trie;

import com.hayaku.tree.base.Tree;

public class Trie implements Tree {
    static class Node {
        private Node[] sons;
        private int cnt = 0;

        Node(int n) {
            sons = new Node[n];
        }
    }

    private final Node root;
    private final int size;

    public Trie(int size) {
        this.size = size;
        this.root = new Node(size);
    }

    // 小写
    public Trie insertString(String str) {
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            int d = str.charAt(i) - 'a';
            if (cur.sons[d] == null) { // 如果d方向不通则打通
                cur.sons[d] = new Node(size);
            }
            cur = cur.sons[d]; // 沿着d方向走
        }
        cur.cnt++;
        return this;
    }

    public boolean existsString(String str) {
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            int d = str.charAt(i) - 'a';
            if (cur.sons[d] == null) return false;
            cur = cur.sons[d]; // 前进!!
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie(26);
        trie
                .insertString("hadoop")
                .insertString("zookeeper")
                .insertString("hive");
        System.out.println(trie.existsString("ss"));
        System.out.println(trie.existsString("hive"));
    }
}
