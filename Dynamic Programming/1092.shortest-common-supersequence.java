/*
 * @lc app=leetcode id=1092 lang=java
 *
 * [1092] Shortest Common Supersequence 
 */

// @lc code=start
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m ^ j < n) {
                sb.append(i < m ? str1.charAt(i++) : str2.charAt(j++));
            } else if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i++));
                ++j;
            } else {
                sb.append(dp[i + 1][j] > dp[i][j + 1] ? str1.charAt(i++) : str2.charAt(j++));
            }
        }
        return sb.toString();
    }
}
// @lc code=end
