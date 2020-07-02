/*
 * @lc app=leetcode id=322 lang=java
 * [2]\n1
 * [186,419,83,408]\n6249
 * [186,83]\n352
 * [37,233,253,483]\n7163
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0)
            return -1;
        Arrays.sort(coins); // ascending order
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // fill with amount+1 to deal with no solution cases
        dp[0] = 0;
        for (int p = 1; p <= amount; p++) {
            for (int c = n - 1; c >= 0; c--) {
                if (p >= coins[c])
                    dp[p] = Math.min(dp[p], dp[p - coins[c]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChange_mine(int[] coins, int amount) {
        int n = coins.length;
        if (n == 0)
            return -1;
        Arrays.sort(coins); // ascending order
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) { // money
            for (int c = n - 1; c >= 0; c--) { // coin choice
                if (i - coins[c] == 0 || (i >= coins[c] && dp[i - coins[c]] > 0)) {
                    dp[i] = dp[i] > 0 ? Math.min(dp[i], dp[i - coins[c]] + 1) : dp[i - coins[c]] + 1;
                    // System.out.printf("[%d]=%d,", i,dp[i]);
                    // break; get the smallest one
                }
            }
            if (dp[i] == 0)
                dp[i] = -1;
        }
        return dp[amount];
    }
}
// @lc code=end\