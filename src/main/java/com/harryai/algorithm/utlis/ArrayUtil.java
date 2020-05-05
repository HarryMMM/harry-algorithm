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
        Integer[] arr1 = {1, 3, 5, 7, 9};
        Integer[] arr2 = {2, 4, 6, 8};

//        Integer[] arr1 = {9, 7, 5, 3, 1};
//        Integer[] arr2 = {8, 6, 4, 2};
        System.out.println(Arrays.toString(mergeSortedArrayAsc(arr1, arr2)));
    }

    /**
     * 合并两个有序数组
     *
     * @param ascOrDesc 升序还是降序
     * @param arr1 数组1
     * @param arr2 数组2
     * @param <T> 数组内存储的类型
     * @return 合并后的数组
     */
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
        T[] res = (T[]) Array.newInstance(arr1.getClass().getComponentType(), length1 + length2);
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
        while (index1 < length1) {
            res[resIndex++] = arr1[index1++];
        }
        while (index2 < length2) {
            res[resIndex++] = arr2[index2++];
        }
        return res;
    }

    /**
     * 将数组arr中的区域[start,end]分割为两个区域 ——>[start,middle]和(middle,end]，
     * 并按归并的方式是当前区域内有序
     *
     * @param ascOrDesc 排序方式： 升序，降序
     * @param arr 操作的数组
     * @param start [start,end]和[start,middle]区域的起点
     * @param middle [start,end]区域的中点 ——> [start,middle]的终点，包含middle，(middle,end]的起点，不包含middle。
     * @param end [start,end]和(middle,end]区域的终点
     * @param <T> 数组中的数据类型
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void mergeSortedArray(int ascOrDesc, T[] arr, int start, int middle,
                                                                  int end) {
        // 创建泛型数组
        T[] tmpArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), end - start + 1);
        int leftStart = start;
        int rightStart = middle + 1;
        int resIndex = 0;

        // 依据排序数组的升降序来生成判定数据比较条件
        CustomFunction.Comparator1<T> comparator = (ascOrDesc == ASC_ORDER) ? ArrayUtil::ascCompare :
                ArrayUtil::descCompare;

        // 变量两个数组，比较两个数组当前指针指向的数据大小，
        // 将较小的存储在结果数组中
        while (leftStart <= middle && rightStart <= end) {
            if (comparator.compare(arr, leftStart, rightStart)) {
                tmpArr[resIndex++] = arr[leftStart++];
            } else {
                tmpArr[resIndex++] = arr[rightStart++];
            }
        }
        // 将[start,middle]剩余的部分拷贝到临时数组
        while (leftStart <= middle) {
            tmpArr[resIndex++] = arr[leftStart++];
        }
        // 将(middle,end]剩余的部分拷贝到临时数组
        while (rightStart <= end) {
            tmpArr[resIndex++] = arr[rightStart++];
        }
        int tmp = start;
        // 用将归并排序好的数据覆盖原数组的[start,end]区域
        for (T re : tmpArr) {
            arr[tmp++] = re;
        }
    }

    public static <T extends Comparable<T>> T[] mergeSortedArrayAsc(T[] arr1, T[] arr2) {
        return mergeSortedArray(ASC_ORDER, arr1, arr2);

    }

    public static <T extends Comparable<T>> void mergeSortedArrayAsc(T[] arr1, int start, int middle, int end) {
        mergeSortedArray(ASC_ORDER, arr1, start, middle, end);

    }

    public static <T extends Comparable<T>> void mergeSortedArrayDesc(T[] arr1, int start, int middle, int end) {
        mergeSortedArray(DESC_ORDER, arr1, start, middle, end);

    }

    public static <T extends Comparable<T>> T[] mergeSortedArrayDesc(T[] arr1, T[] arr2) {
        return mergeSortedArray(DESC_ORDER, arr1, arr2);

    }

    private static <T extends Comparable<T>> boolean ascCompare(T[] arr1, int index1, T[] arr2, int index2) {
        return arr1[index1].compareTo(arr2[index2]) <= 0;
    }

    private static <T extends Comparable<T>> boolean ascCompare(T[] arr, int index1, int index2) {
        return arr[index1].compareTo(arr[index2]) <= 0;
    }

    private static <T extends Comparable<T>> boolean descCompare(T[] arr1, int index1, T[] arr2, int index2) {
        return arr1[index1].compareTo(arr2[index2]) >= 0;
    }

    private static <T extends Comparable<T>> boolean descCompare(T[] arr, int index1, int index2) {
        return arr[index1].compareTo(arr[index2]) >= 0;
    }

}