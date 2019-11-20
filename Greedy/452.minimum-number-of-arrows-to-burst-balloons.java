/*
 * @lc app=leetcode id=452 lang=java
 *         [10 16
 * [2    8]
 *[1 6]
 *     [7  12]
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points,((x,y)->x[1]-y[1]));
        int count = 1, arrow = points[0][1];
        for(int i =0;i<points.length;i++){
            if(arrow>points[i][1] || arrow<points[i][0]){
                count++;
                arrow = points[i][1];
            }
        }
        return count;
    }
}
// @lc code=end

