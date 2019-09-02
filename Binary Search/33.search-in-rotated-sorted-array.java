/*
 * @lc app=leetcode id=33 lang=java
 * l -----
 *       p -----r
 * [1,3]\n2
 * [5,1,3]\n2 --> target<=nums[...]
 * [33] Search in Rotated Sorted Array
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<=0) return -1;
        int l = 0, r = nums.length,mid = 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid] == target) return mid;
            if(nums[l]<nums[mid]){
                if(nums[l]<=target && target<nums[mid]) r = mid;  //<=
                else l = mid+1;
            }
            else {
                if(nums[mid]<target && target<=nums[Math.min(r,nums.length-1)] ) l = mid+1;
                //r may exceed the limit
                //<=
                else r = mid;
            }
        }
        return -1;
    }
}

