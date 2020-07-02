/*
 * @lc app=leetcode id=132 lang=java
 *  fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] palindorme = new boolean[n][n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            palindorme[i][i] = true;
            dp[i] = i;
        }
        for (int i = 1; i < n; i++)
            for (int j = i; j >= 0; j--)
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || palindorme[i - 1][j + 1]))
                    if (j == 0)
                        dp[i] = 0;
                    else {
                        palindorme[i][j] = true;
                        dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                    }
        return dp[n - 1];
    }

    public boolean isValid(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            // if(sub[i]!=sub[j]) return false;
            if (sub.charAt(i) != sub.charAt(j))
                return false;
        }
        return true;
    }
}
// @lc code=end
