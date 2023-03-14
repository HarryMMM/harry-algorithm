//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// You want to maximize your profit by choosing a single day to buy one stock 
//and choosing a different day in the future to sell that stock. 
//
// Return the maximum profit you can achieve from this transaction. If you 
//cannot achieve any profit, return 0. 
//
// 
// Example 1: 
//
// 
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you 
//must buy before you sell.
// 
//
// Example 2: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁴ 
// 
// Related Topics Array Dynamic Programming 👍 24136 👎 756

package com.harryai.algorithm.leetcode.editor.en;

//java:Best Time to Buy and Sell Stock
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 一直记录最小的价格(更小则替换)，并计算利润，如果利润更大就替换。
        // 可以这么做的原因是，股票只能在未来卖出，而不能现在在过去卖出。
        // 所以，只要一直用当天卖出买入是价格最低的，那天的利润大，就是最大利润。
        // 类似一个试错过程
        public int maxProfit(int[] prices) {
            // 记录最小，初始值置为最大。
            int minPrice = Integer.MAX_VALUE;
            // 初始值置为0
            int maxProfit = 0;
            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
            return maxProfit;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
