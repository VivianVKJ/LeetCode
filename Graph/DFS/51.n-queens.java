import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        if(n<=0) return null;
        List cols = new ArrayList<Integer>();
        List<List<String>> result = new ArrayList<List<String>>();
        DFS(result,cols,n);
        return result;
        
    }
    public void DFS(List<List<String>> result, List<Integer> cols, int n){
        if(cols.size()==n) {
            result.add(drawRow(cols));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(cols, col)){
                cols.add(col);
                DFS(result, cols, n);
                cols.remove(cols.size()-1);
            }
        }
    }
    public List<String> drawRow(List<Integer> cols){
        List<String> board = new ArrayList<String>();
        for(int i=0;i<cols.size();i++){
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                s.append(j == cols.get(i) ? 'Q' : '.');
            }
            board.add(s.toString());
        }
        return board;
    }
    public boolean isValid(List<Integer> cols,int col){
        for(int i=0;i<cols.size();i++){
            if(cols.get(i)==col) return false; // [|]
            if(i+cols.get(i)==cols.size()+col) return false;  // [/]
            if(i-cols.get(i)==cols.size()-col) return false;  // [\]
        }
        return true;
    }
}

