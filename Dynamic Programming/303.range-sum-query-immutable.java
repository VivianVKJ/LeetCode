/*
 * @lc app=leetcode id=303 lang=java
 * [-2,0,3,-5,2,-1]
 * [-2,-2,1,-4,-2,-3]
 * [303] Range Sum Query - Immutable
 */

// @lc code=start
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        if(n!=0){
            this.sum = new int[nums.length];
            this.sum[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                this.sum[i]=this.sum[i-1]+nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {

        return i==0 ? sum[j] : sum[j]-sum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

