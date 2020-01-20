/*
 * @lc app=leetcode id=200 lang=java
 *[["1","1","0","0","0"]
   ["1","1","0","0","0"]
   ["0","0","1","0","0"],
   ["0","0","0","1","1"]]
   offer(0,1)offer(1,0)offer(1,1)offer(0,0)end<0,0> ans=1end<2,2> 
   ans=2end<3,3> ans=3offer(3,3)end<3,4> ans=4
 * [200] Number of Islands
 */
class Solution {
    public int numIslands(char[][] grid){
        if(grid.length==0) return 0;
        if(grid[0].length==0) return 0;
        int m = grid.length, n=grid[0].length, ans=0;
         for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    DFS(grid,i,j);
                    ans++;
                }
            }
        return ans;
    }
    public void DFS(char[][] grid, int x, int y){
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1'){
            grid[x][y]='0';
            DFS(grid,x+1,y);
            DFS(grid,x,y+1);
            DFS(grid,x-1,y);
            DFS(grid,x,y-1);
        }
    }
    
    public int numIslands_BFS(char[][] grid) {
        if(grid.length==0) return 0;
        if(grid[0].length==0) return 0;
        int m = grid.length, n=grid[0].length, ans=0;
        int[] dir = {0,1,0,-1,0};
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]=='1'){
                    //start BFS
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i*n+j);
                    while(!queue.isEmpty()){
                        int top = queue.poll();
                        int x = top/n;
                        int y = top%n;
                        for(int k=0;k<dir.length-1;k++){
                            int temp_x = dir[k]+x;
                            int temp_y = dir[k+1]+y;
                            if(temp_x>=0 && temp_x<m && temp_y>=0 && temp_y<n && grid[temp_x][temp_y]=='1'){
                                grid[temp_x][temp_y] = '0';
                                queue.offer(temp_x*n+temp_y);
                                // System.out.printf("offer(%d,%d)",temp_x,temp_y);             
                            }
                        }
                    }   
                    ans++;   
                    // System.out.printf("end<%d,%d> ans=%d",i,j,ans);             
                }
        return ans;
    }

}

