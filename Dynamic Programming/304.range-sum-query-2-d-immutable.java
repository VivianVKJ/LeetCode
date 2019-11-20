/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m>0){
            int n = matrix[0].length;
            sum = new int[m][n];
            for(int i = 0;i<m;i++)
            {
                for(int j=0;j<n;j++){
                    if(j==0)
                        sum[i][j]=matrix[i][j];
                    else 
                        sum[i][j]=sum[i][j-1]+matrix[i][j];
                }
            }

        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==row2) return col1==0 ? sum[row1][col2] : (sum[row1][col2]-sum[row1][col1-1]);
        int res = 0;
        for(int i = row1;i<=row2;i++){
            int rowRes = col1==0 ? sum[i][col2] : (sum[i][col2]-sum[i][col1-1]);
            res += rowRes;
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

