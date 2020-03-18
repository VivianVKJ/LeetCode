/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int res = Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
        return res;
    }

    public int rob(int[] nums, int s, int e) {
        int n = nums.length;
        if (n <= 1)
            return n == 0 ? 0 : nums[0];
        int[] dp = new int[n + 1];
        dp[s + 1] = nums[s];
        for (int i = s + 2; i <= e; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[e];
    }
}
// @lc code=end
