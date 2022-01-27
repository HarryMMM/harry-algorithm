package com.harryai.algorithm.geekbang;

import com.harryai.algorithm.utlis.LogUtil;

/**
 * 归纳法
 *
 * 归纳法比迭代法快
 *
 * @author Harry
 * @since 2019/6/23 12:58
 */
public class Lesson4_1 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Lesson3_1.getNumOfWheat(63));
        long loopEnd = LogUtil.logCost("loop", start);
        System.out.println((long) (Math.pow(2, 63)));
        long concludeEnd = LogUtil.logCost("conclude", loopEnd);


    }


}
