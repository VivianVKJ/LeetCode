/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int la = A.length, lb = B.length;
        int[][] dp = new int[la + 1][lb + 1];
        for (int i = 0; i <= la; i++) {
            for (int j = 0; j <= lb; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[la][lb];
    }
}
// @lc code=end
