package com.harryai.algorithm.algorithm.selfstudy.sort;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.Util.RandomUtil;

import java.util.Arrays;

public class InsertionSort {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(5, RandomUtil.prepareInt(1,2));

    public static void sort(Integer[] data) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i]; // 要往0到i-1之前这段有序数组插入的元素

            int j;
            // 把比tmp大的元素都忘后移动，直到找到tmp应该插入的位置
            for (j = i; j > 0 && tmp < data[j - 1]; j--) {
                data[j] = data[j - 1];
            }
            // 跳出循环的时候，表示已经找到tmp应该插入的位置了。
            data[j] = tmp;
            System.out.println(Arrays.asList(data));
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(data));
        sort(data);
    }
}
