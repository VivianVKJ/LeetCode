import java.util.HashMap;

/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 * similar question: #560
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //20Aug23
        int sum = 0, count = 0;
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum = (sum + A[i]) % K;
            sum = sum < 0 ? sum + K : sum;
            if (map.containsKey(sum))
                count += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
// @lc code=end
