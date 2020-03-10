/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0)
            return 1;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) 
            for (int j = 0; j <= n; j++)
                if ((i == m && j == n - 1) || (i == m - 1 && j == n))
                    dp[i][j] = 1;
                else dp[i][j] = Integer.MAX_VALUE;
 
         for (int i = m-1; i >= 0 ; i--) {
             for (int j = n - 1; j >= 0; j--) {
                 dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1])-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}

/*
        int m = dungeon.length, n = dungeon[0].length;
        int[][][] dp = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j][0] = dungeon[i][j];
                    dp[i][j][1] = dungeon[i][j];
                } else if (i == 0) {
                    dp[i][j][1] = Math.min(dp[i][j - 1][1], dp[i][j - 1][0] + dungeon[i][j]);
                    dp[i][j][0] = dp[i][j - 1][0] + dungeon[i][j];
                } else if (j == 0) {
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i - 1][j][0] + dungeon[i][j]);
                    dp[i][j][0] = dp[i - 1][j][0] + dungeon[i][j];
                } else {
                    if (dp[i - 1][j][1] < dp[i][j - 1][1] || (dp[i - 1][j][1] == dp[i][j - 1][1] && dp[i][j - 1][0] >= dp[i-1][j][0])){//pick left
                        dp[i][j][0] = dp[i][j - 1][0] + dungeon[i][j];
                        dp[i][j][1] = Math.min(dp[i][j][0], dp[i][j - 1][1]);

                    }  else {
                        dp[i][j][0] = dp[i - 1][j][0] + dungeon[i][j];
                        dp[i][j][1] = Math.min(dp[i][j][0], dp[i - 1][j][1]);

                    }
                }
                System.out.print("<" + i + "," + j + ">: （" + dp[i][j][0] + "," + dp[i][j][1] + ")  ");
            }
            System.out.println();
        }
        return dp[m - 1][n - 1][1] >= 0 ? 1 : 1 - dp[m - 1][n - 1][1];
*/

//[[0,0,0],[1,1,-1]]
//[[1,-3,3],[0,-2,0],[-3,-3,-3]]
// @lc code=end

