package com.harryai.algorithm.utlis;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @author haorui.hao
 * @since 2023/03/09 23:43
 **/
public class MathUtils {
    public static BigDecimal factorial(int num, Map<Integer, BigDecimal> map) {
        if (num == 1||num==0) {
            return BigDecimal.ONE;
        }
        return map.computeIfAbsent(num, key -> factorial(num - 1, map).multiply(new BigDecimal(num)));
    }
}
