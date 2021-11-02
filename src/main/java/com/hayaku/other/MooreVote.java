package com.hayaku.other;

import java.util.*;

public class MooreVote {
    public static void main(String[] args) {
        String[] s = new String[]{"aa", "ww", "aaa", "qq", "ww", "aaa", "aaa"};
        System.out.println(moreThanNDivideM(s, 3));
    }

    // 找到数组中数量等于一半或超过一半的元素
    static Object moreThanHalf(Object[] arr) {
        Object cur = 0;
        int cnt = 0;
        for (Object e : arr) {
            if (cnt == 0 || e.equals(cur)) {
                cur = e;
                cnt++;
            } else cnt--;
        }
        return cur;
    }

    // 找到数组中数量大于总个数/m的所有元素
    static List<Object> moreThanNDivideM(Object[] arr, int m) {
        int vote_num = m - 1;
        Object[] cur = new Object[vote_num];
        int[] cnt = new int[vote_num];
        f: for (Object e : arr) {
            for (int i = 0; i < vote_num; i++) {
                if (cnt[i] == 0 || e.equals(cur[i])) {
                    cur[i] = e;
                    cnt[i]++;
                    continue f;
                }
            }
            for (int i = 0; i < vote_num; i++) cnt[i]--;
        }

        int real_num[] = new int[vote_num];
        for (Object o : arr) {
            for (int i = 0; i < vote_num; i++) {
                if (cnt[i] != 0 && o.equals(cur[i])) real_num[i]++;
            }
        }

        List<Object> objects = new ArrayList<>(vote_num);
        for (int i = 0; i < vote_num; i++) {
            if (real_num[i] > arr.length / m) objects.add(cur[i]);
        }
        return objects;
    }
}
