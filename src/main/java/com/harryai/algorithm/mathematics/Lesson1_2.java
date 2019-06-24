package com.harryai.algorithm.mathematics;

/**
 * 二进制移位
 *
 * @author Harry
 * @since 2019/6/22 21:12
 */
public class Lesson1_2 {
    /**
     * 向左移位
     *
     * @param num 要移动的数字
     * @param m   移位的位数
     * @return
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * 向右逻辑移位
     *
     * @param num
     * @param m
     * @return
     */
    public static int rightLogicShift(int num, int m) {
        return num >>> m;
    }

    /**
     * 向右算术移位
     *
     * @param num
     * @param m
     * @return
     */
    public static int rightArithmeticShift(int num, int m) {
        return num >> m;
    }

    public static void main(String[] args) {
//        int num = -10;
//        System.out.println("原始数字：      " + Lesson1_1.decimalToBinary(num));
//        System.out.println("左移一位：     " + Lesson1_1.decimalToBinary(leftShift(num, 1)));
//        System.out.println("右移一位（算术）：" + Lesson1_1.decimalToBinary(rightArithmeticShift(num, 1)));
//        System.out.println("右移一位（逻辑）：" + Lesson1_1.decimalToBinary(rightLogicShift(num, 1)));
    }

}
