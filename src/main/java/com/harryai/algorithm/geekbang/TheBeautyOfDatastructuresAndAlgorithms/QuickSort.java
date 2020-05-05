package com.harryai.algorithm.geekbang.TheBeautyOfDatastructuresAndAlgorithms;

import com.harryai.algorithm.common.data.IntegerData;
import com.harryai.algorithm.utlis.LogUtil;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 快速排序 ：分治和分区
 * 思路：
 * <p>
 * 1. 确定基准数（挖坑），假定基准数为数组第一个数据。
 * 2. 从右到左遍历数组，找到比基准数小的：
 * 如果找不到，则向前移动右指针，直到左右指针相遇，停止查找；
 * 如果找到，则将基准数存放左侧的坑中，此时，右侧有一个坑
 * 2. 从左到右遍历数组，找到比基准数大的：
 * 如果找不到，则向后移动左指针，直到左右指针相遇，停止查找；
 * 如果找到，将基准数存放右侧的坑中，此时，左侧侧有一个坑
 * 3. 循环往复，直到左右指针相遇，结束循环，将基准数存入最后一个坑内。此时，基准数的左侧都比它小，右侧都比它大。
 * 4. 以基准数为终点，将数组分割为两部分。左右两部分分别执行 1~4步。直到不可分割，左指针>=右指针
 * </p>
 * 是否稳定：否
 * 是否原地：是
 * 最好时间复杂度：O(nlogn)
 * 最坏时间复杂度：O(n^2)
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 *
 * @author Harry
 * @since 2020/05/05 14:41
 **/
public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = IntegerData.ELE_RANDOM_FIVE_TO_TEN_ARRAY_FIRST_2_SECOND_PLACE;
//        Integer [] arr= {1,6,3,5,9,7,2,6};
        LogUtil.logSort(arr, QuickSort::sort);

    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int left, int right) {
        // 如果少于等于一个元素，不用排序
        if (ArrayUtils.getLength(arr) <= 1) {
            return;
        }
        // 如果left>=right,表示本轮已经查找完成，跳出
        if (left >= right) {
            return;
        }
        // 找出基准数据的位置 此时：
        // 基准数据 左侧所有数据均小于基准数据，右侧所有数据均大于基准数据。
        int mid = partition(arr, left, right);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);


    }

    private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
        // 取第一个数为基准数
        T pivot = arr[left];
        while (left < right) {
            // 从后向前找比基准数小的数，两种情况：
            // 1. 找到 则结束循环，此时left<right
            // 2. 找不到，则向前移动指针,直到left>=right,跳出循环。
            while (right > left && arr[right].compareTo(pivot) >= 0) {
                --right;
            }
            // 上一步只有找到时，left才会小于right。
            // 所以，如果left小于right,将找到的数据填入左侧的坑中。
            if (left < right) {
                arr[left] = arr[right];
                // 此时，left 及left左边 的位置均已在 上一轮 查找过，所以向右移动指针。
                ++left;
            }
            // 从前向后找比基准数大的数（只有找到并将左侧的坑填上后，当前动作。），两种情况：
            // 1. 找到 则结束循环，此时left<right
            // 2. 找不到，则向后移动指针,直到left>=right,跳出循环。
            while (right > left && arr[left].compareTo(pivot) <= 0) {
                ++left;
            }
            // 上一步只有找到时，left才会小于right。
            // 所以，如果left小于right,将找到的数据填入左侧的坑中。
            if (left < right) {
                arr[right] = arr[left];
                // 此时，right 及 right左边 的位置均已在 上一轮 查找过，所以向右移动指针。
                --right;
            }
        }
        arr[left] = pivot;
        return left;
    }
}
