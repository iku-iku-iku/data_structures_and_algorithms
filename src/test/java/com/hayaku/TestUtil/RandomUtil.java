package com.hayaku.TestUtil;

import java.util.Random;

public class RandomUtil {
    public static Integer[] generateRandomNumbers(int n) {
        Integer[] randomNumbers = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            randomNumbers[i] = random.nextInt();
        return randomNumbers;
    }
}
