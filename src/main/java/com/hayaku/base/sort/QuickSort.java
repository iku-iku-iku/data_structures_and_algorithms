package com.hayaku.base.sort;

public class QuickSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }
    private void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;
        int p = l - 1, q = r + 1;
        Comparable pivot = arr[l + r >> 1];
        while (p < q) {
            do p++; while(SortUtil.less(arr[p], pivot));
            do q--; while(SortUtil.less(pivot, arr[q]));
            if (p < q) SortUtil.exch(arr, p, q);
        }
        sort(arr, l, q);
        sort(arr, q + 1, r);
    }
}
