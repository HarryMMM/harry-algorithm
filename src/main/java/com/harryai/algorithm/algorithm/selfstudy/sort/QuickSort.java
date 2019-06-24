package com.harryai.algorithm.algorithm.selfstudy.sort;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.Util.RandomUtil;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(5, RandomUtil.prepareInt(1, 3));

//
//    public static void sort(Integer[] data, int left, int right) {
//        if (left < right) {
//            int pivot = data[left];
//            int i = left, j = right;
//            while (i < j && data[j] >= pivot) {
//                j--;
//            }
//            if (i < j) {
//                data[i++] = data[j];
//            }
//            while (i < j && data[i] < pivot) {
//                i++;
//            }
//            if (i < j) {
//                data[j--] = data[i];
//            }
//            data[i] = pivot;
//            sort(data, left, i - 1);
//            sort(data, i + 1, right);
//        }
//
//    }

    public static <T extends Comparable<? super T>> void sort(T[] data, int left, int right) {
        if (left < right) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = left, j = right;
            T pivot = data[left];
            while (i < j) {
                while (i < j && data[j].compareTo(pivot) >= 0) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    data[i++] = data[j];

                while (i < j && data[i].compareTo(pivot) <= 0) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    data[j--] = data[i];
            }
            data[i] = pivot;
            sort(data, left, i - 1); // 递归调用
            sort(data, i + 1, right);
        }
    }


    public static <T extends Comparable<? super T>> void sort(List<T> data, int left, int right) {
        if (left < right) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = left, j = right;
            T pivot = data.get(left);
            while (i < j) {
                while (i < j && data.get(j).compareTo(pivot) >= 0) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    data.set(i++, data.get(j));

                while (i < j && data.get(i).compareTo(pivot) <= 0) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    data.set(j--, data.get(i));
            }
            data.set(i, pivot);
            sort(data, left, i - 1); // 递归调用
            sort(data, i + 1, right);
        }
    }


    public static void main(String[] args) {


        Integer[] dat = new Integer[]{4, 3, 6, 8, 2};
        System.out.println(Arrays.asList(dat));
        sort(dat, 0, dat.length - 1);
        System.out.println(Arrays.asList(dat));
    }
}
