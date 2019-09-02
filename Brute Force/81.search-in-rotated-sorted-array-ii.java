/*
 * @lc app=leetcode id=81 lang=java
 * [1,1,1,3,1]\n3
 * [1,3,1,1]\n3
 * [81] Search in Rotated Sorted Array II
 */
class Solution {
    public boolean search(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }

    public boolean search_My(int[] nums, int target) {
        int l=0,r=nums.length,mid=0;
        l = goRight(l,nums);
        r = goLeft(r-1,nums)+1;
        while(l<r){
            mid = l + (r-l)/2;
            if(nums[mid]==target) return true;
            if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target <nums[mid])
                    r=goLeft(mid,nums);
                else l = goRight(mid,nums)+1;
            }
            else{
                if(nums[mid]<target && target <= nums[Math.min(r,nums.length-1)])
                    l = goRight(mid,nums)+1;
                else r = goLeft(mid,nums);
            }
        }
        return false;
    }
    public int goLeft(int r,int[] nums){
        while(r-1>0 && nums[r-1]==nums[r])
            r--;
        return r;
    }
    public int goRight(int l,int[] nums){
        while(l<nums.length-1 && nums[l+1]==nums[l])
            l++;
        return l;
    }
}

