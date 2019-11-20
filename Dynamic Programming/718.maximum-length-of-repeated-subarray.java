/*
 * @lc app=leetcode id=718 lang=java
 *
 * [718] Maximum Length of Repeated Subarray
 */
class Solution {
    public int findLength(int[] A, int[] B) {
        int la = A.length, lb = B.length;
        if(la==0 || lb ==0) return 0;
        int[][] dp = new int[la+1][lb+1];
        for(int i=0;i<la;i++)
            for(int j=0;j<lb;j++){
                if(i==0 || j==0) dp[i][j]=0;
                else 
                    dp[i][j] = (dp[i-1]==dp[j-1] ? dp[i-1][j-1]+1 : 0);
            }
        return dp[la][lb];
    }
}

