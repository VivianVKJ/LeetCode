/*
 * @lc app=leetcode id=309 lang=java
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int hold = Integer.MIN_VALUE, sold = 0, cool = 0;

        for (int i = 0; i < n; i++) {
            int sold_old = sold;
            hold = Math.max(hold, cool - prices[i]);
            sold = hold + prices[i];
            cool = Math.max(cool, sold_old);
        }
        return Math.max(sold, cool);
    }
}
// @lc code=end
