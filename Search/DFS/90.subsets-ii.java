/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0) return null;
        List currenList = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        DFS(results,currenList,0,nums);
        return results;

    }
    public void DFS(List<List<Integer>> results, List currenList, int position, int[] nums){
        results.add(new ArrayList<Integer>(currenList));
        for(int i = position;i<nums.length;i++){
            currenList.add(nums[i]);
            DFS(results,currenList,i+1,nums);
            currenList.remove(currenList.size()-1);
            //remove duplicate
            while( (i+1)<nums.length && nums[i]==nums[i+1]) i++; 
        }
    }
}

