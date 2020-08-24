import java.util.HashMap;

/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int index = 0;
            List<Integer> curr = wall.get(i);
            for (int j = 0; j < curr.size() - 1; j++) {
                index += curr.get(j);
                map.put(index, map.getOrDefault(index, 0) + 1);
                max = Math.max(max, map.get(index));
            }
        }
        return n - max;
    }
}
// @lc code=end
