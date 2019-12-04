/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0) return false;
        int n=matrix[0].length;
        if(n==0) return false;
        int l=0, r = m*n,mid=0;
        while(l<r){
            mid = (l+r)/2;
            int cx = mid/n, cy = mid%n;
            if(matrix[cx][cy]==target) return true;
            else if(matrix[cx][cy]<target) l=mid+1;
            else r=mid;
        }
        return false;
    }
    
}
// @lc code=end

