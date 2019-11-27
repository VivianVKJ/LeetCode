/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if(n<=1) return n;
        int count = 0;
        boolean[] visited = new boolean[n]; //false
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                DFS(M,visited,i);
                count++;
            }
        }
        return count;    
    }
    public void DFS(int[][] M, boolean[] visited, int step){
        for(int j=0;j<M.length;j++){
            if(visited[j]==false && M[step][j]==1){
                visited[j] = true;
                DFS(M,visited,j);
            }
        }
    }

}

// @lc code=end

