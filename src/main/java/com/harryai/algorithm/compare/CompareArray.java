package com.harryai.algorithm.compare;

/**
 * @author Harry
 * @since 2019/9/16 19:12
 */
public class CompareArray {

    public static int compare(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int i = 0;
        int j = 0;
        while (i < aLen || j < bLen) {
            if (i >= aLen) {
                return -1;
            } else if (j >= bLen) {
                return 1;
            } else {
                int aaa = a[i++];
                int bbb = b[j++];
                if (aaa > bbb) {
                    return 1;
                } else if (aaa < bbb) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
