/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]==nums[i])
            return nums[i];
        }
        return nums[nums.length];
    }
}

