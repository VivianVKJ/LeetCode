import org.graalvm.compiler.lir.EdgeMoveOptimizer;

import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] count = new int[5];
        int m = grid.length, n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int edge = 0;
                    if (i == 0 || grid[i - 1][j] == 0)
                        edge++;
                    if (i == m - 1 || grid[i + 1][j] == 0)
                        edge++;
                    if (j == 0 || grid[i][j - 1] == 0)
                        edge++;
                    if (j == n - 1 || grid[i][j + 1] == 0)
                        edge++;
                    count[edge] += 1;
                }
            }
        }
        for (int i = 1; i < 5; i++) {
            sum += i * count[i];
        }
        return sum;
    }
}
// @lc code=end
