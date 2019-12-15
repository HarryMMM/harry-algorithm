package com.harryai.algorithm.algorithm.selfstudy.reverse;

import java.util.LinkedList;

/**
 * @author Harry
 * @since 2019/9/16 19:13
 */
public class ReverseArray {
    public static void reverse(int[] a, int start, int end) {
        int i = start < 0 ? 0 : start;
        int j = Math.min(end, a.length)-1;
        while (i < j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }

    }


}
