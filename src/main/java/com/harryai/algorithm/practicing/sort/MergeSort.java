package com.harryai.algorithm.practicing.sort;

import com.harryai.algorithm.common.data.IntegerData;
import com.harryai.algorithm.utlis.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 归并排序
 * 是否稳定：稳定
 * 最大时间复杂度：O(nlogn)
 * 最小时间复杂度：O(nlogn)
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 *
 * @author Harry
 * @since 2020/05/05 00:06
 **/
public final class MergeSort {
    private MergeSort() {
    }

    public static void main(String[] args) {

//        Integer[] arr1 = {3,2};
        Integer[] arr1 = ArrayUtils.clone(IntegerData.ELE5_ARRAY_FIRST_2_SECOND_PLACE);
        System.out.println(Arrays.toString(arr1));
        sort2(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        ArrayUtil.mergeSortedArrayAsc(arr, start, mid, end);

    }

    private static <T extends Comparable<T>> T[] sort1(T[] arr) {
        if (ArrayUtils.getLength(arr) < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        T[] sl = Arrays.copyOfRange(arr, 0, mid);
        T[] sortLeft = sort1(sl);
        T[] sr = Arrays.copyOfRange(arr, mid, arr.length);
        T[] sortRight = sort1(sr);
        return ArrayUtil.mergeSortedArrayAsc(sortLeft, sortRight);

    }

    private static void sort2(Integer[] arr) {
        // 少于两个，不用排序。
        if (arr == null || arr.length < 2) {
            return;
        }
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(Integer[] arr, int left, int right) {
        if (right - left + 1 <= 1) {
            return;
        }
        int middle = ((right - left) >> 2) + left;
        doSort(arr, left, middle);
        doSort(arr, middle + 1, right);
        Integer[] tmp = new Integer[right - left + 1];

        int p1 = left, p2 = middle+1;
        int index = 0;
        while (p1 <= middle && p2 <= right) {
            if (arr[p1] >= arr[p2]) {
                tmp[index++] = arr[p2++];
            } else {
                tmp[index++] = arr[p1++];
            }
        }
        while (p1 <= middle) {
            tmp[index++] = arr[p1++];
        }
        while (p2 <= right) {
            tmp[index++] = arr[p2++];
        }
        int in = 0;
        while (left <= right) {
            arr[left++] = tmp[in++];
        }
    }
}
