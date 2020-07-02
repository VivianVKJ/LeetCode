/*
 * @lc app=leetcode id=1043 lang=java
 *
 * [1043] Partition Array for Maximum Sum
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                curr = Math.max(curr, A[i - j + 1]);
                dp[i] = Math.max(dp[i], (i - j < 0 ? 0 : dp[i - j]) + curr * j);
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end
