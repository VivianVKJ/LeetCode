/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    int[] dir = new int[] { -1, 0, 1, 0, -1 };
    int Mod = (int) 1e9 + 7;

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[N + 1][m][n];
        for (int t = 1; t <= N; t++) {
            for (int r = 0; r < m; r++)
                for (int c = 0; c < n; c++)
                    for (int d = 0; d < 4; d++) {
                        int x = r + dir[d];
                        int y = c + dir[d + 1];
                        if (x < 0 || x == m || y < 0 || y == n) {
                            dp[t][r][c] += 1;
                        } else {
                            dp[t][r][c] = (dp[t][r][c] + dp[t - 1][x][y]) % Mod;
                        }
                    }
        }
        return dp[N][i][j];
    }
}
// @lc code=end
