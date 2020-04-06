package com.harryai.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 宝石与石头
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GemsAndStones {

    public static int numJewelsInStones(String gems, String stones) {
        int count = 0;
        List<String> gensCharList = Arrays.asList(gems.split(""));
        String[] stonesChar = stones.split("");
        for (int i = 0; i < stonesChar.length; i++) {

            if (gensCharList.contains(stonesChar[i])) {
                count++;
            }

        }
        return count;

    }

    public static int numJewelsInStones2(String gems, String stones) {
        int count = 0;
        char[] gemsC = gems.toCharArray();
        char[] stonesC = stones.toCharArray();
        for (int i = 0; i < gemsC.length; i++) {
            for (int j = 0; j < stonesC.length; j++) {
                if (gemsC[i] == stonesC[j]) {
                    count++;
                }
            }

        }
        return count;

    }

    public static int numJewelsInStones3(String gems, String stones) {
        int count = 0;
        for (int j = 0; j < stones.length(); j++) {
            if (gems.contains(String.valueOf(stones.charAt(j)))) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones3("aAB", "aAAbbbbBBB"));
    }
}
