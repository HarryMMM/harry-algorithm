package com.harryai.algorithm.utlis;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int prepareInt(int bound) {
        return random.nextInt(bound);
    }

    public static int prepareInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }
}
