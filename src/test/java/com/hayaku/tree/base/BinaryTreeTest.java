package com.hayaku.tree.base;

import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void test() {
        SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>();
        var n1 = tree.insert(13);
        var n2 = tree.insertRight(n1, 99);
        tree.insertLeft(n2, 88);
        tree.insertRight(n2, 100);
        System.out.println("preorder");
        tree.preorderTraverse();
        System.out.println("inorder");
        tree.inorderTraverse();
        System.out.println("postorder");
        tree.postorderTraverse();
    }
}
