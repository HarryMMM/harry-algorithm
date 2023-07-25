//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2526 👎 0

package com.harryai.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//java:Letter Combinations of a Phone Number
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("236"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 总体思路：
     * 1. 取第一个数字对应的第一个字符串中的第一个字符，拼接下一个字符串中的所有字符。
     * 2. 如果拼到最后一个数字的映射，结束并保存当前结果。并返回。
     * 3. 删除当前数字对应的字符串中已处理的字符，处理下一个
     * 4. 直到处理完成
     * 5. 边界为给的电话号码为空
     */
    class Solution {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        public List<String> letterCombinations(String digits) {
            List<String> list = new ArrayList<>();
            if (Objects.isNull(digits) || digits.length() == 0) {
                return list;
            }
            doLetterCombinations(list, phoneMap, digits, 0, new StringBuilder());
            return list;
        }

        private void doLetterCombinations(List<String> res, Map<Character, String> phoneMap, String digits, int idx,
                                          StringBuilder sb) {
            // 所有数字对应的字符串已经处理完成
            if (idx == digits.length()) {
                res.add(sb.toString());
            } else {
                char digit = digits.charAt(idx);
                String letters = phoneMap.get(digit);
                int length = letters.length();
                for (int i = 0; i < length; i++) {
                    sb.append(letters.charAt(i));
                    // 为当前字符串拼下一个号码的字符
                    doLetterCombinations(res, phoneMap, digits, idx + 1, sb);
                    // 删除当前位置已处理完成的字符，换另一个字符在当前位置（假设"abc"和"def",前者位置一定是0，后者是1，当a已经处理完成，则处理b）
                    sb.deleteCharAt(idx);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
