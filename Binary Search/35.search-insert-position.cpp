/*
 * @lc app=leetcode id=35 lang=cpp
 * [35] Search Insert Position
 */
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int l=0,r=nums.size(); //[l,r)
        while(l<r){
            int mid = (l+r)/2;
            if(target==nums[mid]) return mid;
            else if(nums[mid]<target) l=mid+1; //[mid+1,r)
            else r=mid;  
        }
        return r;
    }
};

