/*
 * @lc app=leetcode id=39 lang=java
 * subsets DFS
 * avoid duplicate answers: 
 * record position and don't increse when step to the next
 * [39] Combination Sum
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0) return null;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<Integer>();
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
            DFS(candidates,target,results,currentList,currentSum+candidates[i],i);
            currentList.remove(currentList.size()-1);
        }
    }
}

