package com.harryai.algorithm.sort;

import com.harryai.algorithm.utlis.DataPrepareUtil;
import com.harryai.algorithm.utlis.RandomUtil;

import java.util.Arrays;

/**
 * 冒泡排序的最好复杂度为：0(1) -> 如果带flag
 * 最坏为(n^2)
 */
public class BubbleSort {
    private static Integer[] data = DataPrepareUtil.prepareNumberData(10, RandomUtil.prepareInt(1, 9));
private static int hasFlag;
private  static  int noFlag;

    /**
     * 从前向后冒泡
     * (n-1)^2 = n^2-2n+1 次
     * 取最高阶项，所以时间复杂度为 O(n^2)
     * @param data
     */
    public static void bubbleSort(Integer[] data) {
        int length = data.length;
        // 外层循环负责比较的轮数
        for (int i = 0; i < length - 1; i++) {
            // 内层循环负责数据归位
            // 第一轮完成后，最后一位一定时最大的，所以， j < length - i - 1，第二轮比较时不用再和最后以为比较了。
            // 其它轮同理
            for (int j = 0; j < length - 1; j++) {
                noFlag++;
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
     * 1+2+3...+n-1=(1+n-1)*(n-1)/2=n*(n-1)/2=n^2/2-n/2
     *
     * 取最高阶项，并且取出与这个项相乘的常数，所以时间复杂度为O(n^2)
     * @param data
     */
    public static void bubbleSort5(Integer[] data) {
        int length = data.length;
        // 外层循环负责比较的轮数
        for (int i = 0; i < length - 1; i++) {
            // 内层循环负责数据归位
            // 第一轮完成后，最后一位一定时最大的，所以， j < length - i - 1，第二轮比较时不用再和最后以为比较了。
            // 其它轮同理
            for (int j = 0; j < length -i- 1; j++) {
                noFlag++;
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
                noFlag++;
                if (data[j - 1] > data[j]) {
                    int tmp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = tmp;
                }
            }

        }
    }


    /**
     * 最好：n-1 用常数1取代所有的加法常数， 所以最好时间复杂度为：O(1)
     * 最坏为1+2+3...+n-1=(1+n-1)*(n-1)/2=n*(n-1)/2=n^2/2-n/2
     * 取最高阶项，并去除与最高项相乘的常数，所以最坏时间复杂度为：0(n^2)
     *
     * @param data
     */
    public static void bubbleSort2(Integer[] data) {
        boolean change = true;
        for (int i = 0; i < data.length - 1 && change; i++) {
            change = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                hasFlag++;
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
//        Integer[] d={1,2,3,4,5};
        Integer[] d={11,10,9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.asList(d));
        bubbleSort5(d);
        System.out.println(noFlag);
        Integer[]e ={11,10,9,8,7,6,5,4,3,2,1};
        bubbleSort2(e);
        System.out.println(hasFlag);
        System.out.println(Arrays.asList(d));
        System.out.println(Arrays.asList(e));


    }
}
