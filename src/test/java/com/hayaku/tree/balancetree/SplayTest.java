package com.hayaku.tree.balancetree;

import com.hayaku.base.sort.SortUtil;
import org.junit.Test;

import java.util.Random;

public class SplayTest {
    @Test
    public void test() {
        Splay<Integer> splay = new Splay<>();
        Random random = new Random();

        int magnitude = (int) 1e6;
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < magnitude; i++)
            splay.insert(random.nextInt(100));
        Integer[] arr = splay.inorderTraversal().toArray(new Integer[0]);
        long t2 = System.currentTimeMillis();

        System.out.println(t2 - t1 + "ms");
        assert SortUtil.isSorted(arr);
    }
}
