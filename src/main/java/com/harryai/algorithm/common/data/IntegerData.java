package com.harryai.algorithm.common.data;

import com.harryai.algorithm.utlis.DataPrepareUtil;
import com.harryai.algorithm.utlis.RandomUtil;

/**
 * @author Harry
 * @since 2020/05/04 21:55
 **/
public final class IntegerData {
    /**
     * 整形数据
     * 元素个数：5
     * 位数区间：[1,2]
     */
    public static final Integer[] ELE5_ARRAY_FIRST_2_SECOND_PLACE = DataPrepareUtil.prepareNumberData(5,
            RandomUtil.prepareInt(1, 3));
    /**
     * 整形数据
     * 元素个数：10
     * 位数区间：[1,2]
     */
    public static final Integer[] ELE10_ARRAY_FIRST_2_SECOND_PLACE = DataPrepareUtil.prepareNumberData(10,
            RandomUtil.prepareInt(1, 3));
    /**
     * 整形数据
     * 元素个数：10
     * 位数区间：[1,1]
     */
    public static final Integer[] ELE10_ARRAY_FIRST_PLACE = DataPrepareUtil.prepareNumberData(10,
            RandomUtil.prepareInt(1, 2));

    private IntegerData() {
    }
}
