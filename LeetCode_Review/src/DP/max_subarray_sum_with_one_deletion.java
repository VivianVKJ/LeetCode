package DP;

public class max_subarray_sum_with_one_deletion {
    public static void main(String[] args) {
        int[] arr = {-50};
        System.out.println(maximumSum(arr));
    }

    public static int maximumSum(int[] arr) {
        int n = arr.length, ans = Integer.MIN_VALUE;
        if (n <= 1) return n == 0 ? 0 : arr[0];
        int[] dp_left = new int[n + 2];
        int[] dp_right = new int[n + 2];
        dp_left[0] = 0;
        dp_right[n + 1] = 0;
        for (int i = 1; i <= n; i++) dp_left[i] = Math.max(dp_left[i - 1] + arr[i - 1], arr[i - 1]);
        for (int i = n; i > 0; i--) dp_right[i] = Math.max(dp_right[i + 1] + arr[i - 1], arr[i - 1]);
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp_left[i - 1] + dp_right[i + 1]);
            ans = Math.max(ans, dp_left[i]);
        }
        return ans;
    }
}
