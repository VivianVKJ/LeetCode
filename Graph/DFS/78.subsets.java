import java.util.ArrayList;

/*
 * @lc app=leetcode id=78 lang=java
 * related question: 46permulation
 * O(2^n) 
 * [78] Subsets
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null) return null;
        List currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //avoid dupilcate: go ahead, x think about the former numbers
        DFS(nums,currentList,0,result);
        return result;
    }
    public void DFS(int[] nums, List currentList,int position, List<List<Integer>> result){
        result.add(new ArrayList<>(currentList)); //all nodes belong to results
        for(int i=position;i<nums.length;i++){
            currentList.add(nums[i]);
            DFS(nums,currentList,i+1,result);
            currentList.remove(currentList.size()-1);
        }
    }
}

