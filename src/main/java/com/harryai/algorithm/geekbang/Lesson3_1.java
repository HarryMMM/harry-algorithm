package com.harryai.algorithm.geekbang;

/**
 * @author Harry
 * @since 2019/6/23 12:58
 */
public class Lesson3_1 {
    public static long getNumOfWheat(int grid) {
        long sum = 1;
        long wheatNum = 1;

        for (int i = 1; i < grid; i++) {
            wheatNum *= 2;
            sum += wheatNum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getNumOfWheat(63));
    }
}
