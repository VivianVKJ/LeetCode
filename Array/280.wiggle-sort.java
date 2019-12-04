/*
 * @lc app=leetcode id=280 lang=java
 * 3 5
 * 3 5 1 2
 * 3 5 1 6 2
 * [280] Wiggle Sort
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if(n<=1) return;
        int comp = -1;
        for(int i=0;i<n-1;i++){
            if((nums[i]-nums[i+1])*comp >= 0 ) { }//right order   
            else{
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
            comp*=-1;
        }
        return;
    }
}
// @lc code=end

