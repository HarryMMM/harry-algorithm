package com.harryai.algorithm.geekbang.TheBeautyOfDatastructuresAndAlgorithms;

import com.harryai.algorithm.common.data.IntegerData;
import com.harryai.algorithm.utlis.LogUtil;

/**
 * @author Harry
 * @since 2020/05/04 21:10
 **/
public class SelectionSort {
    public static void main(String[] args) {
        LogUtil.logSort(IntegerData.ELE5_ARRAY_FIRST_2_SECOND_PLACE, SelectionSort::sort);
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
