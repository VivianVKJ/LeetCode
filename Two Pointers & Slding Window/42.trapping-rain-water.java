/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(height.length<=1) return 0;
        int left_max = 0, right_max =0;
        int l =0, r=height.length-1;
        int ans = 0;
        while(l<r){
            int hl = height[l], hr = height[r];
            if(hl<hr){
                left_max = hl>left_max ? hl : left_max;
                ans+=left_max-hl;
                l++;
            } // go right
            else{
                right_max = hr>right_max ? hr : right_max;
                ans+=right_max-hr;
                r--;
            }
        }
        return ans;
    }
}
// @lc code=end

