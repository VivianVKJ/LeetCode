/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0]>=s ? 1 : 0;
        int l=0,r=1,tempSum = nums[0],ans = Integer.MAX_VALUE;

        while(r<n){ 
            tempSum+=nums[r++];
            while(tempSum>=s){
                ans = Math.min(r-l,ans);
                tempSum-=nums[l++];
            }  
        }
        if(ans>n) return 0;
        return ans;
    }
}
// @lc code=end

