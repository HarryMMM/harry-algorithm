package com.harryai.algorithm.sort;

import com.harryai.algorithm.Util.DataPrepareUtil;

import java.util.Collections;
import java.util.List;

public class QuickSort {
    private static List<String> data = DataPrepareUtil.PrepareStringData();

    public static List<String> quickSort(List<String> data) {
        System.out.println(data);
        return data;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> strings = quickSort(data);
        Collections.sort(strings);
        long end = System.currentTimeMillis();
        System.out.println("Cost time " + (end - start));
    }
}
