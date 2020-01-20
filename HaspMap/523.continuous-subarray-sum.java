/*
 * @lc app=leetcode id=523 lang=java
 * remember first put (0,-1);
 * [523] Continuous Subarray Sum
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); //sum,index
        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(k!=0) sum%=k;
            if(!map.containsKey(sum))
                map.put(sum,i);
            else {
                int pre_index = map.get(sum);
                if(i-pre_index>1) return true;
            }
        }
        return false;
    }
}
// @lc code=end
