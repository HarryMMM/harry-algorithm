package com.harryai.algorithm.geekbang;

import java.math.BigInteger;

/**
 * 二进制和十进制互相转换
 *
 * @author Harry
 * @since 2019/6/22 20:57
 */
public class Lesson1_1 {
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));
        return bi.toString(2);

    }
    public static String binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource,2);
        return bi.toString();
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(10));
        System.out.println(binaryToDecimal("1010"));
    }
}
