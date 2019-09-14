package com.harryai.algorithm.algorithm.selfstudy.sort;

import com.harryai.algorithm.Util.DataPrepareUtil;
import com.harryai.algorithm.Util.RandomUtil;

import java.util.Arrays;

public class BubbleSort {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(10, RandomUtil.prepareInt(1, 9));

    // 从前向后冒泡
    public static void bubbleSort(Integer[] data) {
        int length = data.length;
        // 外层循环负责比较的轮数
        for (int i = 0; i < length - 1; i++) {
            // 内层循环负责数据归位
            // 第一轮完成后，最后一位一定时最大的，所以， j < length - i - 1，第二轮比较时不用再和最后以为比较了。
            // 其它轮同理
            for (int j = 0; j < length - i - 1; j++) {
                int a = data[j];
                int b = data[j + 1];
                if (a > b) {
                    data[j] = b;
                    data[j + 1] = a;
                }
            }
        }
    }


    /**
     * 打擂台，拿length和其它比较，如果将最大的放到length,其他位置一样
     *
     * @param data
     */
    public static void bubbleSort3(Integer[] data) {
        int length = data.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[i] < data[j]) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }

        }
    }

    /**
     * 从后向前冒泡，将小的值向前推
     *
     * @param data
     */
    public static void bubbleSort4(Integer[] data) {
        int length = data.length;
        for (int i = length - 1; i > 0; i--) {
            // 执行完第一轮后，最前面的一定是最小的，所以 j > length-1-i,不用再和最前以为比较了。
            // 同理，其余轮。
            for (int j = length - 1; j > length - 1 - i; j--) {
                if (data[j - 1] > data[j]) {
                    int tmp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmp;
                }
            }

        }
    }


    public static void bubbleSort2(Integer[] data) {
        boolean change = true;
        for (int i = 0; i < data.length - 1 && change; i++) {
            change = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                int a = data[j];
                int b = data[j + 1];
                if (a > b) {
                    data[j] = b;
                    data[j + 1] = a;
                    change = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(data));
        bubbleSort4(data);
        System.out.println(Arrays.asList(data));


    }
}
