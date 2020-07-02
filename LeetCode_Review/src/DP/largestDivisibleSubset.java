package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {4, 8, 10, 240};
        largestDivisibleSubset(nums);
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n]; //1 1 0
        int[] pre = new int[n]; // 0
        pre[0] = -1;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) max = Math.max(max, dp[i]);
        int end = n - 1;
        while (end >= 0 && dp[end] != max)
            end--;
        while (ans.size() < max) {
            ans.add(0, nums[end]);
            end = pre[end];
        }
        return ans;
    }
}
