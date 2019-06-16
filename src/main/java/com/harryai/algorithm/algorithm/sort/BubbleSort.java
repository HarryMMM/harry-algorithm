package com.harryai.algorithm.algorithm.sort;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.Util.RandomUtil;

import java.util.Arrays;

public class BubbleSort {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(10, RandomUtil.prepareInt(1,9));

    public static void bubbleSort(Integer[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                int a = data[j];
                int b = data[j + 1];
                if (a > b) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(data));
        bubbleSort(data);

    }
}
