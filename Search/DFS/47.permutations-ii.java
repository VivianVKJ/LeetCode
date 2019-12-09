/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();
        DFS(nums,curr,visited,ans);
        return ans;
    }
    public void DFS(int[] nums,List<Integer> curr,boolean[] visited,List<List<Integer>> ans){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==false){
                if(i>0 && nums[i]==nums[i-1] && visited[i-1]==false) continue;
                //avoid reverse order of duiplicate number traversal
                visited[i]=true;
                curr.add(nums[i]);
                DFS(nums,curr,visited,ans);
                curr.remove(curr.size()-1);
                visited[i]=false;
            }
        }
    }
}
// @lc code=end

