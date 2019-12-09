/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int m=A.length;
        if(m==0) return 0;
        int n=A[0].length;
        int[][] dp = new int[m][n];
        
        int[] dir = {-1,0,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j] = A[i][j];
                else{
                    int temp = Integer.MAX_VALUE;
                    for(int k=0;k<3;k++){
                        int y = j+dir[k];
                        if(y>=0 && y<n)
                            temp = Math.min(temp,A[i][j]+dp[i-1][y]); 
                    }
                    dp[i][j] = temp;
                }
            if(i==m-1)   min = Math.min(min,dp[i][j]); 
            }
        }
        return min;
    }
}
// @lc code=end

