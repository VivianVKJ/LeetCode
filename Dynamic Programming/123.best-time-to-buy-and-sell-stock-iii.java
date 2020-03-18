/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for (int i = 0; i < prices.length; i++) {
            oneBuy = Math.max(oneBuy, -prices[i]);// we set prices to negative, so the calculation of profit will be
                                                  // convenient
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] + oneBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);// we can buy the second only after first is sold
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }

        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }

    // wrong case
    public int maxProfit_Wrong(int[] prices) {
        int fir = 0, sec = -1, neg = 0, n = prices.length;
        int[] minus = new int[n];
        if (n <= 1)
            return 0;
        for (int i = 1; i < n; i++)
            minus[i] = prices[i] - prices[i - 1];
        int i = 1;
        while (i < n) {
            int sum = 0;
            while (i < n && minus[i] >= 0) {
                sum += minus[i];
                i++;
            }
            if (sum > fir) {
                sec = fir;
                fir = sum;
            } else if (sum > sec)
                sec = sum;
            if (i < n)
                i++;
        }
        return sec > 0 ? fir + sec : fir;
    }
}
// @lc code=end
