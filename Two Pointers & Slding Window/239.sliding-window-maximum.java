/*
 * @lc app=leetcode id=239 lang=java
 * [1,-1]\n1
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int r=k-1,max_index=0;
        if(k==0 || nums.length==0) return new int[0];
        int[] res = new int[nums.length-k+1];

        res[0] = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(nums[i]>res[0]){
                res[0] = nums[i];
                max_index = i;
            }
        }

        for(r=k;r<nums.length;r++){
            if(nums[r]>res[r-k]){
                res[r-k+1] = nums[r];
                max_index = r;
            }
            else{
                if(max_index==r-k){
                    res[r-k+1] =Integer.MIN_VALUE;
                    for(int j =r-k+1;j<=r;j++){
                        if(nums[j]>res[r-k+1]){
                            res[r-k+1]=nums[j];
                            max_index = j;
                        }
                    }
                }
                else res[r-k+1] = nums[max_index];
            }
        }
        return res;
    }
}
// @lc code=end

