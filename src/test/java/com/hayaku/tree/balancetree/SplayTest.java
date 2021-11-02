package com.hayaku.tree.balancetree;

import com.hayaku.TestUtil.RandomUtil;
import com.hayaku.base.sort.SortUtil;
import org.junit.Test;

import java.util.Random;

public class SplayTest {
    @Test
    public void testInsert() {
        Splay<Integer> splay = new Splay<>();
        int magnitude = (int) 1e6;
        Integer[] randomNumbers = RandomUtil.generateRandomNumbers(magnitude);
        long t1 = System.currentTimeMillis();
        for (Integer randomNumber : randomNumbers) {
            splay.insert(randomNumber);
        }
        long t2 = System.currentTimeMillis();

        Integer[] arr = splay.inorderTraversal().toArray(new Integer[0]);
        assert SortUtil.isSorted(arr);

        System.out.println(t2 - t1 + "ms");
    }
    @Test
    public void testGetK() {
        Splay<Integer> splay = new Splay<>();
        Random random = new Random();
        int magnitude = (int) 1e1;
        for (int i = 0; i < magnitude; i++)
            splay.insert(random.nextInt(100));
        System.out.println(splay.inorderTraversal());
        System.out.println(splay.getKthValue(10));
    }
}
