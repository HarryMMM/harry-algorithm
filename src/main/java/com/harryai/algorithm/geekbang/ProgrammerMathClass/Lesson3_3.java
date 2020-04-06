package com.harryai.algorithm.geekbang.ProgrammerMathClass;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 二分法查找
 *
 * @author Harry
 * @since 2019/6/23 12:58
 */
public class Lesson3_3 {
    public static int search(String[] list, String search) {

        if (list.length < 1) {
            return -1;
        }
        if (StringUtils.isEmpty(search)) {
            return -2;
        }
        int left = 0, right = list.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (list[middle].equals(search)) {
                return middle;
            } else if (list[middle].compareToIgnoreCase(search) > 0) {

                right = middle;
            } else {
                left = middle;
            }
        }
        return -3;

    }

    public static void main(String[] args) {


        String[] dictionary = {"i", "am", "one", "of", "the", "authors", "in", "geekbang"};

        Arrays.sort(dictionary);
        System.out.println(Arrays.asList(dictionary));

        String wordToFind = "i";

        int found = Lesson3_3.search(dictionary, wordToFind);
        if (found > 0) {
            System.out.println(String.format(" 找到了单词 %s，它的下标是%s", wordToFind, found));
        } else {
            System.out.println(String.format(" 未能找到单词 %s,它的下标是%s", wordToFind));
        }

    }


}
