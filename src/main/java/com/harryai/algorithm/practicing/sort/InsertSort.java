package com.harryai.algorithm.practicing.sort;

import com.harryai.algorithm.common.data.IntegerData;
import com.harryai.algorithm.utlis.LogUtil;


/**
 * @author Harry
 * @since 2020/05/01 20:47
 **/
public class InsertSort {
    public static void main(String[] args) {
        LogUtil.logSort(IntegerData.ELE5_ARRAY_FIRST_2_SECOND_PLACE,InsertSort::sort2);
    }

    /**
     * 主要思想为：
     * 1. 将数组分为有序区和无序区。初始时第一个数据为有序区，其它为无序区。
     * 2. 从无序区拿出第一个数据，从后往前对比有序区中的数据。如果 有序区对比的数据 比 要插入的数据 大，
     * 则将有序区的对比数据向后挪一位。循环往复。直到 有序区的对比数据 小于 要插入的数据。
     * 3. 将要插入的数据插入有序区当前对比数据的后一位（此时，后一位已经被移动到更后一位，所以后一位可以理解为是空槽）。
     *
     * @param array 要排序的数组
     * @param <T> 指定的类型
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;
        // 初始时，第一个数据默认有序，所以i从1开始。
        for (int i = 1; i < length; i++) {
            // cur为无序区要插入有序区中的第一个数据
            T cur = array[i];
            // 要对比的数据为插入数据的前一位，所以，j=i-1;
            int j = i - 1;
            // 循环比较要插入的数据和无序区中的数据。
            // 如果要插入的数据小，则将有序区中的比对数据向后移动一位
            // 如果要插入的数据大，则将要插入的数据插入有序区中比对数据的后一位。
            for (; j >= 0; j--) {
                if (array[j].compareTo(cur) > 0) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 将当前数据插入
            array[j + 1] = cur;
        }
    }

    /**
     * 精简
     *
     * @param array 要排序的数组
     * @param <T> 指定的类型
     */
    public static <T extends Comparable<T>> void sort2(T[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            T cur = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j].compareTo(cur) > 0; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = cur;
        }
    }

}
