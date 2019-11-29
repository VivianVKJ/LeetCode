/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int ans = 0;
        while(l<r){
            int hl = height[l],hr =height[r];
            ans = Math.max(ans,(r-l)*Math.min(hr,hl));
            if(hl<hr) l++;
            else r--;
        }
        return ans;
    }
}
// @lc code=end

