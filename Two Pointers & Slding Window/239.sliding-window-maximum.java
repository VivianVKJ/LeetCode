import java.util.ArrayDeque;

/*
 * @lc app=leetcode id=239 lang=java
 * [1,-1]\n1
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0)
            return new int[0];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deq.isEmpty() && deq.peek() < i - k + 1)
                deq.pollFirst();
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i])
                deq.pollLast();
            deq.offer(i);
            if (i >= k - 1)
                ans[index++] = nums[deq.peek()];
        }
        return ans;
    }
}
// @lc code=end
