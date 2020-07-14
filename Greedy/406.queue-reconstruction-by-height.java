import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=406 lang=java
 * [height, k]
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]));
        List<int[]> result = new LinkedList<>();
        for (int[] p : people)
            result.add(p[1], p); // ArrayList add(int, E)
        return result.toArray(new int[people.length][2]);
    }
}
// @lc code=end
