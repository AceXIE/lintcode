import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/11.
 */
public class InsertInterval {
    public static void main(String[] args) {
        Interval n = new Interval(3,4);
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(5,9);
        ArrayList<Interval> arrayList = new ArrayList<Interval>();
        arrayList.add(interval1);arrayList.add(interval2);
        System.out.print(insert(arrayList, n));
    }
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval == null ) return intervals;
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) {
                result.add(cur);
            } else if (cur.start > newInterval.end) {
                result.add(newInterval);
                newInterval = cur;
            } else if (cur.end >= newInterval.start || cur.start <= newInterval.end) {
                newInterval = new Interval(Math.min(cur.start, newInterval.start), Math.max(cur.end, newInterval.end));
            }
        }

        result.add(newInterval);
        return result;
    }
}
