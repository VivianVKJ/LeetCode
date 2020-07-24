/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || dp[j + 1][i - 1] == 1)) ? 1 : 0;
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
// @lc code=end
