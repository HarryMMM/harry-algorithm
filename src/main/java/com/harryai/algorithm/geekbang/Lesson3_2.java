package com.harryai.algorithm.geekbang;

/**
 * @author Harry
 * @since 2019/6/23 12:58
 */
public class Lesson3_2 {

    /**
     * @param n- 待求的数, deltaThreshold- 误差的阈值, maxTry- 二分查找的最大次数
     * @return double- 平方根的解
     * @Description: 计算大于 1 的正整数之平方根
     */
//    public static double getSqureRoot(int n, double deltaThreshold, int maxTry) {
//        if (n <= 1) {
//            return -1.0;
//        }
//
//        double min = 1.0, max = (double)n;
//        for (int i = 0; i < maxTry; i++) {
//            double middle = (min + max) / 2;
//            double square = middle * middle;
//            double delta = Math.abs((square / n) - 1);
//            if (delta <= deltaThreshold) {
//                return middle;
//            } else {
//                if (square > n) {
//                    max = middle;
//                } else {
//                    min = middle;
//                }
//            }
//        }
//
//        return -2.0;
//    }



    public static double getSqureRoot(int n, double deltaThreshold, int maxTry) {
        if (n < 1) {
            return -0.1;
        }
        double max = n;
        double min = 1;
        for (int i = 0; i < maxTry; i++) {

            double middle = (min + max) / 2;
            double sum = middle * middle;
            if (Math.abs(sum - n) < deltaThreshold) {
                return middle;
            } else if (sum > n) {
                max = middle;
                continue;
            } else {
                min = middle;
            }
        }
        return -0.2;
    }

    public static void main(String[] args) {
        System.out.println(getSqureRoot(5, 0.000001, 10000));
    }

}
