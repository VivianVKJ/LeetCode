/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap_bruteForce(int[] height){
        int ans = 0;
        //for each position
        //ans+=min(left_max, right_max) - heigh[i];
        return ans;
    }
    public int trap(int[] height){
        //Dynamic Programming
        //use two arrays to save time of finding max
        int n = height.length; if(n<=1) return 0;
        int[] left = new int[n]; int[] right = new int[n];
        left[0] = height[0];
        for(int i=1;i<n;i++)
            left[i] = Math.max(height[i],left[i-1]);
        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--)
            right[i] = Math.max(height[i],right[i+1]);
        int ans = 0;
        for(int i=0;i<n;i++)
            ans+=Math.min(left[i],right[i]) - height[i];
        return ans;
    }

    public int trap_twoPointers(int[] height) {
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

