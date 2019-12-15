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
                // 从右向左找第一个小于x的数
                while (i < j && data.get(j).compareTo(pivot) >= 0) {
                    j--;
                }
                if (i < j)
                    data.set(i++, data.get(j));
               // 从左向右找第一个大于等于x的数
                while (i < j && data.get(i).compareTo(pivot) <= 0) {
                    i++;
                }
                if (i < j) {
                    data.set(j--, data.get(i));
                }
            }
            data.set(i, pivot);
            sort(data, left, i - 1); // 递归调用
            sort(data, i + 1, right);
        }
    }

    /**
     * 交换奇数偶数，使奇数分布在表头，使偶数分布在表尾
     * 时间复杂度为0(N),空间复杂度为0(1)。
     */
    public static void swapOddvenNumbers(int []nums){
        int i=0;
        int j=nums.length-1;
        while (i<j){
            // 当i指示的位偶数，j指示的为奇数，进行交换
            if(nums[i]%2==0&&nums[j]%2==1){
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                // 否则，如果i指示的为偶数，并且j指示的也为偶数
                // i不动，j向前移动
            }else if(nums[i]%2==0&&nums[j]%2==0) {
                j--;
                // 否则，如果i指示的为奇数，并且j指示的也为奇数
                // j不动，i向后移动
            }else if(nums[i]%2==1&&nums[j]%2==1){
                i++;
                // 否则，如果i指示的为奇数，并且j指示的为偶数
                // i和j都移动
            }else {
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {


        Integer[] dat = new Integer[]{4, 3, 6, 8, 2};
        System.out.println(Arrays.asList(dat));
        sort(dat, 0, dat.length - 1);
        System.out.println(Arrays.asList(dat));
    }
}
