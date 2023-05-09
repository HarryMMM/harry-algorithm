//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4293 👎 0

package com.harryai.algorithm.leetcode.editor.en;

//java:盛最多水的容器
public class P11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
//        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间复杂度：O(n) n为height.length
        // 空间复杂度：O(1)
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int c = 0;
            while (l < r) {
                // 容器底长度
                int w = r - l;
                // 容器左边的高度
                int lH = height[l];
                // 容器右边的高度
                int rH = height[r];
                // 取最短边作为计算容器的容量的高（木桶原理）
                int h = Math.min(rH, lH);
                // 容器容量
                int cTep = w * h;
                // 本次容量更大，替换
                if (cTep > c) {
                    c = cTep;
                }
                // 哪个边短，移动指针（抛弃原来的边，取新的边）
                // 为什么移动短边而不是长边？
                // 因为：移动边的时候底（w）在变小，且容器的容量由最小边（Min(lH,rH)）决定。
                // 在w变小的时候，只有Min(lH,rH)变大才能增长容器容量。
                // 假设调整容器当前的最高边，因为最小边没有变化，Min(lH,rH)不会变大。
                // 所以，只有调整最低边，才有可能使Min(lH,rH)变大。因此，每次计算当前容量后调整最小边
                if (lH <= rH) {
                    l++;
                } else {
                    r--;
                }
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
