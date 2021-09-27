package com.hayaku.base.sort;

import com.hayaku.TestUtil.TimeUtil;
import org.junit.Test;

import java.util.Random;

public class TestSort {
    public void testSort(int magnitude, int avgN, Sort sort) {
        assertCorrect(magnitude, sort);
        // 计时
        long total = 0;
        for (int i = 0; i < avgN; i++) {
            Integer[] randomNumbers = generateRandomNumbers(magnitude);
            long t1 = System.currentTimeMillis();
            sort.sort(randomNumbers);
            long t2 = System.currentTimeMillis();
            total += t2 - t1;
        }
        long time = total / avgN;
        System.out.println(sort.getClass().getSimpleName() + "平均耗时: " + time + "ms");
    }

    private void assertCorrect(int n, Sort sort) {
        Integer[] randomNumbers = generateRandomNumbers(n);
        if (n > 10) { // 当量级较大时，断言随机产生的数据是无序的
            assert !SortUtil.isSorted(randomNumbers);
        }
        sort.sort(randomNumbers);
        assert SortUtil.isSorted(randomNumbers); // 断言有序
    }

    private Integer[] generateRandomNumbers(int n) {
        Integer[] randomNumbers = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            randomNumbers[i] = random.nextInt();
        return randomNumbers;
    }

    @Test
    public void testSort() throws NoSuchMethodException {
        int magnitude = 1000000;
        int avgN = 1;
        System.out.println("=============" + magnitude + "量级测试" + "===========");
        System.out.println("以下平均耗时是模拟" + avgN + "次的结果");
        testSort(magnitude, avgN, new ShellSort());
        testSort(magnitude, avgN, new QuickSort());
        testSort(magnitude, avgN, new MergeSort());
        testSort(magnitude, avgN, new ArraysSort());
//        testSort(magnitude, avgN, new InsertionSort());
//        testSort(magnitude, avgN, new SelectionSort());
//        testSort(magnitude, avgN, new BubbleSort());
    }
}
