/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        if(n==0) return 0;
        int sum = 0, ans= 0;
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==k) ans++;
            if(map.containsKey(sum-k)) ans+=map.get(sum-k).size();
            List<Integer> list = map.getOrDefault(sum,new ArrayList<>());
            list.add(i);
            map.put(sum,list);
            //System.out.printf("%d,%d ",sum,map.get(sum).size());  
        }
        return ans;
    }
}
// @lc code=end

