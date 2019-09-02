/*
 * @lc app=leetcode id=34 lang=java
 * [2,2] \n 3
 * [34] Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0]=-1; ans[1]=-1;
        if(nums.length<=0)   
            return ans;
        int l=0,r=nums.length,mid=0; //[l,r)
        while(l<r){
            mid = (l+r)/2;
            if(nums[mid]<target) l = mid+1;
            else r = mid;
        }
        if(r>=nums.length || nums[r]!=target) return ans;
        ans[0]= r;
        while(r+1<nums.length && nums[r+1]==nums[r])
            r++;
        ans[1]=r;
        return ans;
    }
}

