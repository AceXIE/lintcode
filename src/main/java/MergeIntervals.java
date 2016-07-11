import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

/**
 * Created by Administrator on 2016/7/11.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};
        List<Interval> intervals = new LinkedList<Interval>();
        for (int i = 0; i < nums.length; i++) {
            Interval interval = new Interval(nums[i][0], nums[i][1]);
            intervals.add(interval);
        }
        List<Interval> ans = merge(intervals);
        for (Interval a : ans) {
            System.out.print(a);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() == 0) return new LinkedList<Interval>();

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> result = new LinkedList<Interval>();
        Interval newInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval.end < cur.start) {
                result.add(newInterval);
                newInterval = cur;
            } else {
                newInterval = new Interval(Math.min(newInterval.start, cur.start), Math.max(newInterval.end, cur.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}
