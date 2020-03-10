/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0, n = nums.length;
        for (int num : nums)
            sum += num;
        if (S > sum || S < -sum)
            return 0;
        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= 2 * sum; s++) {
                int num = nums[i - 1];
                if (s + num <= 2 * sum)
                    dp[i][s] += dp[i - 1][s + num]; // ↙
                if (s - num >= 0)
                    dp[i][s] += dp[i - 1][s - num]; // ↘
            }
        }
        return dp[n][S + sum];
    }
}
// @lc code=end
