import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        for (int i : stones)
            heap.offer(i);
        while (heap.size() > 1) {
            int y = heap.poll(), x = heap.poll();
            if (y > x)
                heap.offer(y - x);
        }
        return heap.size() == 0 ? 0 : heap.peek();
    }
}
// @lc code=end
