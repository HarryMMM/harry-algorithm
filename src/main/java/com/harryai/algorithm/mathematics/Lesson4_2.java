package com.harryai.algorithm.mathematics;

import com.harryai.algorithm.Util.LogUtil;
import lombok.Data;

/**
 * 递归证明归纳法
 *
 * @author Harry
 * @since 2019/6/24 22:19
 */
public class Lesson4_2 {
    private static final int BASE_NUMBER = 2;

    public static boolean prove(int k, Result result) {
        // 证明n=1,命题是否成立
        if (k == 1) {
            if (Math.pow(BASE_NUMBER, k - 1) == 1) {
                result.wheatNum = 1;
                result.wheatTotalNum += result.wheatNum;
                return true;
            } else {
                return false;
            }
            // 如果n=k-1时命题成立，则n=k命题成立
        } else {
            // 判断n=k-1时是否成立
            boolean proveOfPrevious = prove(k - 1, result);


            result.wheatNum *= 2;
            result.wheatTotalNum += result.wheatNum;
            boolean proveCurrentOne = false;
            // 判断n=k时是否成立
            if (result.wheatTotalNum == Math.pow(BASE_NUMBER, k) - 1) {
                proveCurrentOne = true;
            }
            // 如果n=k-1和n=k都成立
            if (proveOfPrevious && proveCurrentOne) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Result result = new Result();
        long start = System.currentTimeMillis();
        boolean prove = prove(63, result);
        LogUtil.logCost("prove", start);
        System.out.println(prove);
        System.out.println(result);
    }
}

@Data
class Result {
    long wheatNum = 0;
    long wheatTotalNum = 0;

}