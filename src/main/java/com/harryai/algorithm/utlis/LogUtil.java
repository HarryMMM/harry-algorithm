package com.harryai.algorithm.utlis;

public class LogUtil {
    public static long logCost(String action, long startTime) {
        String act = action.toLowerCase().substring(0, 1).toUpperCase() + action.toLowerCase().substring(1);
        System.out.println(String.format("%s cost time is : %s", act, (System.currentTimeMillis() - startTime)));
        return System.currentTimeMillis();

    }
}
