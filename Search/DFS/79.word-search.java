/*
 * @lc app=leetcode id=79 lang=java
 * //我的问题： 
//返回类型boolean
//先写false 再写ture
//return value 怎么取？
 * [79] Word Search
 */
class Solution {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        int x_b = board.length, y_b=board[0].length;
        if(word.length()==0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        //Search the start node
        for(int i=0;i<x_b;i++){
            for(int j=0;j<y_b;j++){
                if(board[i][j]==word.charAt(0) && search(board,visited,0,word,i,j))
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board,boolean[][] visited,int step,String word,int x,int y){
        // System.out.printf("step=%d,(%d,%d)\n",step,x,y);
        int x_b = board.length, y_b=board[0].length;
        if(step==word.length()) return true;
        if(x<0 || x>=x_b || y<0 || y>=y_b )
            return false;      
        if(visited[x][y]==true || board[x][y]!=word.charAt(step))
            return false;      
        
        visited[x][y]=true;
        // System.out.print("√");
        for(int i=0;i<4;i++){ //4 directions
            if(search(board,visited,step+1,word,x+direction[i][0],y+direction[i][1])) 
                return true;   
            // search(board,visited,step+1,word,x+direction[i][0],y+direction[i][1]);

        }
        // System.out.print("-|");
        visited[x][y]=false;  //ERROR
        return false;
    }
}

