/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals){
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals,((x,y) -> x[0]-y[0]));
        LinkedList<int[]> result = new LinkedList<>();
        int[] latest = intervals[0];
        result.add(latest);
        for(int[] temp : intervals){
            if(temp[0]<=result.getLast()[1])
                result.getLast()[1]= Math.max(temp[1],result.getLast()[1]);
            else
                result.add(temp);
        }
        return result.toArray(new int[0][0]);
    }
    public int[][] merge_array(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals, ((x, y) -> x[0] - y[0]));

        List<int[]> result = new ArrayList<>();
        int[] latest = intervals[0];
        result.add(latest);
        for(int[] temp : intervals){
            if(temp[0]<=latest[1]){
                latest[1] = Math.max(temp[1],latest[1]);
            }
            else{
                result.add(temp);
                latest = temp;
            }
        } 
        return result.toArray(new int[0][0]);
    }
}

