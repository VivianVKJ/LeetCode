/*
 * @lc app=leetcode id=77 lang=java
 * k个小于等于你n的数的组合
 * [77] Combinations
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(n<1) return results;
        List<Integer> current = new ArrayList<>();
        search(n,k,results,current,1);
        return results;
    }
    public void search(int n, int k, List<List<Integer>> results,List<Integer> current,int index){
        if(current.size()==k) {
            results.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i=index;i<=n-k+1+current.size();i++){
        //for(int i=index;i+current.size()-1<=n;i++){
            current.add(i);
            search(n,k,results,current,i+1);
            current.remove(current.size()-1);
        }
    }
}

