/*
 * @lc app=leetcode id=1198 lang=java
 *
 * [1198] Find Smallest Common Element in All Rows
 */

import java.util.*;

// @lc code=start
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : mat[0])
            map.putIfAbsent(i, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map.containsKey(mat[i][j])) {
                    map.put(mat[i][j], map.get(mat[i][j]) + 1);
                }
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) == m)
                heap.add(i);
        }

        return heap.isEmpty() ? -1 : heap.peek();
    }
}
// @lc code=end
