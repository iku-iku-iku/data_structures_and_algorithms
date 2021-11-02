package com.hayaku.search.sequential;

import com.hayaku.search.base.ST;
import org.junit.Test;

public class SequentialSearchTest {
    @Test
    public void test() {
        ST<Integer, String> st = new SequentialSearchST<>();
        st.put(100, "hello");
        st.put(122, "world");
        st.put(133, "haha");
        System.out.println(st.get(122));
        System.out.println(st.size());
        System.out.println(st.contains(133));
        st.delete(133);
        System.out.println(st.contains(133));
        System.out.println(st.isEmpty());
        st.delete(122);
        st.delete(100);
        System.out.println(st.isEmpty());
    }
}
