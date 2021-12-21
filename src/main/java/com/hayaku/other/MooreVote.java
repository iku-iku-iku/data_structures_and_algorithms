package com.hayaku.other;


public class MooreVote {

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

}
