package com.hayaku.tree.balancetree;

import java.util.*;

public class RbTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        K key;
        V val;
        Node left, right;
        int size;
        boolean color;
        Node(K key, V val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
        void pushUp() {
            this.size = 1;
            if (this.left != null) this.size += this.left.size;
            if (this.right != null) this.size += this.right.size;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", size=" + size +
                    ", color=" + color +
                    '}';
        }
    }

    private Node root;

    // 旋转后所对应的2-3树不变！
    /*
        /               /
       h               x
      / \RED   =>  RED/ \
     1   x           h   3
        / \         / \
       2   3       1   2
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.pushUp();
        return x;
    }
    /*
           /          /
          h          x
      RED/ \   =>   / \RED
        x   3      1   h
       / \            / \
      1   2          2   3
     */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.pushUp();
        return x;
    }



    public void put(K key, V val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    public Node put(Node h, K key, V val) {
        if (h == null) return new Node(key, val, RED);

        int compare = key.compareTo(h.key);
        if (compare < 0) h.left = put(h.left, key, val);
        else if (compare > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);

        h.pushUp();
        return h;
    }

    private void flipColor(Node root) {
        root.left.color = BLACK;
        root.right.color = BLACK;
        root.color = RED;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node root, K key) {
        if (root == null) return null;
        int compare = key.compareTo(root.key);
        if (compare < 0) return get(root.left, key);
        else if (compare > 0) return get(root.right, key);
        else return root.val;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node x) {
        if (x == null) return 0;
        Stack<Node> stk = new Stack<>();
        Stack<Integer> stk_depth = new Stack<>();
        stk.push(x);
        stk_depth.push(0);
        int max_depth = 0;
        while (!stk.empty()) {
            Node pop = stk.pop();
            int d = stk_depth.pop();
            max_depth = Math.max(d, max_depth);
            if (pop.left != null) {
                stk.push(pop.left);
                stk_depth.push(d + 1);
            }
            if (pop.right != null) {
                stk.push(pop.right);
                stk_depth.push(d + 1);
            }
        }
        return max_depth;
    }

    public int size() {
        return size(root);
    }

    public List<K> inorderTraverse() {
        ArrayList<K> list = new ArrayList<>();
        inorderTraverse(root, list);
        return list;
    }

    private void inorderTraverse(Node root, List<K> list) {
        if (root == null) return;
        inorderTraverse(root.left, list);
        list.add(root.key);
        inorderTraverse(root.right, list);
    }

    public Node deleteMin(Node x) {
        if (x.left == null) {
            if (x.right == null) {
//                return x.right;
            }
        }
        x.left = deleteMin(x.left);
        x.pushUp();
        return x;
    }
}
