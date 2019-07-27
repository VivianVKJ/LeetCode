/*
 * @lc app=leetcode id=40 lang=java
 * 1,1,2,5,6,7,10
 * think of #90
 * once jumped a number, jump all same numbers
 * [40] Combination Sum II
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0) return null;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        DFS(candidates,target,results,currentList,0,0);
        return results;
    }
    public void DFS(int[] candidates,int target, List<List<Integer>> results, 
                    List currentList, int currentSum, int pos){
        if(currentSum>=target){
            if(currentSum==target) results.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=pos;i<candidates.length;i++){
            currentList.add(candidates[i]);
            DFS(candidates,target,results,currentList,currentSum+candidates[i],i+1);
            currentList.remove(currentList.size()-1);
            while( (i+1)<candidates.length && candidates[i]==candidates[i+1]) i++; 
        }
    }
}

