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
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"

    };
    private static Integer[] metaInt = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * 随机生成多个字符串
     *
     * @param count  需要生成的字符串数量
     * @param length 生成的每个字符串的长度
     * @return
     */
    public static List<String> prepareStringData(int count, int length) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            data.add(prepareOneStringString(length));

        }
        return data;
    }

    /**
     * 随机生成一个字符串
     *
     * @param lenth 指定字符串的长度
     * @return 返回生成的字符串
     */
    public static String prepareOneStringString(int length) {
        int size = metaStr.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(size);
            builder.append(metaStr[index]);
        }

        return builder.toString();
    }

    public static String preParespecifyString(String str, int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Illegal specify length -> " + length);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int len = 2 * (length - 1);
        for (int i = 1; i <= len; i++) {
            stringBuilder.append(str);

        }
        return stringBuilder.toString();
    }
}



