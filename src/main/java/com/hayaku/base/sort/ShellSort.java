package com.hayaku.base.sort;

public class ShellSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1) { // 将数组变成h有序(步长为h)
            for (int i = h; i < n; i++) {
                Comparable key = arr[i];
                int j = i - h;
                while (j >= 0 && SortUtil.less(key, arr[j])) {
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = key;
            }
            h /= 3;
        }
    }
}
