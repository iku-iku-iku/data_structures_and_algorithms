package com.hayaku.base.sort;

import com.hayaku.TestUtil.TimeUtil;
import com.hayaku.tree.heap.MinPQ;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Random;

import static com.hayaku.TestUtil.RandomUtil.generateRandomNumbers;

public class SortTest {
    public void testSort(int magnitude, int avgN, Sort sort) throws NoSuchMethodException {
        assertCorrect(magnitude, sort);
        printAvgTime(magnitude, avgN, sort);
    }

    private void printAvgTime(int magnitude, int avgN, Sort sort) throws NoSuchMethodException {
        Integer[] randomNumbers = generateRandomNumbers(magnitude);
        Method sortMethod = sort.getClass().getMethod("sort", Comparable[].class);
        long time = TimeUtil.methodAverageTime(avgN, sortMethod, sort, (Object) randomNumbers);
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



    @Test
    public void testSort() throws NoSuchMethodException {
        int MAGNITUDE = (int) 5e5;
        int TIMES = 5;
        System.out.println("=============" + MAGNITUDE + "量级测试" + "===========");
        System.out.println("以下平均耗时是模拟" + TIMES + "次的结果");
        testSort(MAGNITUDE, TIMES, new HeapSort());
        testSort(MAGNITUDE, TIMES, new ShellSort());
        testSort(MAGNITUDE, TIMES, new QuickSort());
        testSort(MAGNITUDE, TIMES, new ArraysSort());
        testSort(MAGNITUDE, TIMES, new MergeSort());
        MAGNITUDE = (int) 1e4;
        TIMES = 5;
        System.out.println("=============" + MAGNITUDE + "量级测试" + "===========");
        System.out.println("以下平均耗时是模拟" + TIMES + "次的结果");
        testSort(MAGNITUDE, TIMES, new InsertionSort());
        testSort(MAGNITUDE, TIMES, new SelectionSort());
        testSort(MAGNITUDE, TIMES, new BubbleSort());
    }
}
