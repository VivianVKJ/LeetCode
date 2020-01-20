/*
 * @lc app=leetcode id=759 lang=java
 *
 * [759] Employee Free Time
 */

// @lc code=start
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();
        for(int i=0;i<schedule.size();i++){
            List<Interval> curr = schedule.get(i);
            for(Interval in : curr){
                all.add(in);
            }
        }
        int[][] allgroup = new int[all.size()][2];
        for(int i=0;i<all.size();i++){
            allgroup[i][0] = all.get(i).start;
            allgroup[i][1] = all.get(i).end;
        }
        Arrays.sort(allgroup,(x,y)->(x[0]-y[0]));
        
        List<Interval> ans = new ArrayList<>();
        int[] curr = allgroup[0];

        for(int i=0;i<allgroup.length;i++){
            if(allgroup[i][0]<=curr[1]){
                curr[1] = Math.max(curr[1],allgroup[i][1]);
            }
            else{
                ans.add(new Interval(curr[1],allgroup[i][0]));
                curr = allgroup[i];
            }
        }
        return ans;
    }
}
// @lc code=end
//(1,2)(1,3)(4,10)(5,6)
