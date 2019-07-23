/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */
class Solution {
    public int results;
    public int totalNQueens(int n) {
        results = 0;
        if(n<=0) return results;
        List<Integer> cols = new ArrayList<Integer>();
        DFS(cols,n);
        return results;

    }
    public void DFS(List<Integer> cols,int n){
        if(cols.size()==n) {
            results++;
            return;
        }
        for(int col = 0; col<n;col++){
            if(isValid(col,cols)){
                cols.add(col);
                DFS(cols,n);
                cols.remove(cols.size()-1);
            }
        }
    }

    public boolean isValid(int col, List<Integer> cols){
        for(int i=0;i<cols.size();i++){
            if(col==cols.get(i)) return false;
            if(col+cols.size()==cols.get(i)+i) return false;
            if(col-cols.size()==cols.get(i)-i) return false;
        }
        return true;
    }
}

