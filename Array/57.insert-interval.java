/*
 * @lc app=leetcode id=57 lang=java
 * <1> [[1,2],[3,5],[6,7],[8,10],[12,16]]\n[19,20]
 * <2>[[3,5],[6,7],[8,10],[12,16]]\n[1,2]
 * <3> [[1,2],[6,7],[8,10],[12,16]]\n[3,4] -> still right
 * ---- -----     ----
 *          | --
 *          1 01 0   
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    //basketwang solution
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int[] merge = newInterval;
        int i=0;
        while( i<n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        if(i==n)  //corner case
            ans.add(newInterval);
        else{
            merge[0] = Math.min(intervals[i][0], newInterval[0]);
            while(i<n && intervals[i][0]<= newInterval[1]){
                i++;
            }
            if(i!=0)   //corner case
                merge[1] = Math.max(intervals[i-1][1],newInterval[1]);
            ans.add(merge);
            while(i<n){
                ans.add(intervals[i]);
                i++;
            }
        }
        return ans.toArray(new int[0][0]);
    }
}
// @lc code=end

