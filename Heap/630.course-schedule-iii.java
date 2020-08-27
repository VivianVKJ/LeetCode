import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=630 lang=java
 * [[7,16],[2,3],[3,12],[3,14],[10,19],[10,16],[6,8],[6,11],[3,13],[6,16]]
 * [630] Course Schedule III
 */

// @lc code=start
class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if (n == 0)
            return 0;
        Arrays.sort(courses, (x, y) -> (x[1] - y[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int tail = 0;
        for (int i = 0; i < n; i++) {
            if (tail + courses[i][0] <= courses[i][1]) {
                pq.add(courses[i][0]);
                tail += courses[i][0];
            } else if (!pq.isEmpty() && pq.peek() > courses[i][0]) {
                tail += courses[i][0] - pq.poll();
                pq.add(courses[i][0]);
            }
        }
        return pq.size();
    }
}
// @lc code=end
