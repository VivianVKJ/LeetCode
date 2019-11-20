/*
 * @lc app=leetcode id=253 lang=java
 * [[2,15],[36,45],[9,29],[16,23],[4,9]]
 * [[9,16],[6,16],[1,9],[3,15]]
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length<=1) return intervals.length;
        Arrays.sort(intervals,((x,y)->x[0]-y[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        int room = 1;
        for(int i=1;i<intervals.length;i++){
            if(pq.peek()<=intervals[i][0]){
                 //peek is free now
                 pq.poll();
                //System.out.print("top free. ");
            }
            else{
                room++;
                //System.out.print("room->"+room+" ");
            }
            pq.add(intervals[i][1]);
        }
        return room;

    }
}
// @lc code=end

