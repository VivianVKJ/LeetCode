/*
 * @lc app=leetcode id=1220 lang=java
 * 144
 * [1220] Count Vowels Permutation
 */

// @lc code=start
class Solution {
    int MOD = 1000_000_007;
    public int countVowelPermutation(int n) {
        long[] dp = new long[n+1];
        long[] count = {1,1,1,1,1};
        dp[1] = 5;
        if(n==1) return (int)dp[1];
        for(int i=2;i<=n;i++){
            long[] temp = new long[5];
            temp[0] = (count[1]+count[2]+count[4]) % MOD;
            temp[1] = (count[0]+count[2]) % MOD;
            temp[2] = (count[1]+count[3]);
            temp[3] = (count[2]) % MOD;
            temp[4] = (count[2]+count[3]) % MOD;
            // System.out.printf("(%d,%d,%d,%d,%d)",temp[0],temp[1],temp[2],temp[3],temp[4]);
            for(int j = 0;j<5;j++){
                count[j] = temp[j];
                dp[i] = (dp[i]+temp[j]) % MOD;
            }
        }
        return (int)dp[n];
    }
}
// @lc code=end

