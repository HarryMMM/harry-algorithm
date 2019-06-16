package com.harryai.algorithm.Util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int prepareInt(int seed) {
        return random.nextInt(seed);
    }
}
