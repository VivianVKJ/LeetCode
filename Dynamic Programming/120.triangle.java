/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] fun =new int[n][n];

        List<Integer> last_layer=triangle.get(n-1);
        for(int i=0;i<n;i++){
            fun[n-1][i]=last_layer.get(i);
        }
        for(int i=n-2;i>=0;i--){
            List<Integer> curr_layer = triangle.get(i);
            for(int j=0;j<=i;j++){
                fun[i][j]=Math.min(fun[i+1][j],fun[i+1][j+1])+curr_layer.get(j);
            }
        }
        return fun[0][0];
    }
}

