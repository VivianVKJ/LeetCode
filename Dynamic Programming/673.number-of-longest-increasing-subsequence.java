/*
 * @lc app=leetcode id=673 lang=java
 *
 * [673] Number of Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 1;
        if (n <= 1)
            return n;
        int[] dp = new int[n];
        int[] count = new int[n];
        dp[0] = 1;
        count[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            count[0] = 1;
            int maxcount = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        maxcount = count[j];
                    } else if (dp[i] == dp[j] + 1)
                        maxcount += count[j];
                }
            }
            max = Math.max(dp[i], max);
            count[i] = maxcount;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (max == dp[i])
                ans += count[i];
        }
        return ans;
    }
}
// @lc code=end
