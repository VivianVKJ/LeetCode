/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        if(n<=0) return results;
        String current = new String();
        DFS(results,current,0,0,n);
        return results;
    }
    public void DFS(List<String> results,String current,int open,int close,int n){
        if(open==close && open==n) {
            results.add(new String(current.toString()));
            // System.out.print("√"+current);
            return;
        }
        if(current.length()<n*2){
            if(open<n) DFS(results,current+"(",open+1,close,n);
            if(close<open) DFS(results,current+")",open,close+1,n);
        }
    }
}

