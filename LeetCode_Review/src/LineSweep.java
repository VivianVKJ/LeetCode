import java.io.*;
import java.lang.*;
import java.util.*;


public class LineSweep {
    public static class Interval {
        public int start;
        public int end;
        public Interval() {}
        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
    public static void main(String[] args)  {
//       int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][][] schedule = { {{1,2},{5,6}},{{1,3},{4,10}}};
        List<List<Interval>> input_schedule = new ArrayList<>();
        for(int i=0;i<schedule.length;i++){
            int[][] curr = schedule[i];
            List<Interval> group = new ArrayList<>();
            for(int j=0;j<curr.length;j++){
                group.add(new Interval(curr[j][0],curr[j][1]));
            }
            input_schedule.add(group);
        }
        employeeFreeTime(input_schedule);
//        int[] newInterval = {19,20};
//        insert(intervals,newInterval);
    }

    //56.Merge Intervals
//    public static int[][] merge_array(int[][] intervals) {
//        if(intervals.length<=1)
//            return intervals;
//        Arrays.sort(intervals, ((x, y) -> x[0] - y[0]));
//
//        List<int[]> result = new ArrayList<>();
//        int[] latest = intervals[0];
//        result.add(latest);
//        for(int[] temp : intervals){
//            if(temp[0]<=latest[1]){
//                latest[1] = Math.max(temp[1],latest[1]);
//            }
//            else{
//                result.add(temp);
//                latest = temp;
//            }
//        }
//        return result.toArray(new int[0][0]);
//    }

    //57.Insert Interval
/*    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int[] merge = newInterval;
        int i=0;
        while( i<n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        merge[0] = Math.min(intervals[i][0], newInterval[0]);
        while(i<n && intervals[i][0]<= newInterval[1]){
            i++;
        }
        //corner case
        if(i!=0)
            merge[1] = Math.max(intervals[i-1][1],newInterval[1]);
        ans.add(merge);
        while(i<n){
            ans.add(intervals[1]);
            i++;
        }
        return ans.toArray(new int[0][0]);
    }*/

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
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
