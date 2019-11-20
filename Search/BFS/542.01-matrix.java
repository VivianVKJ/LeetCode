/*
 * @lc app=leetcode id=542 lang=java
 * [[0,0,0],[0,1,0],[1,1,1]]
 * [542] 01 Matrix
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n=matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) queue.offer(i*n+j);
                //remember here to be n
                else if(matrix[i][j]==1) matrix[i][j]=Integer.MAX_VALUE;
            }
        }
        int[] dir = {0,1,0,-1,0};
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int k =0;k<dir.length-1;k++){
                //new location we want to search for
                int x = top/n + dir[k];
                int y = top%n + dir[k+1]; 
                
                if(x>=0 && x<m && y>=0 && y<n && 
                matrix[x][y]>0 && matrix[x][y]>matrix[top/n][top%n]+1){
                    matrix[x][y] = matrix[top/n][top%n]+1;
                    queue.offer(x*n+y);
                }
            }       
        }
        return matrix;
    }

}

