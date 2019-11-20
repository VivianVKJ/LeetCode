/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life

*/
// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length; int n = board[0].length;
        int[][] check = new int[board.length][board[0].length];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{1,1},{-1,-1},{-1,1}};
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                for(int d = 0;d<8;d++){
                    int temp_x = i+dir[d][0];
                    int temp_y = j+dir[d][1];
                    if(temp_x>=0 && temp_x<m && temp_y>=0 && temp_y<n)
                        check[i][j] = board[temp_x][temp_y]==1 ? check[i][j]+1 : check[i][j];
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n;j++){
                if(check[i][j]==3) board[i][j]=1;
                else if(check[i][j]==2 && board[i][j]==1) board[i][j]=1;
                else board[i][j]=0;
            }
        }
        
    }
}
// @lc code=end

