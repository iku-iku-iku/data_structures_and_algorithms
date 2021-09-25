package com.hayaku.base.sort;

public class BubbleSort implements Sort{

    public void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (SortUtil.less(arr[j + 1], arr[j]))
                    SortUtil.exch(arr, j + 1, j);
    }
}
