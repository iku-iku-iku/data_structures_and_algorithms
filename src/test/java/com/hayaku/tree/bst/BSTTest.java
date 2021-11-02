package com.hayaku.tree.bst;

import com.hayaku.search.base.ST;
import org.junit.Test;

public class BSTTest {
    @Test
    public void testPutGet() {
        ST<Integer, String> bst = new BinarySearchTree<>();
        bst.put(321, "good");
        System.out.println(bst.size());
        bst.put(999, "nice");
        System.out.println(bst.size());
        bst.put(10000, "haha");
        System.out.println(bst.size());
        bst.put(-100, "yes");
        System.out.println(bst.size());

        System.out.println(bst.get(-100));
        System.out.println(bst.get(10000));
        System.out.println(bst.get(989));
    }


    @Test
    public void testDelete() {
        ST<Integer, String> bst = new BinarySearchTree<>();
        bst.put(111, "sdasd");
        System.out.println(bst.size());
        bst.put(222, "222");
        System.out.println(bst.get(111));

        System.out.println(bst.size());
        System.out.println(bst.delete(111));
        System.out.println(bst.size());

        System.out.println(bst.get(111));

        System.out.println(bst.delete(222));
        System.out.println(bst.size());

    }

}
