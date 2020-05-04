package com.harryai.algorithm.utlis;

import java.util.Arrays;
import java.util.function.Function;

public class LogUtil {
    public static long logCost(String action, long startTime) {
        String act = action.toLowerCase().substring(0, 1).toUpperCase() + action.toLowerCase().substring(1);
        System.out.println(String.format("%s cost time is : %s", act, (System.currentTimeMillis() - startTime)));
        return System.currentTimeMillis();

    }

    public static <T> void logSort(T[] arr, CustomFunction.NoResFunction<T[]> function){
        System.out.println(Arrays.toString(arr));
        function.apply(arr);
        System.out.println(Arrays.toString(arr));
    }
}
