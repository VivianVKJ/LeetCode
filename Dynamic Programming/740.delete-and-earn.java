/*
 * @lc app=leetcode id=740 lang=java
 *
 * [740] Delete and Earn
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int i : nums)
            count[i] += i;
        int take = 0, skip = 0;
        for (int i = 0; i < 10001; i++) {
            int take_old = take;
            int skip_old = skip;
            take = skip_old + count[i];
            skip = Math.max(skip_old, take_old);
        }
        return Math.max(take, skip);
    }
}
// @lc code=end
