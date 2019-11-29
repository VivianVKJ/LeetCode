/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int[] dp = new int[n];
        int ans = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    
    public int maxSubArray_Recurrsion(int[] nums){
        if(nums.length==1) return nums[0];
        return sum(nums,0,nums.length-1);
    }
    public int sum (int[] nums,int l,int h){
        if(l==h) return nums[l];
        int mid = (l+h)/2;
        int left = sum(nums,l,mid);     
        int right = sum(nums,mid+1,h);
        int cross = cross_sum(nums,l,h);
        //System.out.printf("(%d,%d),%d,%d,%d   ",l,h,left,right,cross);
        return Math.max(Math.max(left,right),cross);
    }
    public int cross_sum(int[] nums,int l,int h){
        if(l==h) return nums[l];
        int mid = (l+h)/2;
        int max_l =Integer.MIN_VALUE;
        int temp = 0;
        for(int i=mid;i>=0;i--){
            temp+=nums[i];
            max_l = temp > max_l ? temp:max_l;
        }
       
        int max_r = Integer.MIN_VALUE;
        temp = 0;
        for(int j=mid+1;j<=h;j++){
            temp+=nums[j];
            max_r = temp>max_r? temp:max_r;
        }
        
        return max_l+max_r;
    }


    public int maxSubArray_dp(int[] nums){
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        //dp[i]: max sum end with nums[i]
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i];
        }
        int res = nums[0];
        for(int i=0;i<nums.length;i++){
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}

