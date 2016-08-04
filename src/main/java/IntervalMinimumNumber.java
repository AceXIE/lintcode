import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/4.
 */
public class IntervalMinimumNumber {

    public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
        if (A == null || queries == null) return null;
        SegmentTreeNode root = buildSegmentTree(A, 0, A.length - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Interval interval : queries) {
            ans.add(helperQuery(root, interval.start, interval.end));
        }
        return ans;
    }
    public Integer helperQuery(SegmentTreeNode root, int start, int end) {
        if (start > end || start > root.end || end < root.start) {
            return Integer.MIN_VALUE;
        }
        if (start <= root.start && end >= root.end) {
            return root.max;
        }
        int mid = (root.start+root.end)/2;
        int leftmin = helperQuery(root.left, start, Math.min(mid,end));
        int rightmin = helperQuery(root.right, Math.max(mid, start), end);
        return Math.min(leftmin, rightmin);
    }
    public SegmentTreeNode buildSegmentTree(int[] A, int start, int end) {
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = (start + end) /2;
            root.left = buildSegmentTree(A, start, mid);
            root.right = buildSegmentTree(A, mid + 1, end);
        }
        root.max = Math.min(root.right.max, root.left.max);
        return root;
    }
}
