package com.hayaku.tree.base;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

public class SimpleBinaryTree<T> implements BinaryTree<T> {
    public class Node {
        private Node left, right;
        private T data;
        public Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    public Node insert(T val) {
        return this.root = new Node(val);
    }

    public Node insertLeft(Node root, T val) {
        return root.left = new Node(val);
    }

    public Node insertRight(Node root, T val) {
        return root.right = new Node(val);
    }

    @Override
    public void inorderTraverse() {
        inorderTraverse(root, System.out::println);
    }

    @Override
    public void preorderTraverse() {
        preorderTraverse(root, System.out::println);
    }

    @Override
    public void postorderTraverse() {
        postorderTraverse(root, System.out::println);
    }

    public void inorderTraverse(Node root, Consumer<T> action) {
        if (root == null) return;
        inorderTraverse(root.left, action);
        action.accept(root.data);
        inorderTraverse(root.right, action);
    }

    public void preorderTraverse(Node root, Consumer<T> action) {
        if (root == null) return;
        action.accept(root.data);
        preorderTraverse(root.left, action);
        preorderTraverse(root.right, action);
    }

    public void postorderTraverse(Node root, Consumer<T> action) {
        if (root == null) return;
        postorderTraverse(root.left, action);
        postorderTraverse(root.right, action);
        action.accept(root.data);
    }

}
