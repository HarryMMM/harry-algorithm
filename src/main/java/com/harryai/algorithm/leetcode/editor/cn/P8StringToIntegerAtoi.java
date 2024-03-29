package com.harryai.algorithm.leetcode.editor.cn;//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的
// atoi 函数）。
//
// 函数 myAtoi(string s) 的算法如下： 
//
// 
// 读入字符串并丢弃无用的前导空格 
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。 
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。 
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 
//2 开始）。 
// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
//定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。 
// 返回整数作为最终结果。 
// 
//
// 注意： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。 
//
// 示例 2： 
//
// 
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
// 
//
// 示例 3： 
//
// 
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 200 
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成 
// 
//
// Related Topics 字符串 👍 1662 👎 0


//java:字符串转换整数 (atoi)
public class P8StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new P8StringToIntegerAtoi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // ******************************* 状态机 ****************************/
        // 时间 O(N) 空间O(1) 状态机状态使用了常量的空间
//        public int myAtoi(String s) {
//            Automaton automaton = new Automaton();
//            for (int i = 0; i < s.length() && !automaton.end(); i++) {
//                automaton.apend(s.charAt(i));
//            }
//            return (int) (automaton.sign * automaton.ans);
//
//        }
//
//        /**
//         * <p>
//         * 横标头表示输入的字符，列标头表示当前状态。
//         * 横竖焦点表示当前状态遇到各字符的状态流转
//         * </p>
//         * <p>
//         * |当前状态&输入字符|" "  |+/-   |number   |other|
//         * |start         |start|singed|in_number|end  |
//         * |singed        |end  |end   |in_number|end  |
//         * |in_number     |end  |end   |in_number|end  |
//         * |end           |end  |end   |end      |end  |
//         * </p>
//         */
//        public class Automaton {
//            private String status = "start";
//            private long ans = 0;
//            private int sign = 1;
//            private final Map<String, String[]> STATUS_MAP = new HashMap<String, String[]>() {{
//                put("start", new String[]{"start", "singed", "in_number", "end" });
//                put("singed", new String[]{"end", "end", "in_number", "end" });
//                put("in_number", new String[]{"end", "end", "in_number", "end" });
//                put("end", new String[]{"end", "end", "end", "end" });
//            }};
//
//            public void apend(char c) {
//                String s = nextStatus(c);
//                if ("in_number".equals(s)) {
//                    // +c-'0' 正好是c作为字符串代表的数字
        // +c-'0' 效率高于 先转String再转int
//                    ans = ans * 10 + c - '0';
//                    // 因为ans此时是正数，所以需要把Integer.MIN_VALUE转化为正数比较。先强转long在取负，否则就溢出了。
//                    ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
//                } else if ("singed".equals(s)) {
//                    if (c == '-') {
//                        sign = -1;
//                    }
//                }
//            }
//
//            public boolean end() {
//                return "end".equals(status);
//            }
//
//            private String nextStatus(char c) {
//                return this.status = STATUS_MAP.get(status)[getStatusIdx(c)];
//            }
//
//            private int getStatusIdx(char c) {
//                if (c == ' ') {
//                    return 0;
//                } else if (c == '+' || c == '-') {
//                    return 1;
//                } else if (Character.isDigit(c)) {
//                    return 2;
//                }
//                return 3;
//            }
//        }


        /********************************* 强写 ****************************/
        // 时间 O(N) 空间O(1)
        public int myAtoi(String s) {
            int length = s.length();
            long res = 0;
            boolean hasReadDigit = false;
            int singed = 1;
            boolean hasReadSinged = false;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (!hasReadDigit && !hasReadSinged && c == ' ') {
                    continue;
                } else if (!hasReadSinged && c == '+') {
                    hasReadSinged = true;
                    continue;
                } else if (!hasReadSinged && c == '-') {
                    singed = -1;
                    hasReadSinged = true;
                    // 比较时，要用char比较 '0' 0必须有单引号 ，'9'也一样
                } else if (c >= '0' && c <= '9') {
                    hasReadDigit = true;
                    hasReadSinged = true;
                    // +c-'0' 效率高于 先转String再转int
                    res = res * 10 + c - '0';
                    res = singed == 1 ? Math.min(res, Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
                } else {
                    break;
                }
            }
            return (int) res * singed;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
