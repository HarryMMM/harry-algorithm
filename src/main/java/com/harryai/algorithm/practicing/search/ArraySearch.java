package com.harryai.algorithm.practicing.search;

import com.harryai.algorithm.utlis.ArrayUtil;

import java.util.Arrays;

/**
 * @author Harry
 * @since 2020/05/05 17:32
 **/
public final class ArraySearch {
    private ArraySearch() {
    }

    public static <T extends Comparable<T>> int findKthLargestEle(T[] arr, int k) {
        return findKthLargestEle(arr, k, 0, arr.length - 1);
    }

    public static void main(String[] args) {
//        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int kthLargestEle = findKthLargestEle(arr, 6);
        System.out.println(Arrays.toString(arr));
        System.out.println(kthLargestEle);
        System.out.println(arr[kthLargestEle]);

    }

    /**
     * 查找第k个最大元素
     * 时间复杂度O(n)
     *
     * @param arr 要查找的数据
     * @param k 指定k
     * @param left 开始位置
     * @param right 结束位置
     * @param <T> 数组中的元素
     * @return 查找元素的下标
     */
    private static <T extends Comparable<T>> int findKthLargestEle(T[] arr, int k, int left, int right) {
        // 分区点（下标），partition左侧的都大于arr[pivotIndex]
        // partition右的数据都小于arr[pivotIndex]
        int pivotIndex = ArrayUtil.partition(arr, left, right);
        // 分区点所在位置，从左向右数，1为起始点。
        int position = pivotIndex + 1;
        // 由于左侧都比arr[pivotIndex]小，如果k等于pivot所在的位置（position）,则表示arr[pivotIndex]为要查找的数据
        if (k == position) {
            return pivotIndex;
        } else if (k < position) { // 如果k小于pivot所在的位置（position），则表示要查找的数据在左侧分区
            return findKthLargestEle(arr, k, left, pivotIndex);
        } else { // 否则，在右侧分区。
            return findKthLargestEle(arr, k, pivotIndex + 1, right);
        }
    }
}
