package Greedy;

import java.util.ArrayList;
import java.util.List;

public class employee_free_time {
    public static class Interval {
        public int start;
        public int end;

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public static void main(String[] args) {

    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int ngroup = schedule.size();
        List base = schedule.get(0);
        for (int i = 0; i < ngroup; i++) {
            base = mergebase(base, schedule.get(i));
        }
        List<Interval> ans = new ArrayList<>();
        for (int i = 1; i < ans.size(); i++) {
            Interval pre = ans.get(i - 1), curr = ans.get(i);
            if (curr.start > pre.end)
                ans.add(new Interval(pre.end, curr.start));
        }
        return ans;
    }

    public static List<Interval> mergebase(List<Interval> base, List<Interval> curr) {
        int index = 0;
        for (int i = 0; i < curr.size(); i++) {
            Interval base_in = base.get(index), curr_in = curr.get(i);
            if (base_in.start > curr_in.end) {
                base.add(new Interval(curr_in.start, curr_in.end));
            } else if (base_in.start <= curr_in.end || base_in.end >= curr_in.start) {
                base_in.start = Math.min(base_in.start, curr_in.start);
                base_in.end = Math.max(base_in.end, curr_in.end);
                base.set(index, base_in);
            } else index++;
        }
        return base;
    }
}
