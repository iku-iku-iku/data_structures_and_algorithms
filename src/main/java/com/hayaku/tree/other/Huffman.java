package com.hayaku.tree.other;

import com.hayaku.tree.heap.MinPQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman {
    public Huffman(Map<Character, Integer> map) {
        characterNodeMap = new HashMap<>();
        List<Node> arr = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Node charNode = new Node(entry.getValue());
            arr.add(charNode);
            characterNodeMap.put(entry.getKey(), charNode);
        }
        this.minPQ = new MinPQ<>(arr.toArray(new Node[0]));
    }

    private Node tree;
    private final Map<Character, Node> characterNodeMap;

    public void encode() {
        while (this.minPQ.size() >= 2) {
            Node n1 = this.minPQ.pop();
            Node n2 = this.minPQ.pop();
            this.minPQ.push(new Node(n1, n2));
        }
        this.tree = this.minPQ.pop();
    }

    public String getCode(char c) {
        Node node = characterNodeMap.get(c);
        StringBuilder code = new StringBuilder();
        while (node.parent != null) {
            Node p = node.parent;
            code.append(p.lchild == node ? '0' : '1');
            node = p;
        }
        return code.reverse().toString();
    }

    private class Node implements Comparable<Node>{
        Node parent, lchild, rchild;
        int val;
        Node(int val) {
            this.val = val;
        }
        Node(Node l, Node r) {
            val = l.val + r.val;
            lchild = l;
            rchild = r;
            l.parent = this;
            r.parent = this;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }

    private final MinPQ<Node> minPQ;

}
