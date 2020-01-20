/*
 * @lc app=leetcode id=62 lang=java
 * C(7,2) = 7*6/2*1 = 7 *..* 7-2+1
 * [62] Unique Paths
 */
class Solution {
    public int uniquePaths(int m, int n){
        int[] dp = new int[n];
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) dp[j]=1;
                else dp[j] = dp[j] + dp[j-1];
                //the old dp[j]<->dp[i-1][j];
            }
        }
        return dp[n-1];       
    }

    public int uniquePaths_DP2(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0) dp[i][j]=1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths_Comb(int m, int n){
        //C(m-1+n-1,n-1) or C(m-1+n-1,m-1);
        //Runtime 100%; Memory 5.1%
        int N = m+n-2, k=m-1;
        long res = 1;
        for(int i=1;i<=k;i++){
            res = res*(N-k+i)/i;
            //System.out.println(res); 
        }
        return (int)res;
    }


    public int uniquePaths_TLE(int m, int n) {
        int res[] = new int[1];
        DFS(m,n,0,0,went,res);
        return res[0];
    }
    public void DFS(int m, int n, int cm, int cn, boolean[][] went, int[] res){
        if(cm==m-1 && cn==n-1) {
            res[0]++; return;
        }
        if(cm==m || cn==n) return;
        DFS(m,n,cm+1,cn,went,res);
        DFS(m,n,cm,cn+1,went,res);

    }
}

