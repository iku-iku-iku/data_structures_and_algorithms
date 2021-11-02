package com.hayaku.tree.balancetree;

import com.hayaku.TestUtil.RandomUtil;
import com.hayaku.base.sort.SortUtil;
import jdk.jshell.execution.JdiExecutionControlProvider;
import org.junit.Test;

import java.util.List;

public class RbTreeTest {
    @Test
    public void test1() {
        RbTree<Integer, String> rbTree = new RbTree<>();
        rbTree.put(133, "black");
        rbTree.put(122, "red");
        rbTree.put(111, "hello");
        rbTree.put(19, "aa");
        rbTree.put(10, "tree");
        System.out.println(rbTree.get(111));
        System.out.println(rbTree.get(10));
        System.out.println(rbTree.size());

        rbTree.inorderTraverse();
    }

    @Test
    public void test2() {
        RbTree<Integer, Object> rbTree = new RbTree<>();
        Integer[] randomNumbers = RandomUtil.generateRandomNumbers(1 << 20);
        for (Integer randomNumber : randomNumbers) {
            rbTree.put(randomNumber, null);
        }
        System.out.println(rbTree.depth());
    }

    @Test
    public void test3() {
        RbTree<Integer, Object> rbTree = new RbTree<>();
        int magnitude = (int) 1e6;
        Integer[] randomNumbers = RandomUtil.generateRandomNumbers(magnitude);
        long t1 = System.currentTimeMillis();
        for (Integer randomNumber : randomNumbers) {
            rbTree.put(randomNumber, null);
        }
        long t2 = System.currentTimeMillis();


        List<Integer> integers = rbTree.inorderTraverse();
        assert SortUtil.isSorted(integers.toArray(new Integer[0]));

        System.out.println(t2 - t1 + "ms");
    }
}
