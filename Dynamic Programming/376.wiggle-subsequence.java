/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength_iterate(int[] nums) {
        int previousDiff = 0, res = 1;
        if (nums.length == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && previousDiff <= 0) || (diff < 0 && previousDiff >= 0)) {
                res++;
                previousDiff = diff;
            }
        }
        return res;
    }

    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        if (nums.length == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0)
                up = down + 1;
            else if (nums[i] - nums[i - 1] < 0)
                down = up + 1;
        }
        return Math.max(up, down);
    }
}
// @lc code=end
