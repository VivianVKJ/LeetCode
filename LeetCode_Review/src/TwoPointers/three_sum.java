package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 2) return ans;

        Arrays.sort(nums);
        int i = 0;
        while (i < n) {
            int tar = 0 - nums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int prel = nums[l], prer = nums[r];
                if (prel + prer < tar) {
                    while (l <= r && nums[l] == prel) l++;
                } else if (prel + prer > tar) {
                    while (l <= r && nums[r] == prer) r--;
                } else if (prel + prer == tar) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(prel);
                    triplet.add(prer);
                    ans.add(triplet);
                    while (l <= r && nums[l] == prel) l++;
                    while (l <= r && nums[r] == prer) r--;
                }
            }
            int base = nums[i];
            while (i < n && nums[i] == base) i++;
        }
        return ans;
    }
}
