package com.hayaku.tree.balancetree;

import java.util.ArrayList;
import java.util.List;

public class Splay<T extends Comparable<T>>{

    private Node<T> root;
    public void insert(T value) {
        Node<T> parent = null;
        Node<T> u = root;
        while (u != null) {
            parent = u;
            u = u.children[value.compareTo(u.value) > 0 ? 1 : 0];
        }
        u = new Node<>(value, parent);
        if (parent != null) {
            parent.children[value.compareTo(parent.value) > 0 ? 1 : 0] = u;
        }
        splay(u, null); // 转到根
    }
    public List<T> inorderTraversal() {
        List<T> list = new ArrayList<>(root.size);
        inorderTraversal(root, list);
        return list;
    }
    private void inorderTraversal(Node<T> node, List<T> list) {
        if (node == null) return;
        inorderTraversal(node.children[0], list);
        list.add(node.value);
        inorderTraversal(node.children[1], list);
    }
    private void splay(Node<T> node, Node<T> targetParent) {
        while (node.parent != targetParent) {
            Node<T> parent = node.parent;
            Node<T> grandparent = parent == null ? new Node<T>(null, null) : parent.parent;
            if (grandparent != targetParent) {
                if (grandparent.children[0] == parent ^ parent.children[0] == node) {
                    rotate(node);
                } else {
                    rotate(parent);
                }
            }
            rotate(node);
        }
        if (targetParent == null) {
            root = node;
        }
    }
    private void rotate(Node<T> son) {
        Node<T> parent = son.parent;
        Node<T> grandparent = parent.parent;
        int k1 = 0;
        if (grandparent != null) k1 = grandparent.children[1] == parent ? 1 : 0;
        int k2 = parent.children[1] == son ? 1 : 0;
        // 以下辈分变换过于离谱
        // 儿子代替他爸的位置
        if (grandparent != null)
            grandparent.children[k1] = son;
        son.parent = grandparent;
        // 儿子被自己的儿子代替位置
        parent.children[k2] = son.children[k2 ^ 1];
        if (son.children[k2 ^ 1] != null)
            son.children[k2 ^ 1].parent = parent;
        // 爸爸变儿子
        son.children[k2 ^ 1] = parent;
        parent.parent = son;

        pushUp(parent);
        pushUp(son);
    }
    // 更新size
    private void pushUp(Node<T> node) {
        node.size = 1;
        for (int i = 0; i < 2; i++)
            if (node.children[i] != null)
                node.size += node.children[i].size;
    }

}

class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    // 本包可见
    T value;
    Node<T> parent;
    Node<T>[] children;
    int size;

    @Override
    public int compareTo(Node<T> o) {
        return value.compareTo(o.value);
    }

    public Node(T value, Node<T> parent) {
        this.value = value;
        children = new Node[2];
        this.parent = parent;
        this.size = 1;
    }

}
