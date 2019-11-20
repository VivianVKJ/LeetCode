/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,((x,y) -> x[0]-y[0]));
        boolean ans = true;
        for(int i =1;i<intervals.length;i++)
            if(intervals[i][0]<intervals[i-1][1]){
                ans = false;
                break;
            }
        return ans;
    }
}
// @lc code=end

