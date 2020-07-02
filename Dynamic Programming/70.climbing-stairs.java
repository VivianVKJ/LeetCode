import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=70 lang=java
 * 1 2 3 4 
 * 1 2 3 
 * [70] Climbing Stairs
 */
class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    // array will cause TLE
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return memo.get(n);
    }

    public int climbStairs_DP(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n - 1];
    }
}
