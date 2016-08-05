import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/9.
 */
public class IntervalSum {
//    public static void main(String[] args) {
//        int[] A = {1,2,7,8,5};
//        ArrayList<Interval> queries = new ArrayList<Interval>();
//        Interval interval0 = new Interval(0,4);
//        Interval interval1 = new Interval(1,2);
//        Interval interval2 = new Interval(2,4);
//        queries.add(interval0);queries.add(interval1);queries.add(interval2);
//        ArrayList<Long> longArrayList = intervalSum(A, queries);
//        System.out.print(longArrayList);
//    }
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        if (A == null) return null;
        ArrayList<Long> arrayList = new ArrayList<>();
        SegmentSumTreeNode root = buildSegmentTree(A, 0, A.length - 1);
        for (Interval interval : queries) {
            arrayList.add(querySegment(root, interval.start, interval.end));
        }
        return arrayList;
    }
    public Long querySegment(SegmentSumTreeNode root, int start, int end) {
        if (start > end || start > root.end || end < root.start) {
            return (long)0;
        }
        if (start <= root.start && end >= root.end) {
            return root.sum;
        }
        int mid = (root.start + root.end)/2;
        long leftSum = querySegment(root.left, start, Math.min(end,mid));
        long rightSum = querySegment(root.right, Math.max(mid, start), end);
        return leftSum+rightSum;
    }
    public SegmentSumTreeNode buildSegmentTree(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentSumTreeNode(start, end, A[start]);
        }
        SegmentSumTreeNode root = new SegmentSumTreeNode(start, end, 0);
        if (start != end) {
            int mid = (start + end) /2;
            root.left = buildSegmentTree(A, start, mid);
            root.right = buildSegmentTree(A, mid + 1, end);
        }
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
}
class SegmentSumTreeNode {
    int start;
    int end;
    long sum;
    SegmentSumTreeNode left, right;

    public SegmentSumTreeNode(int start, int end, long sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = null;
        this.right = null;
    }
}
