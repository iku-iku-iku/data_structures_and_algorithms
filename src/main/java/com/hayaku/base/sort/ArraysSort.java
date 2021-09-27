package com.hayaku.base.sort;

import java.util.Arrays;

public class ArraysSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        Arrays.sort(arr);
    }
}
