package com.hayaku.base.sort;

import org.junit.Test;

import java.util.Random;

public class TestSort {
    public void testSort(int n, Sort sort) {
        Integer[] a = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            a[i] = random.nextInt();
        if (n > 10) { // 当量级较大时，断言随机产生的数据是无序的
            assert !SortUtil.isSorted(a);
        }

        long t1 = System.currentTimeMillis();
        sort.sort(a);
        long t2 = System.currentTimeMillis();

        assert SortUtil.isSorted(a);
        System.out.println(sort.getClass().getSimpleName() + "耗时: " + (t2 - t1) + "ms");
    }
    @Test
    public void testSort() {
        int magnitude = 10000;
        System.out.println("=============" + magnitude + "量级测试" + "===========");
        testSort(magnitude, new SelectionSort());
        testSort(magnitude, new InsertionSort());
        testSort(magnitude, new BubbleSort());
    }
}
