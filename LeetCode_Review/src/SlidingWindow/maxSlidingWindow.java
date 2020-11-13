package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || k <= 0) return new int[0];
        int[] ans = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deq.isEmpty() && deq.peek() < i - k + 1) {
                deq.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }
            // q contains index... r contains content
            deq.offer(i);
            if (i >= k - 1) {
                ans[ri++] = nums[deq.peek()];
            }
        }
        return ans;
    }
}
