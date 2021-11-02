package com.hayaku.tree.bst;

import com.hayaku.search.base.ST;


public class BinarySearchTree<K extends Comparable<K>, V>
        implements ST<K, V> {
    private class Node  {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }

        public void pushUp() {
            this.size = 1;
            if (this.left != null) this.size += this.left.size;
            if (this.right != null) this.size += this.right.size;
        }
    }

    private Node root;

    public BinarySearchTree() {}

    @Override
    public boolean put(K key, V value) {
        int old = size();
        if (root == null) {
            root = new Node(key, value);
        } else put(root, key, value);
        return old != size();
    }

    private Node put(Node root, K key, V value) {
        if (root == null) return new Node(key, value);
        int compare = key.compareTo(root.key);
        if (compare < 0) {
            root.left = put(root.left, key, value);
        } else if (compare > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        root.pushUp();
        return root;
    }

    @Override
    public V get(K key) {
        Node cur = root;
        while (cur != null) {
            int compare = key.compareTo(cur.key);
            if (compare < 0) cur = cur.left;
            else if (compare == 0) return cur.value;
            else cur = cur.right;
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        int k = size();
        root = delete(root, key);
        return k != size();
    }

    private Node min(Node root) {
        if (root.left == null) return root;
        return min(root.left);
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        root.pushUp();
        return root;
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare < 0) node.left = delete(node.left, key);
        else if (compare > 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node t = node;
            node = min(t.right); // 替换当前节点为后继节点
            node.right = deleteMin(t.right); // 删除后继的原位并返回t.right
            node.left = t.left;
        }
        node.pushUp();
        return node;
    }

    @Override
    public int size() {
        if (root == null) return 0;
        return root.size;
    }

}
