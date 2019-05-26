package com.harryai.algorithm.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataPrepareUtil {
    private static String[] metaStr = {
            "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };
    private static Integer[] metaInt = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static List<String> PrepareStringData() {
        int size = metaStr.length;
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            StringBuilder builder = new StringBuilder();
            for (int i1 = 0; i1 < 5; i1++) {
                int index = random.nextInt(size);
                String s = metaStr[index];
                builder.append(s);
            }
            data.add(builder.toString());

        }
        return data;
    }
}
