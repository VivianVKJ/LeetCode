import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (x, y) -> y[0] * y[0] + y[1] * y[1] - x[0] * x[0] - x[1] * x[1]); // max heap
        int[][] ans = new int[K][2];
        for (int[] point : points)
            heap.add(point);
        while (heap.size() > K)
            heap.poll();
        while (K > 0)
            ans[--K] = heap.poll();
        return ans;
    }
}
// @lc code=end
