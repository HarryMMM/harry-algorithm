package com.harryai.algorithm.geekbang.TheBeautyOfDatastructuresAndAlgorithms;

import java.util.Arrays;

/**
 * @author Harry
 * @since 2020/05/04 21:10
 **/
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] arr = {11, 6, 3, 5, 4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j].compareTo(arr[index]) < 0) {
                    index = j;
                }
            }
            if (index != i) {
                T tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }

    }
}
