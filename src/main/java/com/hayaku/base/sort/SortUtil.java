package com.hayaku.base.sort;

import java.util.Arrays;

public class SortUtil {
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1]))
                return false;
        }
        return true;
    }

    public static void show(Comparable[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
