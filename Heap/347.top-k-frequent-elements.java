/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> (map.get(y) - map.get(x)));
        for (int i : map.keySet())
            heap.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = heap.poll();
        return ans;
    }
}
// @lc code=end
