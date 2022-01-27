package com.harryai.algorithm.geekbang;

import static com.harryai.algorithm.geekbang.Lesson1_1.decimalToBinary;

/**
 * 位“或” 位“与” 位“异或”
 *
 * @author Harry
 * @since 2019/6/22 21:49
 */
public class Lesson1_3 {
    public static int or(int num1, int num2) {
        return num1 | num2;
    }

    public static int and(int num1, int num2) {
        return num1 & num2;
    }

    public static int xor(int num1, int num2) {
        return num1 ^ num2;
    }


    public static void main(String[] args) {

        int a = 53;
        int b = 35;
        // 获取十进制数 53 和 35 的按位“或”
        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘或’结果是 %d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), Lesson1_3.or(a, b), decimalToBinary(Lesson1_3.or(a, b))));
        // 获取十进制数 53 和 35 的按位“与”
        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘与’结果是 %d(%s)",
                a, decimalToBinary(a), b, decimalToBinary(b), Lesson1_3.and(a, b), decimalToBinary(Lesson1_3.and(a, b))));
        // 获取十进制数 53 和 53 的按位“异或”
        System.out.println(String.format(" 数字 %d(%s) 和数字 %d(%s) 的按位‘异或’结果是 %d(%s)",
                a, decimalToBinary(a), a, decimalToBinary(a), Lesson1_3.xor(a, a), decimalToBinary(Lesson1_3.xor(a, a))));

    }


}
