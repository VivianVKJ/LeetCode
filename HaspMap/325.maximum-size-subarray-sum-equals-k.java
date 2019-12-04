/*
 * @lc app=leetcode id=325 lang=java
 * think of 1.two sum
 * [1,0,-1]\n-1
 * [325] Maximum Size Subarray Sum Equals k
 */

// @lc code=start
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n=nums.length;
        if(n==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //currSum - prefix = k; -> find: prefix = curr-k
        int sum = 0, max=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(!map.containsKey(sum)) //only record the first prefix-sum
                map.put(sum,i); //sum end with i
            if(sum==k) max = i+1 > max ? i+1 : max;
            if(map.containsKey(sum-k)) max = i-map.get(sum-k) > max ? i-map.get(sum-k) :max;
        }
        return max;
    }
}
// @lc code=end

