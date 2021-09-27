package com.hayaku.base.sort;

public class MergeSort implements Sort {
    Comparable[] tmp;
    @Override
    public void sort(Comparable[] arr) {
        tmp = new Comparable[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(Comparable[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + right >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(Comparable[] arr, int left, int mid, int right) {
        int p = left, q = mid + 1;
        int k = left;
        while (p <= mid && q <= right) {
            if (SortUtil.less(arr[p], arr[q])) tmp[k++] = arr[p++];
            else tmp[k++] = arr[q++];
        }
        while (p <= mid) tmp[k++] = arr[p++];
        while (q <= right) tmp[k++] = arr[q++];
        for (int i = left; i < k; i++) arr[i] = tmp[i];
    }
}
