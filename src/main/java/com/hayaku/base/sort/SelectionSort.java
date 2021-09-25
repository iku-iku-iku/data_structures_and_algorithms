package com.hayaku.base.sort;

public class SelectionSort implements Sort{
    // select出最小的换到前面
    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (SortUtil.less(arr[j], arr[minValueIndex]))
                    minValueIndex = j;
            }
            SortUtil.exch(arr, minValueIndex, i);
        }
    }
}
