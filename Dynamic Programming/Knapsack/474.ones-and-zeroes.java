/*
 * @lc app=leetcode id=474 lang=java
 * ["111","1000","1000","1000"]\9\3
 * cannot solve using sorting
 * knapsack problem 
 * [474] Ones and Zeroes
 */
// @lc code=start

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int count_0 = count0(s, '0'), count_1 = s.length() - count_0;
            for (int i = m; i >= count_0; i--) {
                for (int j = n; j >= count_1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count_0][j - count_1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static int count0(String s, char c) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                ans++;
        }
        return ans;
    }
}

// knackpack question

// @lc code=end
