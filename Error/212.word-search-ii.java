/*
 * @lc app=leetcode id=212 lang=java
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]
 * [212] Word Search II
 * [["a","a"]]\n["a"]
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        HashMap<String,Integer> hash = new HashMap<String,Integer>(); 
        List<String> res = new ArrayList<String>();
        for(int word_index = 0; word_index<words.length; word_index++){
            boolean[][] went = new boolean[m][n];
            String goal = words[word_index];
            for(int i = 0;i<m;i++)
                for(int j=0;j<n;j++){
                    if(!hash.containsKey(goal) && DFS(board,went,goal,0,i,j,m,n)){ 
                        res.add(new String(goal)); 
                        hash.put(goal,1); 
                    }
                      
                }           
        }
        return res;
    }
    public boolean DFS (char[][]board, boolean[][] went, String goal, 
                        int step, int x, int y, int m, int n){             
        System.out.printf("%s:(%d,%d),%d  ",goal,x,y,step);
        if(step==goal.length()) {
            return true;
        }
        if(x<0 || x>=m || y<0 || y>=n) return false;
        if(went[x][y]==true || board[x][y]!=goal.charAt(step)) return false;
        
        went[x][y]=true;
        if(    DFS(board,went,goal,step+1,x+1,y,m,n)
            || DFS(board,went,goal,step+1,x-1,y,m,n)
            || DFS(board,went,goal,step+1,x,y+1,m,n)
            || DFS(board,went,goal,step+1,x,y-1,m,n))
            return true;
        went[x][y]=false;
        return false;
    }
}

