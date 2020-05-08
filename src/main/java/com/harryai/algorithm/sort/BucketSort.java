package com.harryai.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Harry
 * @since 2020/05/08 20:19
 **/
public class BucketSort {
    public static void main(String[] args) {
        int[] ints = {55, 43, 11, 13, 48, 78, 39, 12, 55, 33, 55, 44, 46, 47, 14, 67, 14, 35, 26, 36, 36, 23, 36, 72};
        System.out.println(Arrays.toString(ints));
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    @SuppressWarnings("unchecked")
    public static void sort(int[] arr) {
        int bucketSize = 10;
        // calculate the  range of data to be sort
        int minData = arr[0];
        int maxData = arr[0];
        for (int t : arr) {
            if (t < minData) {
                minData = t;
            }
            if (t > maxData) {
                maxData = t;
            }
        }
        // calculate the number of bucket and init buckets
        int bucketNum = (maxData - minData) / bucketSize + 1;
        List<Integer>[] newInstance = (LinkedList<Integer>[]) Array.newInstance(LinkedList.class, bucketNum);

        // insert the data in the arr into the  bucket
        for (int data : arr) {
            // calculate the index of bucket of data to be inserted.
            int index = (data - minData) / bucketSize;
            List<Integer> integers = newInstance[index] == null ? (newInstance[index] = new LinkedList<>()) : newInstance[index];
            integers.add(data);

        }
        int index = 0;
        // loop bucket and sort the data in the bucket and insert the data in buckets into array.
        for (List<Integer> integers : newInstance) {
            Collections.sort(integers);
            for (Integer integer : integers) {
                arr[index++] = integer;
            }
        }

    }

}
