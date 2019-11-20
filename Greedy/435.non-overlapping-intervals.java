/*1
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals_greedy(int[][] intervals) {
        //greedy: activity selector, n-activity
        int n = intervals.length;
        if(n<=1) return 0;
        Arrays.sort(intervals,((x,y)->x[1]-y[1])); //sort with end time
        int maxInterval = 0;
        for(int i=0;i<n;i++){
            maxInterval++;
            int end = intervals[i][1];
            while(i+1<n && intervals[i+1][0]<end)
                i++;
        }
        return intervals.length-maxInterval;
    }
    public int eraseOverlapIntervals(int[][] intervals){
        //dynamic programming
        int n = intervals.length;
        if(n<=1) return 0;
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<n+1;i++){
            
        }
    }
}
// @lc code=end

