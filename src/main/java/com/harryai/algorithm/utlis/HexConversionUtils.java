package com.harryai.algorithm.utlis;

/**
 * <p>
 * 进制转换工具类
 * <p>
 *
 * @author haorui.hao
 * @since 2023/03/24 10:37
 **/
public class HexConversionUtils {
    public static String convertBinary(int n) {
        return appendZero(Integer.toBinaryString(n),32);
    }

    private static String appendZero(String s, int bitCount) {
        int b = bitCount - s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertBinary(1));
    }
}
