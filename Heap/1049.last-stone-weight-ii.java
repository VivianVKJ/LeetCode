/*
 * @lc app=leetcode id=1049 lang=java
 * [31,26,33,21,40] -> 21  26, 31, 33, 40
 * 5  5  2  7  
 * [1049] Last Stone Weight II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] A) {
        boolean[] dp = new boolean[1501];
        // use dp to record the achievable sum of the smaller group.
        // dp[x] = 1 means the sum x is possible.
        dp[0] = true;
        int sumA = 0;
        for (int a : A) {
            sumA += a;
            for (int i = Math.min(1500, sumA); i >= a; --i)
                dp[i] |= dp[i - a];
        }
        for (int i = sumA / 2; i > 0; --i)
            if (dp[i])
                return sumA - i - i;
        return 0;
    }
}
// @lc code=end
