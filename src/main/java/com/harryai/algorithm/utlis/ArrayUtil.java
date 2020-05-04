package com.harryai.algorithm.utlis;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Harry
 * @since 2020/05/04 22:21
 **/
public class ArrayUtil {
    private static final int ASC_ORDER = 1;
    private static final int DESC_ORDER = -1;

    private ArrayUtil() {
    }

    public static void main(String[] args) {
//        Integer[] arr1 = {2, 5, 7, 11};
//        Integer[] arr2 = {1, 4, 6, 9};
//        Integer[] arr1 = {1, 3, 5, 7, 9};
//        Integer[] arr2 = {2, 4, 6, 8};

        Integer[] arr1 = {9, 7, 5, 3, 1};
        Integer[] arr2 = {8, 6, 4, 2};
        System.out.println(Arrays.toString(mergeSortedArrayDesc(arr1, arr2)));
    }

    public static <T extends Comparable<T>> T[] mergeSortedArrayDesc(T[] arr1, T[] arr2) {
        return mergeSortedArray(DESC_ORDER, arr1, arr2);

    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] mergeSortedArray(int ascOrDesc, T[] arr1, T[] arr2) {
        if (ArrayUtils.isEmpty(arr1)) {
            return arr2;
        }
        if (ArrayUtils.isEmpty(arr2)) {
            return arr1;
        }
        int length1 = arr1.length;
        int length2 = arr2.length;
        // 创建泛型数组
        T[] res = (T[]) Array.newInstance(arr1[length1 - 1].getClass(), length1 + length2);
        int index1 = 0;
        int index2 = 0;
        int resIndex = 0;

        // 依据排序数组的升降序来生成判定数据比较条件
        CustomFunction.Comparator<T> comparator = (ascOrDesc == ASC_ORDER) ? ArrayUtil::ascCompare :
                ArrayUtil::descCompare;

        // 变量两个数组，比较两个数组当前指针指向的数据大小，
        // 将较小的存储在结果数组中
        while (index1 < length1 && index2 < length2) {

            if (comparator.compare(arr1, index1, arr2, index2)) {
                res[resIndex++] = arr1[index1++];
            } else {
                res[resIndex++] = arr2[index2++];
            }
        }
        if (index1 < length1) {
            for (int i = index1; i < length1; i++) {
                res[resIndex++] = arr1[i];
            }
        } else {
            for (int i = index2; i < length2; i++) {
                res[resIndex++] = arr2[i];
            }
        }
        return res;
    }

    private static <T extends Comparable<T>> boolean ascCompare(T[] arr1, int index1, T[] arr2, int index2) {
        return arr1[index1].compareTo(arr2[index2]) < 0;
    }

    private static <T extends Comparable<T>> boolean descCompare(T[] arr1, int index1, T[] arr2, int index2) {
        return arr1[index1].compareTo(arr2[index2]) > 0;
    }

    public static <T extends Comparable<T>> T[] mergeSortedArrayAsc(T[] arr1, T[] arr2) {
        return mergeSortedArray(ASC_ORDER, arr1, arr2);

    }


}