/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dir = new int[]{0,1,0,-1,0};
        int[] count = new int[3];
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[][] visited  = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)  queue.offer(i*n+j);
                count[grid[i][j]]++;
            }
        if(count[1]==0) return 0;
        if(count[2]==0) return -1;
        int time = -1;
        while(!queue.isEmpty()){
            time++;
            int size = queue.size();
            
            for(int s = 0;s<size;s++){
                int x = queue.peek()/n;
                int y = queue.poll()%n;
                visited[x][y] = true;
                for(int d=0;d<4;d++){
                    int cx = x+dir[d];
                    int cy = y+dir[d+1];
                    if(cx>=0 &&cx<m && cy>=0 &&cy<n && visited[cx][cy]==false && grid[cx][cy]==1){
                        // System.out.print("("+x+y+")");
                        grid[cx][cy] = 2;
                        queue.offer(cx*n+cy);
                        
                    }
                }        
            }
        } 
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==false)  return -1;
        }
        return time;
    }
}

/*
  2 2
  1 1
  0 0
  2 0 
*/


// @lc code=end

